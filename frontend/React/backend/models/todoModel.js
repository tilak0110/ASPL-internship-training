import pool from "../config/db.js";

export const getTodosByUser = async (userId) => {
  const [rows] = await pool.query("SELECT * FROM todos WHERE userId = ?", [userId]);
  return rows;
};

export const createTodo = async (todo) => {
  const [result] = await pool.query(
    "INSERT INTO todos (title, description, dueDate, completed, createdAt, userId) VALUES (?, ?, ?, ?, ?, ?)",
    [todo.title, todo.description, todo.dueDate, todo.completed, todo.createdAt, todo.userId]
  );
  return { id: result.insertId, ...todo };
};

export const updateTodo = async (id, data) => {
  await pool.query(
    "UPDATE todos SET title=?, description=?, dueDate=?, completed=? WHERE id=?",
    [data.title, data.description, data.dueDate, data.completed, id]
  );
  return { id, ...data };
};

export const deleteTodo = async (id) => {
  await pool.query("DELETE FROM todos WHERE id = ?", [id]);
};

export const deleteCompletedTodos = async (userId) => {
  const [result] = await pool.query("DELETE FROM todos WHERE userId = ? AND completed = 1", [userId]);
  return result.affectedRows;
};
