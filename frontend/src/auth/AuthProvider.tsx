import { useState } from "react";
import { AuthContext } from "./AuthContext";
import { login as loginRequest } from "../services/authService";


type Props = {
    children: React.ReactNode;
};


export default function AuthProvider({ children }: Props) {

    const [token, setToken] = useState<string | null>(null);


    async function login(email: string, password: string) {

        const response = await loginRequest(email, password);

        setToken(response.token);
    }


    function logout() {
        setToken(null);
    }


    return (
        <AuthContext.Provider
            value={{
                token,
                login,
                logout
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}