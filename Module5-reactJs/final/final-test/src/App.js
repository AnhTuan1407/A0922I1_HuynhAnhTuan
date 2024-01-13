import logo from './logo.svg';
import './App.css';
import { Route, Routes, NavLink, Link } from "react-router-dom"
import Create from "./components/Create";
import List from "./components/List";
import 'react-toastify/dist/ReactToastify.css'
import { ToastContainer } from "react-toastify";

function App() {
  return (
    <>
      <NavLink to="/" className='btn btn-primary'>DANH SÁCH SẢN PHẨM</NavLink>
      <Routes>
        <Route path={'/create'} element={<Create/>}></Route>
        <Route path={'/'} element={<List/>}></Route>
      </Routes>
      <ToastContainer />

    </>
  );
}

export default App;
