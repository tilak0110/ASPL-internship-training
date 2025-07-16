import React from 'react';
import GrandChildComponent from './GrandChildComponent';

function ChildComponent({ user }) {
  return (
    <div>
      <h3>Child Component</h3>
      <GrandChildComponent user={user} />
    </div>
  );
}

export default ChildComponent;
