interface Props {
    direction?: "rigth" | "left" | "double-rigth" | "double-left";
}

function Arrow ({direction = "rigth"} : Props) {
    return(
        <>
            <button className={"chevron-" + direction}></button>
        </>
    );
}

export default Arrow;