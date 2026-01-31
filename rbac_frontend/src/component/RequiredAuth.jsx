import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";


export default function RequiredAuth({ permission, children }) {
  const { user } = useAuth();

  if (!user) return <Navigate to="/login" />;

  if (permission && !user.authorities?.includes(permission)) {
    return <Navigate to="/unauthorized" />;
  }

  return children;
}
