import Navbar from "../ui/Navbar";
import UsersPanel from "./UsersPanel";
import { useEffect, useState } from "react";

interface User {
    userId: string;
    userName: string;
    email: string;
    created: string;
}

function Admin() {

    const [users, setUsers] = useState<User[]>([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/users")
            .then((response) => response.json())
            .then((data) => setUsers(data));
    }, []);

    return (
        <>
            <Navbar firstButtonLabel="Se déconnecter" secondButtonLabel="Accueil" firstButtonLink="/logout" secondButtonLink="/"/>
            <UsersPanel users={users}/>
        </>
    );
}

export default Admin;