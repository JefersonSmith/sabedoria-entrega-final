import { z } from "zod"

const loginFormSchema = z.object({
    email: z.string().min(1, "Campo obrigatório"),
    password: z.string().min(1, "Campo obrigatório"),
})

export { loginFormSchema }