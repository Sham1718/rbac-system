import { createContext,useContext,useEffect,useState } from "react";
import { decodeToken } from "../utils/jwtToken";
import { useNavigate } from "react-router-dom";


const AuthContext=createContext();

export function AuthProvider({children}){
    const[token,setToken]=useState(null);
    const [user, setUser] = useState(
    token ? decodeToken(token) : null
    );

    useEffect(()=>{
        const storeToken=localStorage.getItem("token");
        setToken(token)
    },[])

    const login=(jwtToken)=>{
        localStorage.setItem("token",jwtToken);
        setToken(token);
        setUser(decodeToken(jwtToken));
    }

    const logout=()=>{
        localStorage.removeItem("token");
        setToken(null);
    }

    const value={
        token,
        user,
        login,
        logout
    }

    return(
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}

export const useAuth=()=>useContext(AuthContext);