import { createContext, useContext } from "react";

type AuthContextType = {
    token: string | null;
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
};


export const AuthContext = createContext<AuthContextType | null>(null);


export function useAuth() {
    const context = useContext(AuthContext);

    if (!context) {
        throw new Error("useAuth doit être utilisé dans un AuthProvider");
    }

    return context;
}