import logo from './logo.svg';
import './App.css';
import {Route, Routes, NavLink} from "react-router-dom"
import {ShowList} from "./components/showList";
import {CreateProduct} from "./components/create";
import {Edit} from "./components/edit";
import {formbootstrap} from "./components/form-bootstrap";
import 'react-toastify/dist/ReactToastify.css'
import {ToastContainer} from "react-toastify";

function App() {
    return (
        <div>
            <NavLink to="/form">FORM</NavLink>
            <Routes>
                <Route path={'/'} element={<ShowList></ShowList>}></Route>
                <Route path={'/Create'} element={<CreateProduct></CreateProduct>}></Route>
                <Route path={'/edit/:id'} element={<Edit></Edit>}></Route>
                <Route path={'/form'} element={<formbootstrap></formbootstrap>}></Route>
            </Routes>
            <ToastContainer/>
        </div>
    );
}

export default App;
