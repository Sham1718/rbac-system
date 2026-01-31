import React from 'react'
import { Link } from 'react-router-dom'

const UnAuthorize = () => {
  return (
     <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded-xl shadow-lg w-90 text-center">
        <h2 className="text-2xl font-semibold text-red-600 mb-4">
          403 – Unauthorized
        </h2>

        <p className="text-gray-600 mb-6">
          You don’t have permission to access this page.
        </p>

        <Link to="/login">
          <button className="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition">
            Go to Login
          </button>
        </Link>
      </div>
    </div>
  )
}

export default UnAuthorize
