import Navbar from "../ui/Navbar";
import RegisterForm from "./RegisterForm";

function Register() {
    return (
        <>
            <Navbar firstButtonLabel="Se Connecter" secondButtonLabel="Accueil" firstButtonLink="login" secondButtonLink="/"></Navbar>
            <RegisterForm></RegisterForm>
        </>
    );
}

export default Register;