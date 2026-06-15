import UserCard from "./UserCard";

interface User {
    userId: string;
    userName: string;
    email: string;
    created: string;
}
interface Props {
    users: User[];
}

function UsersPanel({users}: Props) {
    return (
        <>
            {users.map((user) => (<UserCard key= {user.userId} userName={user.userName} email={user.email} created={user.created}/>))}
        </>
    );
}

export default UsersPanel;