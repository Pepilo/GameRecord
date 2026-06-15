import UserCard from "./UserCard";

interface Props {
    users: Object[];
}

function UsersPanel({users}: Props) {
    return (
        <>
            <UserCard userName={users[userName]}, email={users[password]}, created={users[created]}/>
        </>
    );
}

export default UsersPanel;