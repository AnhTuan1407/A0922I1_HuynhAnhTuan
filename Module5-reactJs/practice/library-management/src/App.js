
import { NavLink, Routes, Route } from 'react-router-dom';
import LibraryList from './components/library/LibraryList';
import LibraryCreate from './components/library/LibraryCreate';
import LibraryUpdate from './components/library/LibraryUpdate';
import UserCreate from './components/user/UserCreate';
import UserList from './components/user/UserList';

function App() {
  return (
    <>
      <NavLink to='/' className='btn btn-primary'>LIST BOOKS</NavLink>
      <NavLink to='/create' className='btn btn-primary'>ADD NEW BOOK</NavLink>

      <NavLink to='/users' className='btn btn-primary'>LIST USERS</NavLink>
      <Routes>
          <Route path='/borrow/:id' element={<UserCreate/>}></Route>
          <Route path='/users' element={<UserList />}></Route>
          <Route path='/' element={<LibraryList />}></Route>
          <Route path='/create' element={<LibraryCreate />}></Route>
          <Route path='/update/:id' element={<LibraryUpdate />}></Route>
      </Routes>
    </>
  );
}

export default App;
