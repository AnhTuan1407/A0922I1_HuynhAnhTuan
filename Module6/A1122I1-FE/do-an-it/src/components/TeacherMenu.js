import { NavLink, Link } from 'react-router-dom';
function TeacherMenu() {
    return(
        <>
            <div>
                <Link to={`/approval-topic/${1}`}>Giáo viên 1</Link>
                <Link to={`/approval-topic/${3}`}>Giáo viên 2</Link>
            </div>
        </>
    )
}

export default TeacherMenu; 