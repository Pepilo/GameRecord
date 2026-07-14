type AuthResponse = {
    token: string;
    expiresIn: number;
};

export async function login(email : string, password : string): Promise<AuthResponse> {

    const response = await fetch(`${import.meta.env.VITE_API_URL}/api/v1/auth`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email,
            password
        })
    });


    if (!response.ok) {
        throw new Error("Authentification error");
    }


    const data = await response.json();

    return data;
}