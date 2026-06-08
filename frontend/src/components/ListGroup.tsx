import { useState, type MouseEvent} from "react";

interface Props {
    games: string[];
    heading: string;
    onSelectGame: (game: string) => void;
}

function ListGroup({games, heading, onSelectGame}: Props) {

    const handleClick = (event: MouseEvent) => console.log(event);

    const [selectedIndex, setSelectedIndex] = useState(-1);

    return ( 
        <>
            <h1>{heading}</h1>
            {games.length === 0 && <p>No game found.</p>}
            <ul className="list-group">
                {games.map((game, index) => (<li className= {selectedIndex === index ? "list-group-item active" : "list-group-item"} key = {game} onClick={() => {setSelectedIndex(index); onSelectGame(game)} }>{game}</li>))}
            </ul>
        </>
    );
}

export default ListGroup;