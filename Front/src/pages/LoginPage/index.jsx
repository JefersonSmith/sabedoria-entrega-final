import { zodResolver } from "@hookform/resolvers/zod"
import { Input } from "../../components"
import { loginFormSchema } from "./loginFormSchema"
import { useForm } from "react-hook-form"
import { Link } from "react-router-dom";
import "./loginPage.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from "../../assets/logo.png"

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
    <div className="login-container">
      <img src={logo} alt="logo" className="logo"/>
      <form onSubmit={handleSubmit(submit)} className="login-form">
        <h3 className="login-title">Login</h3>

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

        <button type="submit" className="btn btn-primary mt-3">
          Acessar
        </button>

        <Link to="/register" className="register-link">
          Cadastre-se
        </Link>
      </form>
    </div>
  )
}