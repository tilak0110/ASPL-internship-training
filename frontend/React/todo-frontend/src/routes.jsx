import React from 'react';

import Login from './auth/Login';
import Register from './auth/Register';
import Dashboard from './pages/Dashboard';
import ProtectedRoute from './ProtectedRoute';

const routes = [
  {
    path: '/',
    element: <Login />,
  },
  {
    path: '/register',
    element: <Register />,
  },
  {
    path: '/dashboard',
    element: 
    <ProtectedRoute>
      <Dashboard />
    </ProtectedRoute>,
  },
];

export default routes;
