export async function getRawgGames(page : number = 1) {
    
    const response = await fetch(`http://localhost:8080/api/v1/rawgGames?page=${page}`);

    if (!response.ok) {
        throw new Error("Unable to fetch games");
    }

    return response.json();
}