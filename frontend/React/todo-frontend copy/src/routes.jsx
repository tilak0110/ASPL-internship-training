import React from 'react';

import Login from './auth/Login';
import Register from './auth/Register';
import Dashboard from './pages/Dashboard';
import ProtectedRoute from './ProtectedRoute';
import Profile from './pages/Profile';

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
  {
    path: '/profile',
    element: <ProtectedRoute>
        <Profile/>
        </ProtectedRoute>
  },
];

export default routes;
