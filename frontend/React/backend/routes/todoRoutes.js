import express from "express";
import {
  getTodosByUser,
  addTodo,
  updateTodo,
  deleteTodo,
  clearCompletedTodos,
} from "../controllers/todoController.js";

const router = express.Router();

router.get("/user/:userId", getTodosByUser);
router.post("/:userId", addTodo);
router.put("/:id", updateTodo);
router.delete("/:id", deleteTodo);
router.delete("/completed/:userId", clearCompletedTodos);

export default router;
