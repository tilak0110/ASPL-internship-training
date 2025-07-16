import { useEffect, useRef, useState } from "react";
import { useAuth } from "../auth/AuthContext";
import axiosInstance from "../api/axios";
import { toast } from "react-toastify";

const Dashboard = () => {
  const { user } = useAuth();
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [dueDate, setDueDate] = useState("");

  const [editId, setEditId] = useState(null);
  const [editTodo, setEditTodo] = useState({ title: "", description: "", dueDate: "" });

  const isOverdue = (dueDate) => new Date(dueDate) < new Date();

  const [sortBy, setSortBy] = useState("dueDate");
  const [filter, setFilter] = useState("all");

  const [searchQuery, setSearchQuery] = useState("");

  const totalTodos = todos.length;
  const completedTodos = todos.filter(todo => todo.completed).length;
  const pendingTodos = totalTodos - completedTodos;
  

  const isDueSoon = (dueDate) => {
  const now = new Date();
  const due = new Date(dueDate);
  const diff = due - now;
  return diff > 0 && diff <= 24 * 60 * 60 * 1000; //24 hrs
  };

  const dueSoonTodos = todos.filter(todo => 
  !todo.completed && isDueSoon(todo.dueDate)
  );

  const remindedTodos = useRef(new Set());

  useEffect(() => {
  if ("Notification" in window && Notification.permission !== "granted") {
    Notification.requestPermission();
  }
  }, []);

  useEffect(() => {
  const interval = setInterval(() => {
    const now = new Date();

    todos.forEach((todo) => {
      const due = new Date(todo.dueDate);
      const diff = due - now;

      const shouldRemind =
        !todo.completed &&
        diff > 0 &&
        diff <= 10 * 60 * 1000 && 
        !remindedTodos.current.has(todo.id);

      if (shouldRemind) {
     
        toast.info(`⏰ "${todo.title}" is due in ${Math.ceil(diff / 60000)} mins!`);

        
        if (Notification.permission === "granted") {
          new Notification("Todo Reminder", {
            body: `"${todo.title}" is due soon!`,
            icon: "/productivity.png",
          });
        }

      
        remindedTodos.current.add(todo.id);
      }
    });
  }, 30000); 

  return () => clearInterval(interval);
}, [todos]);




  const sortTodosByDueDate = (todos) =>
    todos.slice().sort((a, b) => new Date(a.dueDate) - new Date(b.dueDate));

  const filterTodos = (todos) => {
    switch (filter) {
      case "completed":
        return todos.filter((todo) => todo.completed);
      case "pending":
        return todos.filter((todo) => !todo.completed);
      default:
        return todos;
    }
  };

  const sortTodos = (todos) => {
    if (sortBy === "dueDate") {
      return [...todos].sort((a, b) => new Date(a.dueDate) - new Date(b.dueDate));
    } else if (sortBy === "status") {
      return [...todos].sort((a, b) => a.completed - b.completed);
    }
    return todos;
  };

  const visibleTodos = sortTodos(
  filterTodos(todos).filter((todo) =>
    todo.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
    todo.description.toLowerCase().includes(searchQuery.toLowerCase())
  )
);


  useEffect(() => {
    if (!user?.id) return;

    const fetchTodos = async () => {
      try {
        const res = await axiosInstance.get(`/todo/user/${user.id}`);
        setTodos(sortTodosByDueDate(res.data));
      } catch (err) {
        toast.error("❌ Failed to fetch todos");
      } finally {
        setLoading(false);
      }
    };

    fetchTodos();
  }, [user]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const payload = {
        title,
        description,
        dueDate,
        completed: false,
        createdAt: new Date().toISOString(),
      };
      const res = await axiosInstance.post(`/todo/${user.id}`, payload);
      setTodos((prev) => sortTodosByDueDate([...prev, res.data]));
      setTitle("");
      setDescription("");
      setDueDate("");
      toast.success("✅ Todo added!");
    } catch (error) {
      toast.error("❌ Failed to add todo");
    }
  };

  const toggleTodo = async (id) => {
    try {
      const todo = todos.find((t) => t.id === id);
      const res = await axiosInstance.put(`/todo/${id}`, {
        ...todo,
        completed: !todo.completed,
      });
      setTodos((prev) =>
        sortTodosByDueDate(prev.map((t) => (t.id === id ? res.data : t)))
      );
      toast.info("🔁 Status toggled");
    } catch (err) {
      toast.error("❌ Toggle failed");
    }
  };

  const deleteTodo = async (id) => {
    try {
      await axiosInstance.delete(`/todo/${id}`);
      setTodos((prev) => prev.filter((t) => t.id !== id));
      toast.success("🗑️ Todo deleted");
    } catch (err) {
      toast.error("❌ Delete failed");
    }
  };

  const startEdit = (todo) => {
    setEditId(todo.id);
    setEditTodo({
      title: todo.title,
      description: todo.description,
      dueDate: todo.dueDate?.slice(0, 16),
    });
  };

  const handleEditChange = (e) => {
    setEditTodo({ ...editTodo, [e.target.name]: e.target.value });
  };

  const saveEdit = async (id) => {
    try {
      const res = await axiosInstance.put(`/todo/${id}`, {
        ...editTodo,
        userId: user.id,
      });
      setTodos((prev) =>
        sortTodosByDueDate(prev.map((t) => (t.id === id ? res.data : t)))
      );
      setEditId(null);
      toast.info("✏️ Todo updated");
    } catch (err) {
      toast.error("❌ Update failed");
    }
  };

  const clearCompleted = async () => {
  try {
    const deleteCount = await axiosInstance.delete(`/todo/completed/${user.id}`);
    toast.info(`🧹✔️ ${deleteCount.data} Completed Tasks Deleted successfully`)
    setTodos((prev) => prev.filter((todo) => !todo.completed));
  } catch (err) {
    console.error("❌ Failed to clear completed todos", err);
  }
  };


  return (
  <div className="container my-4">
    <h2 className="mb-4">👋 Welcome, {user?.sub}!</h2>

    {dueSoonTodos.length > 0 && (
      <div className="alert alert-warning d-flex align-items-center" role="alert">
        <strong>⏰ Heads up!</strong>&nbsp;
        You have {dueSoonTodos.length} task{dueSoonTodos.length > 1 && "s"} due soon.
      </div>
    )}

    {/* Form */}
    <form onSubmit={handleSubmit} className="card p-4 mb-4 shadow-sm">
      <h4 className="mb-3">Add a New Todo</h4>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
      </div>
      <div className="mb-3">
        <textarea
          className="form-control"
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        ></textarea>
      </div>
      <div className="mb-3">
        <input
          type="datetime-local"
          className="form-control"
          value={dueDate}
          onChange={(e) => setDueDate(e.target.value)}
          required
        />
      </div>
      <button type="submit" className="btn btn-primary">➕ Add Todo</button>
    </form>

    {/* Sort/Filter/Search */}
    <div className="d-flex flex-wrap gap-3 mb-4">
      <div>
        <label className="form-label me-2">Sort By:</label>
        <select className="form-select" value={sortBy} onChange={(e) => setSortBy(e.target.value)}>
          <option value="dueDate">Due Date</option>
          <option value="status">Status</option>
        </select>
      </div>

      <div>
        <label className="form-label me-2">Filter:</label>
        <select className="form-select" value={filter} onChange={(e) => setFilter(e.target.value)}>
          <option value="all">All</option>
          <option value="completed">Completed</option>
          <option value="pending">Pending</option>
        </select>
      </div>

      <div className="flex-grow-1">
        <label className="form-label me-2">Search:</label>
        <input
          type="text"
          className="form-control"
          placeholder="Search by title or description"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </div>
    </div>

    {/* Clear Completed + Stats */}
    <div className="d-flex justify-content-between align-items-center mb-3">
      <button onClick={clearCompleted} className="btn btn-outline-danger">
        🧹 Clear Completed
      </button>
      <div className="fw-bold">
        📋 Total: {totalTodos} &nbsp; ✅ Completed: {completedTodos} &nbsp; ⏳ Pending: {pendingTodos}
      </div>
    </div>

    {/* Todo List */}
    {loading ? (
      <p>⏳ Loading todos...</p>
    ) : visibleTodos.length === 0 ? (
      <p>📝 No Todos Found.</p>
    ) : (
      <ul className="list-group">
        {visibleTodos.map((todo) => (
          <li key={todo.id} className="list-group-item">
            {editId === todo.id ? (
              <>
                <div className="mb-2">
                  <input
                    type="text"
                    name="title"
                    className="form-control mb-2"
                    value={editTodo.title}
                    onChange={handleEditChange}
                  />
                  <input
                    type="text"
                    name="description"
                    className="form-control mb-2"
                    value={editTodo.description}
                    onChange={handleEditChange}
                  />
                  <input
                    type="datetime-local"
                    name="dueDate"
                    className="form-control mb-2"
                    value={editTodo.dueDate}
                    onChange={handleEditChange}
                  />
                  <div className="d-flex gap-2">
                    <button onClick={() => saveEdit(todo.id)} className="btn btn-success btn-sm">
                      💾 Save
                    </button>
                    <button onClick={() => setEditId(null)} className="btn btn-secondary btn-sm">
                      ❌ Cancel
                    </button>
                  </div>
                </div>
              </>
            ) : (
              <>
                <div className="d-flex justify-content-between align-items-start">
                  <div>
                    <h5 className="mb-1">{todo.title}</h5>
                    <p className="mb-1">{todo.description}</p>
                    <p className="mb-1 text-muted">
                      🗓️ <strong>Due:</strong>{" "}
                      {new Date(todo.dueDate).toLocaleString("en-IN", {
                        dateStyle: "medium",
                        timeStyle: "short",
                      })}
                    </p>
                    <small
                      className={
                        "badge " +
                        (todo.completed
                          ? "bg-success"
                          : isOverdue(todo.dueDate)
                          ? "bg-danger"
                          : isDueSoon(todo.dueDate)
                          ? "bg-warning text-dark"
                          : "bg-secondary")
                      }
                    >
                      {todo.completed
                        ? "✔️ Done"
                        : isOverdue(todo.dueDate)
                        ? "⚠️ Overdue"
                        : isDueSoon(todo.dueDate)
                        ? "⏰ Due Soon"
                        : "⏳ Pending"}
                    </small>
                  </div>
                  <div className="d-flex flex-column gap-2 align-items-end">
                    <button onClick={() => toggleTodo(todo.id)} className="btn btn-outline-primary btn-sm">
                      🔁 Toggle
                    </button>
                    <button onClick={() => deleteTodo(todo.id)} className="btn btn-outline-danger btn-sm">
                      🗑️ Delete
                    </button>
                    <button onClick={() => startEdit(todo)} className="btn btn-outline-secondary btn-sm">
                      ✏️ Edit
                    </button>
                  </div>
                </div>
              </>
            )}
          </li>
        ))}
      </ul>
    )}
  </div>
);


};

export default Dashboard;
