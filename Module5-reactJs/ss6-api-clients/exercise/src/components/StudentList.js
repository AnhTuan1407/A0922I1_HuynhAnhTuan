import { useEffect, useState } from "react";
import * as studentService from '../service/StudentService'

function StudentList() {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        const callAPI = async () => {
            const result = await studentService.findAll();
            setStudents(result)
        }

        callAPI();
    }, []);
    return (
        <>
            <h1>STUDENT LIST</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>PhoneNumber</th>
                        <th>Address</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        students.map((student) => (
                            <tr key={student.id}>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.email}</td>
                                <td>{student.phoneNumber}</td>
                                <td>{student.address}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </>
    )
}

export default StudentList;