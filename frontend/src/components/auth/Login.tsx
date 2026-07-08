import Navbar from "../ui/Navbar";
import LoginForm from "./LoginForm"

function Login() {
    return (
        <>
            <Navbar firstButtonLabel="S'inscrire" secondButtonLabel="Accueil" firstButtonLink="login" secondButtonLink="/"></Navbar>
            <LoginForm></LoginForm>
        </>
    );
}

export default Login;