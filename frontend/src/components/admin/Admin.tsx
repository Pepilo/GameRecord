import Navbar from "../ui/Navbar";
import UsersPanel from "./UsersPanel";

function Admin() {
    return (
        <>
            <Navbar firstButtonLabel="Se déconnecter" secondButtonLabel="Accueil" firstButtonLink="/logout" secondButtonLink="/"/>
            <UsersPanel/>
        </>
    );
}

export default Admin;