
export default function UserCard({ name, age, email }) {
  return (
    <div style={{ border: '1px solid black', padding: '1rem', margin: '1rem' }}>
      <h2>{name}</h2>
      <p>Age: {age}</p>
      <p>Email: {email}</p>
    </div>
  );
}
