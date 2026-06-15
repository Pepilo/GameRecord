interface Props {
    userName: string;
    email: string;
    created: string;
}

function UserCard({userName, email, created} : Props) {

    function handleOnClick() {
        console.log("Do you really want to make me cry?")
    };

    return(
        <>
            <h1>{userName}</h1>
            <div>{email}</div>
            <div>{created}</div>
            <button onClick={() => handleOnClick()}>Delete</button>
        </>
    );
}

export default UserCard;