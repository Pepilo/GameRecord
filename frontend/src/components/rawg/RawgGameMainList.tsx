import { useEffect, useState } from "react";
import { getRawgGames } from "../../services/rawgService";
import Arrow from "./../ui/Arrow"
import "./RawgGameMainList.css";

interface RawgGame {
    id: number;
    slug: string;
    name: string;
    background_image: string;
    description: string | null;
    released: string;
    tba: boolean;
}

interface RawgGamesResponse {
    count: number;
    next: string | null;
    previous: string | null;
    results: RawgGame[];
}

function RawgGameMainList() {

    const [rawgResponse, setRawgResponse] = useState<RawgGamesResponse | null>(null);
    const [page, setPage] = useState(1);

    useEffect(() => {
        getRawgGames(page).then(data => {
            setRawgResponse(data);
        });
    }, [page]);

    const changePage = (newPage: number) => {
        console.log("Nouvelle page :", newPage);

        if (newPage < 1) return;
        setPage(newPage);
    };

    return(
        <>
            {rawgResponse?.results.map(game => (
                <div key={game.id}>
                    <h2>{game.name}</h2>
                    <img 
                        src={game.background_image}
                        alt={game.name}
                        className="game-image"
                    />
                    <p>{game.released}</p>
                </div>
            ))}
            <Arrow direction="double-left" onClick={() => changePage(page - 10)}></Arrow>
            <Arrow direction="left" onClick={() => changePage(page - 1)}></Arrow>
            <Arrow direction="right" onClick={() => changePage(page + 1)}></Arrow>
            <Arrow direction ="double-right" onClick={() => changePage(page + 10)}></Arrow>
        </>
    );
}

export default RawgGameMainList;