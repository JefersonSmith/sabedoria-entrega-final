import { forwardRef } from "react"
import 'bootstrap/dist/css/bootstrap.min.css';


 export const Input = forwardRef(({label, errors, ...rest}, ref) => {
    return (
        <div className="form-group">
            <label>{label}</label>
            <input ref={ref} 
                   {...rest}
           className={`form-control ${errors ? 'is-invalid' : ''}`}
      />
      {errors && <div className="invalid-feedback">{errors.message}</div>}
    </div>
    )
})
