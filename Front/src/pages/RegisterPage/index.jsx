import { Input } from "../../components"
import { useForm } from "react-hook-form"
import { zodResolver } from "@hookform/resolvers/zod"
import { registerFormSchema } from "./registerFormSchema";
import { Link } from "react-router-dom";


export const RegisterPage = () => {
    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: zodResolver(registerFormSchema),
    });

    const submit = (payload) => {
        console.log(payload);
        
    }

    return (
        <div>
            <form onSubmit={handleSubmit(submit)}>
                <h3>Cadastro de Usuário</h3>

                <Input
                    label="Nome"
                    type="text"
                    placeholder="Digite seu nome..."
                    {...register("name")}
                    errors={errors.name}
                />

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


                <Input
                    label="Confirma sua senha"
                    type="text"
                    placeholder="Digite sua confirmação senha..."
                    {...register("passwordConfirm")}
                    errors={errors.passwordConfirm}
                />

                <button type="submit">Cadastrar</button>
                <Link to="/login">Já tenho uma conta</Link>
            </form>
        </div>
    )
}