import { zodResolver } from "@hookform/resolvers/zod"
import { Input } from "../../components"
import { loginFormSchema } from "./loginFormSchema"
import { useForm } from "react-hook-form"
import { Link } from "react-router-dom";

export const LoginPage = () => {
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginFormSchema),
    })

    const submit = (payload) => {
        console.log(payload)
    }

    return (
        <div>
            <form onSubmit={handleSubmit(submit)}>
                <h3>Login</h3>
                <Input
                    label="Email"
                    type="email"
                    placeholder="Digite seu email..."
                    {...register("email")}
                    errors={errors.email}
                />

                <Input
                    label="Senha"
                    type="text"
                    placeholder="Digite sua senha..."
                    {...register("password")}
                    errors={errors.password}
                />

                <button type="submit">Acessar</button>
                <Link to="/register">Cadastre-se</Link>
            </form>
        </div>
    )
}