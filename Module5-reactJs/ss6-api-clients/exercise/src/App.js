import { NavLink, Route, Routes } from 'react-router-dom';
import './App.css';
import StudentManagement from './components/StudentManagement';
import StudentList from './components/StudentList';
import NotFound from './components/NotFound';
import TodoList from './components/TodoList';

function App() {
  return (
    <>
      {/* <NavLink to='/' className="btn btn-primary">LIST</NavLink>
      <NavLink to='/create' className="btn btn-primary ms-2">CREATE</NavLink> */}
      <NavLink to='/todo' className="btn btn-primary ms-2">TODO</NavLink>
      <Routes>
        {/* <Route path='/' element={<StudentList />}></Route>
        <Route path='/create' element={<StudentManagement />}></Route> */}
        <Route path='/todo' element={<TodoList />}></Route>
        <Route path='/*' element={<NotFound />}></Route>
      </Routes>
    </>
  );
}

export default App;
