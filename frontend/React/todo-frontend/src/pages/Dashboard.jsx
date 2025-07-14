import { useEffect, useState } from "react";
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
    <div style={{ padding: "1rem" }}>
      <h2>Welcome, {user?.sub}!</h2>

      <form onSubmit={handleSubmit} style={{ marginBottom: "2rem" }}>
        <h3>Add a New Todo</h3>
        <input type="text" placeholder="Title" value={title} onChange={(e) => setTitle(e.target.value)} required />
        <br /><br />
        <textarea placeholder="Description" value={description} onChange={(e) => setDescription(e.target.value)} required />
        <br /><br />
        <input type="datetime-local" value={dueDate} onChange={(e) => setDueDate(e.target.value)} required />
        <br /><br />
        <button type="submit">➕ Add Todo</button>
      </form>

      <div>
        <label htmlFor="sort">Sort By: </label>
        <select id="sort" value={sortBy} onChange={(e) => setSortBy(e.target.value)}>
          <option value="dueDate">Due Date</option>
          <option value="status">Status</option>
        </select>
      </div>

      <div>
        <label htmlFor="filter">Filter: </label>
        <select id="filter" value={filter} onChange={(e) => setFilter(e.target.value)}>
          <option value="all">All</option>
          <option value="completed">Completed</option>
          <option value="pending">Pending</option>
        </select>
      </div>
      <div>
        <label htmlFor="search">Search: </label>
        <input
          id="search"
          type="text"
          placeholder="Search by title or description"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </div>
      <div style={{ marginTop: "1rem" }}>
        <button onClick={clearCompleted}>🧹 Clear Completed</button>
      </div>
      <div style={{ marginTop: "1rem", marginBottom: "1rem", fontWeight: "bold" }}>
        📋 Total: {totalTodos} &nbsp;&nbsp;
        ✅ Completed: {completedTodos} &nbsp;&nbsp;
        ⏳ Pending: {pendingTodos}
      </div>




      {loading ? (
        <p>⏳ Loading todos...</p>
      ) : todos.length === 0 ? (
        <p>📝 No Todos Yet.</p>
      ) : (
        <ul>
          {visibleTodos.map((todo) => (
            <li key={todo.id} style={{ marginBottom: "1rem" }}>
              {editId === todo.id ? (
                <>
                  <input type="text" name="title" value={editTodo.title} onChange={handleEditChange} />
                  <input type="text" name="description" value={editTodo.description} onChange={handleEditChange} />
                  <input type="datetime-local" name="dueDate" value={editTodo.dueDate} onChange={handleEditChange} />
                  <button onClick={() => saveEdit(todo.id)}>💾 Save</button>
                  <button onClick={() => setEditId(null)}>❌ Cancel</button>
                </>
              ) : (
                <>
                  <strong>{todo.title}</strong> -{" "}
                  <span style={{ color: isOverdue(todo.dueDate) && !todo.completed ? "red" : "black" }}>
                    {todo.completed ? "✔️ Done" : isOverdue(todo.dueDate) ? "⚠️ Overdue" : "⏳ Pending"}
                  </span>
                  <br />
                  <div>{todo.description}</div>
                  <button onClick={() => toggleTodo(todo.id)}>🔁 Toggle</button>
                  <button onClick={() => deleteTodo(todo.id)}>🗑️ Delete</button>
                  <button onClick={() => startEdit(todo)}>✏️ Edit</button>
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
