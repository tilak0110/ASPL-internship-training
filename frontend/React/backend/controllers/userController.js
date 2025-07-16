import jwt from "jsonwebtoken";
import { pool } from "../config/db.js";

export const loginUser = async (req, res) => {
  const { username, password } = req.body;

  try {
    const [rows] = await pool.query("SELECT * FROM users WHERE username = ? AND password = ?", [username, password]);

    if (rows.length === 0) {
      return res.status(401).json("Invalid credentials");
    }

    const user = rows[0];
    const token = jwt.sign({ id: user.id, sub: user.username }, process.env.JWT_SECRET);
    res.json(token);
  } catch (err) {
    res.status(500).json("Login failed");
  }
};

export const registerUser = async (req, res) => {
  const { username, password, email } = req.body;

  try {
    const [check] = await pool.query("SELECT * FROM users WHERE username = ?", [username]);
    if (check.length > 0) {
      return res.status(400).json("Username already exists");
    }

    await pool.query("INSERT INTO users (username, password, email) VALUES (?, ?, ?)", [username, password, email]);
    res.status(201).json("User registered");
  } catch (err) {
    res.status(500).json("Registration failed");
  }
};
 