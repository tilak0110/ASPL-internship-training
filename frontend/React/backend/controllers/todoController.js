import { pool } from "../config/db.js";

export const getTodosByUser = async (req, res) => {
  try {
    const [rows] = await pool.query("SELECT * FROM todos WHERE userId = ?", [req.params.userId]);
    res.json(rows);
  } catch {
    res.status(500).json("Failed to fetch todos");
  }
};

export const addTodo = async (req, res) => {
  const { title, description, dueDate, completed, createdAt } = req.body;
  const { userId } = req.params;

  try {
    const [result] = await pool.query(
      "INSERT INTO todos (title, description, dueDate, completed, createdAt, userId) VALUES (?, ?, ?, ?, ?, ?)",
      [title, description, dueDate, completed, createdAt, userId]
    );
    const [todo] = await pool.query("SELECT * FROM todos WHERE id = ?", [result.insertId]);
    res.status(201).json(todo[0]);
  } catch {
    res.status(500).json("Failed to add todo");
  }
};

export const updateTodo = async (req, res) => {
  const { title, description, dueDate, completed, userId } = req.body;
  const { id } = req.params;

  try {
    await pool.query(
      "UPDATE todos SET title = ?, description = ?, dueDate = ?, completed = ?, userId = ? WHERE id = ?",
      [title, description, dueDate, completed, userId, id]
    );
    const [todo] = await pool.query("SELECT * FROM todos WHERE id = ?", [id]);
    res.json(todo[0]);
  } catch {
    res.status(500).json("Failed to update todo");
  }
};

export const deleteTodo = async (req, res) => {
  try {
    await pool.query("DELETE FROM todos WHERE id = ?", [req.params.id]);
    res.sendStatus(204);
  } catch {
    res.status(500).json("Failed to delete todo");
  }
};

export const clearCompletedTodos = async (req, res) => {
  try {
    const [result] = await pool.query("DELETE FROM todos WHERE userId = ? AND completed = 1", [req.params.userId]);
    res.json(result.affectedRows);
  } catch {
    res.status(500).json("Failed to clear completed todos");
  }
};
