import { Input } from "../../components"
import { useForm } from "react-hook-form"
import { zodResolver } from "@hookform/resolvers/zod"
import { registerFormSchema } from "./registerFormSchema";
import { Link } from "react-router-dom";
import "./registerPage.css";
import 'bootstrap/dist/css/bootstrap.min.css';



export const RegisterPage = () => {
    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: zodResolver(registerFormSchema),
    });

    const submit = (payload) => {
        console.log(payload);
        
    }

    return (
        <div className="register-container">
      <form onSubmit={handleSubmit(submit)} className="register-form">
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
          type="password"
          placeholder="Digite sua senha..."
          {...register("password")}
          errors={errors.password}
        />

        <Input
          label="Confirme sua senha"
          type="password"
          placeholder="Digite sua confirmação de senha..."
          {...register("passwordConfirm")}
          errors={errors.passwordConfirm}
        />

        <button type="submit" className="btn btn-primary">Cadastrar</button>
        <Link to="/login" className="d-block mt-2">Já tenho uma conta</Link>
      </form>
    </div>
    )
}