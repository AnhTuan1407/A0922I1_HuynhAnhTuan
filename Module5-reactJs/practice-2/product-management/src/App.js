import logo from './logo.svg';
import './App.css';
import ProductCreate from './components/ProductCreate';
import { NavLink, Route, Routes } from 'react-router-dom';
import ProductList from './components/ProductList';
function App() {
  return (
    <>
      <NavLink to={'/'} role='button' className='btn btn-primary'>Danh sách sản phẩm</NavLink>
      <NavLink to={'/create'} role='button' className='btn btn-primary'>Thêm mới sản phẩm</NavLink>

      <Routes>
      <Route path='/' element={<ProductList />}></Route>
        <Route path='/create' element={<ProductCreate />}></Route>
      </Routes>
    </>
  );
}

export default App;
