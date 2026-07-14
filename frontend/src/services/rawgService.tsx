export async function getRawgGames() {
    
    const response = await fetch("http://localhost:8080/api/v1/rawgGames");

    if (!response.ok) {
        throw new Error("Unable to fetch games");
    }

    return response.json();
}