import React, { useState } from 'react';

export function NameForm() {
  const [name, setName] = useState('');
  const [form, setForm] = useState({ name: '', age: '' });

  return (
    <div>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
        <input
        name="name"
        value={form.name}
        onChange={(e) => setForm({ ...form, name: e.target.value })}
        />
         <input
        name="age"
        value={form.age}
        onChange={(e) => setForm({ ...form, age: e.target.value })}
        />
      <p>Your name is: {name}</p>
      <p>Your name is: {form.name} and age is :{form.age}</p>
    </div>
  );
}
