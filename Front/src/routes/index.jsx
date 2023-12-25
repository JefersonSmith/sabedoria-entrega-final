import { Route, Routes } from "react-router-dom";
import { HomePage, RegisterPage, LoginPage} from "../pages";

export const RouterMain = () => {
    return(
        <Routes>
            <Route path="/" element={<HomePage/>}/>
            <Route path="/register" element={<RegisterPage/>}/>
            <Route path="/login" element={<LoginPage/>}/>
        </Routes>
    )
}