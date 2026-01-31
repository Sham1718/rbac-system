import React from 'react'
import { useAuth } from '../context/AuthContext'
import { useNavigate } from 'react-router-dom';

const Dashboard = () => {
  const {logout,user}=useAuth();
  const navigate=useNavigate();

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded-xl shadow-lg w-90 text-center">
        <h2 className="text-2xl font-semibold text-gray-800 mb-2">
          User Dashboard
        </h2>

        <p className="text-gray-600 mb-6">
          Welcome, <span className="font-medium">{user.sub}</span>
        </p>

        <div className="bg-blue-50 text-blue-700 p-4 rounded-lg mb-6 text-sm">
          You have <b>read-only</b> access.<br />
          Write and role assignment actions are restricted.
        </div>

        <button
          onClick={() => {
    logout();
    navigate("/login");
  }}
        
          className="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition"
        >
          Logout
        </button>
      </div>
    </div>
  )
}

export default Dashboard
