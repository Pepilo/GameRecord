import LinkButton from "../components/ui/LinkButton";

function NotFound() {
    return (
        <>
        <h1>Nothing to play around here :/...</h1>
        <LinkButton link ="/" onClick={() => console.log("User left error page")}>Return to your playground</LinkButton>
        </>
    );
}

export default NotFound;