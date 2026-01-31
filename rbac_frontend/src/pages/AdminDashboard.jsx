import React from 'react'
import { useAuth } from '../context/AuthContext'
import { useNavigate } from 'react-router-dom';

const AdminDashboard = () => {
  const {logout,user}=useAuth();
  const navigate=useNavigate();
  return (
   <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded-xl shadow-lg w-90">
        <h2 className="text-2xl font-semibold text-gray-800 text-center mb-2">
          Admin Dashboard
        </h2>

        <p className="text-center text-gray-600 mb-6">
          Welcome, <span className="font-medium">{user.sub}</span>
        </p>

        <div className="bg-green-50 text-green-700 p-4 rounded-lg mb-6 text-sm">
          <p className="font-semibold mb-2">Admin Permissions:</p>
          <ul className="list-disc list-inside space-y-1">
            <li>Read users</li>
            <li>Create / update data</li>
            <li>Assign roles</li>
          </ul>
        </div>

        <button
          onClick={()=>{logout,navigate('/login')}}
          className="w-full bg-red-600 text-white py-2 rounded-lg hover:bg-red-700 transition"
        >
          Logout
        </button>
      </div>
    </div>
  )
}

export default AdminDashboard
