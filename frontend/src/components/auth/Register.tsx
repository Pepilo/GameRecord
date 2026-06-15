import Navbar from "../ui/Navbar";
import RegisteForm from "./RegisterForm";

function Register() {
    return (
        <>
            <Navbar firstButtonLabel="Se Connecter" secondButtonLabel="Accueil" firstButtonLink="login" secondButtonLink="/"></Navbar>
            <RegisteForm></RegisteForm>
        </>
    );
}

export default Register;