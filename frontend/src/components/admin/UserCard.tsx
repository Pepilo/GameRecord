interface Props {
    userId: string;
    userName: string;
    email: string;
    created: string;
}

function UserCard({userId, userName, email, created} : Props) {

    async function handleOnClick(userId: string) {
        try {
            await fetch("http://localhost:8080/api/v1/users/" + userId, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                },
            });

            console.log("User deleted");

        } catch (error) {
            console.log("Something went wrong");
        }
    };

    return(
        <>
            <h1>{userName}</h1>
            <div>{email}</div>
            <div>{created}</div>
            <button onClick={() => handleOnClick(userId)}>Delete</button>
        </>
    );
}

export default UserCard;