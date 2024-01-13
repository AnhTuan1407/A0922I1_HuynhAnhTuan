import './App.css';
import { NavLink, Route, Routes } from 'react-router-dom';
import ListTopicNotApproval from './components/ListTopicNotApproval';
import NotFound from './components/NotFound';
import TeacherMenu from './components/TeacherMenu';

function App() {
  return (
    <>
      <div>
        <Routes>
          <Route path='/approval-topic/:id' element={<ListTopicNotApproval />}></Route>
          <Route path='/*' element={<NotFound />}></Route>
          <Route path='/' element={<TeacherMenu />}></Route>
        </Routes>
      </div>
    </>
  );
}

export default App;
