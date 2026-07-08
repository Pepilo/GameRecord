import { useForm, type SubmitHandler } from "react-hook-form";
import { useAuth } from "./../../auth/AuthContext";

type FormFields = {
    email: string;
    password: string;
}

function LoginForm() {

    const { login } = useAuth();

    const { register, handleSubmit, setError, formState: { errors, isSubmitting} } = useForm<FormFields>();

    const onSubmit: SubmitHandler<FormFields> = async (data) => {
        try {

            await login(data.email, data.password);

            console.log("Connection established.");

        } catch (error) {
            setError("root", {message : "Something went wrong"});
        }
    }

    return(
        <>
        <form onSubmit={handleSubmit(onSubmit)}>
            <input {...register("email", {required: "Email is required", pattern: {value: /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/i, message: "Email must be valid"}})} type="text" placeholder="Email"/>
            {errors.email && <div>{errors.email.message}</div>}
            <input {...register("password", {required: "Password is required", minLength: {value: 8, message: "Password must have at least 8 characters"}})} type="text" placeholder="Password"/>
            {errors.password && <div>{errors.password.message}</div>}
            <button type="submit" disabled={isSubmitting}>{isSubmitting ? "Loading..." : "Submit"}</button>
            {errors.root && (<div>{errors.root.message}</div>)}
        </form>
        </>
    );
}

export default LoginForm;