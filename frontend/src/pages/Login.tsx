import Navbar from "../components/ui/Navbar";
import LoginForm from "../components/auth/LoginForm"

function Login() {
    return (
        <>
            <Navbar firstButtonLabel="S'inscrire" secondButtonLabel="Accueil" firstButtonLink="login" secondButtonLink="/"></Navbar>
            <LoginForm></LoginForm>
        </>
    );
}

export default Login;