import React, { useState } from 'react';

function UserForm({ onCitySubmit }) {
  const [cityInput, setCityInput] = useState('');

  const handleSubmit = () => {
    onCitySubmit(cityInput); // send to parent
    setCityInput(''); // clear input
  };

  return (
    <div>
      <h3>User Form</h3>
      <input
        type="text"
        placeholder="Enter your city"
        value={cityInput}
        onChange={(e) => setCityInput(e.target.value)}
      />
      <button onClick={handleSubmit}>Submit City</button>
    </div>
  );
}

export default UserForm;
