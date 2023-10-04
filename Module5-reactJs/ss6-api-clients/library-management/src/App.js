import logo from './logo.svg';
import './App.css';
import { NavLink, Route, Routes } from 'react-router-dom';
import Create from './components/Create';
import LibraryList from './components/LibraryList';
import NotFound from './components/NotFound';
import Update from './components/Update';
function App() {
  return (
    <>
      <NavLink to='/' className="btn btn-primary">LIST</NavLink>
      <NavLink to='/create' className="btn btn-primary ms-2">CREATE</NavLink>
      <Routes>
        <Route path='/' element={<LibraryList />}></Route>
        <Route path='/create' element={<Create />}></Route>
        <Route path='/update/:id' element={<Update />}></Route>
        <Route path='/*' element={<NotFound />}></Route>
      </Routes>
    </>
  );
}

export default App;
