import Navbar from "../components/ui/Navbar";
import RegisterForm from "../components/auth/RegisterForm";

function Register() {
    return (
        <>
            <Navbar firstButtonLabel="Se Connecter" secondButtonLabel="Accueil" firstButtonLink="login" secondButtonLink="/"></Navbar>
            <RegisterForm></RegisterForm>
        </>
    );
}

export default Register;