import { forwardRef } from "react"

 export const Input = forwardRef(({label, errors, ...rest}, ref) => {
    return (
        <div>
            <label>{label}</label>
            <input ref={ref} {...rest} />
            <span>{errors && errors.message}</span>
        </div>
    )
})
