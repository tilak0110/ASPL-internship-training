import React, { useState } from 'react';
import UserForm from './UserForm';

function Dashboard() {
  const [city, setCity] = useState('');

  // Function to receive data from child
  const updateCity = (cityName) => {
    setCity(cityName);
  };

  return (
    <div>
      <h2>Dashboard</h2>
      <p><strong>Selected City:</strong> {city}</p>
      <UserForm onCitySubmit={updateCity} />
    </div>
  );
}

export default Dashboard;
