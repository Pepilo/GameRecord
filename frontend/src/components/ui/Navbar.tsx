import LinkButton from './LinkButton'

interface Props {
    firstButtonLabel: string;
    secondButtonLabel: string;
    firstButtonLink?: string;
    secondButtonLink?: string;
}

function Navbar({firstButtonLabel, secondButtonLabel, firstButtonLink = "*", secondButtonLink = "*"} : Props) {

    return (
        <>
        <nav className="navbar sticky-top bg-dark border-bottom border-body" data-bs-theme="dark">
            <div className="container-fluid">
                <span className="navbar-brand mb-0 h1">GameRecord</span>
                <LinkButton color="dark" link={firstButtonLink} onClick={() => console.log("Navigate to login")}>{firstButtonLabel}</LinkButton>
                <LinkButton color="dark" link={secondButtonLink} onClick={() => console.log("Navigate to register")}>{secondButtonLabel}</LinkButton>
            </div>
        </nav>
        </>
    );
}

export default Navbar;