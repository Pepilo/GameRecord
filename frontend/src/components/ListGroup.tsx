function ListGroup() {

    const games = [
        "Red dead redemption 2",
        "The witcher 3",
        "Clair obscur Expidition 33",
        "Bloodborne",
        "Monster hunter world"
    ]

    if (games.length === 0)
        return (
            <>
                <h1>Game list</h1>
                <p>No game found.</p>
            </>
        );

    return ( 
        <>
            <h1>Game list</h1>
            <ul className="list-group">
                {games.map((game) =>(<li key = {game}>{game}</li>))}
            </ul>;
        </>
    );
}

export default ListGroup;