interface Props {
    direction?: "right" | "left" | "double-right" | "double-left";
    onClick: () => void;
}

function Arrow ({direction = "right", onClick} : Props) {
    return(
        <>
            <button className={"bi bi-chevron-" + direction} onClick={onClick}></button>
        </>
    );
}

export default Arrow;