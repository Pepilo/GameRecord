import { useEffect, useState } from "react";
import { getRawgGames } from "../../services/rawgService";

interface RawgGame {
    id: number;
    slug: string;
    name: string;
    background_image: string;
    description: string | null;
    released: string;
    tba: boolean;
}

function RawgGameMainList() {

    const [games, setGames] = useState<RawgGame[]>([]);

    useEffect(() => {
        getRawgGames().then(setGames);
    }, []);

    return(
        <>
            {games.map(game => (
                <div key={game.id}>
                    <h2>{game.name}</h2>
                    <img 
                        src={game.background_image}
                        alt={game.name}
                    />
                    <p>{game.released}</p>
                </div>
            ))}
        </>
    );
}

export default RawgGameMainList;