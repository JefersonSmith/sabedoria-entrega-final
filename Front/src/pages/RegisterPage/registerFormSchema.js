import { z } from "zod"

const registerFormSchema = z
    .object({
        name: z.string().min(1, "Campo obrigatório"),
        email: z.string().email("E-mail inválido.").min(1, "Campo obrigatório."),
        password: z
            .string()
            .min(8, "São necessários pelo menos 8 caracteres.")
            .regex(/[a-z]+/, "É necessário conter pelo menos uma letra minúscula.")
            .regex(/[A-Z]+/, "É necessário conter pelo menos uma letra maiúscula.")
            .regex(/[0-9]+/, "É necessário conter pelo menos um número.")
            .regex(
                /[!@#$%^&*()_+{}\[\]:;<>,.?~\\-]+/,
                "É necessário conter pelo menos um caracter especial."
            ),
        passwordConfirm: z.string().min(1, "Campo obrigatório."),
    })
    .refine(({ password, passwordConfirm }) => password === passwordConfirm, {
        message: "As senhas precisam ser iguais.",
        path: ["passwordConfirm"],
    })

export { registerFormSchema }