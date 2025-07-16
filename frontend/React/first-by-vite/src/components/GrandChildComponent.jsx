import React from 'react';

function GrandChildComponent({ user }) {
  return (
    <div>
      <h4>GrandChild Component</h4>
      <p><strong>Name:</strong> {user.name}</p>
      <p><strong>Email:</strong> {user.email}</p>
    </div>
  );
}

export default GrandChildComponent;
