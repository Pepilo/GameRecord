import { useForm, type SubmitHandler } from "react-hook-form";

type FormFields = {
    email: string;
    password: string;
    userName: string;
}

function RegisteForm() {

    const { register, handleSubmit, setError, formState: { errors, isSubmitting} } = useForm<FormFields>();

    const onSubmit: SubmitHandler<FormFields> = async (data) => {
        try {
            const response = await fetch("http://localhost:8080/api/v1/users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            });

            const createdUser = await response.json();
            console.log(createdUser);

        } catch (error) {
            setError("root", {message : "Something went wrong"});
        }
    }

    return(
        <>
        <form onSubmit={handleSubmit(onSubmit)}>
            <input {...register("email", {required: "Email is required", pattern: {value: /^[a-z0-9._%+-]+@[a-z0-9._%+-]+\.[a-z]{2,4}$/i, message: "Email must be valid"}})} type="text" placeholder="Email"/>
            {errors.email && <div>{errors.email.message}</div>}
            <input {...register("password", {required: "Password is required", minLength: {value: 8, message: "Password must have at least 8 characters"}})} type="text" placeholder="Password"/>
            {errors.password && <div>{errors.password.message}</div>}
            <input {...register("userName", {required: "Username is required", minLength: {value: 2, message: "Username must have at least 2 characters"}, maxLength: {value: 42, message: "Username must have less than 43 characters"}})} type="text" placeholder="Username"/>
            {errors.userName && <div>{errors.userName.message}</div>}
            <button type="submit" disabled={isSubmitting}>{isSubmitting ? "Loading..." : "Submit"}</button>
            {errors.root && (<div>{errors.root.message}</div>)}
        </form>
        </>
    );
}

export default RegisteForm;