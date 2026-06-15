import { Link } from "react-router-dom";

interface Props {
    children: string;
    color?: "primary" | "secondary" | "danger" | "dark";
    link?: string;
    onClick: () => void;
}
    
function LinkButton ({children, color = "primary", link = "*", onClick} : Props) {

    return (
        <>
            <Link to={`/${link}`} className={"btn btn-" + color} onClick={onClick}>{children}</Link>
        </>
    );
}

export default LinkButton;