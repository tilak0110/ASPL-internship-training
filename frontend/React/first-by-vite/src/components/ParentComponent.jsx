import ChildComponent from './ChildComponent';

function ParentComponent({ user }) {
  return (
    <div>
      <h2>Parent Component</h2>
      <ChildComponent user={user} />
    </div>
  );
}

export default ParentComponent;
