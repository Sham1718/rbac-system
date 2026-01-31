import { Route ,Routes,BrowserRouter } from 'react-router-dom'
import './App.css'
import Login from './pages/Login'
import RequiredAuth from './component/RequiredAuth'
import Register from './pages/Register'
import UnAuthorize from './pages/UnAuthorize'
import Dashboard from './pages/Dashboard'
import AdminDashboard from './pages/AdminDashboard'

function App() {
  

  return (
    <BrowserRouter>
    <Routes>
    <Route path='/login' element={<Login/>}/>
    <Route path='/register' element={<Register/>}/>
    <Route path='/admin' element={
       <RequiredAuth permission="ROLE_ASSIGN">
                <AdminDashboard />
              </RequiredAuth>
    }/>
    <Route path='/dashboard' element={
       <RequiredAuth permission="USER_READ">
                <Dashboard/>
              </RequiredAuth>}/>
    <Route path='/unAuthorize' element={<UnAuthorize/>}/>
    </Routes>
    </BrowserRouter>
  )
}

export default App
