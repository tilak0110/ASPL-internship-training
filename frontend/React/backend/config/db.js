import mysql from "mysql2";
import dotenv from "dotenv";
dotenv.config();

const pool = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
}).promise();

const connectDB = async () => {
  try {
    await pool.query("SELECT 1");
    console.log("📦 Connected to MySQL database");
  } catch (err) {
    console.error("❌ MySQL connection failed:", err);
    process.exit(1);
  }
};

export { pool };
export default connectDB;
