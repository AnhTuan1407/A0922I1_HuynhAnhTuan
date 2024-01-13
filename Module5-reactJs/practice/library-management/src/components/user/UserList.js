import { Link } from 'react-router-dom';
import * as userService from '../../service/UserService'
import * as libraryService from '../../service/LibraryService'
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
function UserList() {
    const [book, setBook] = useState({
        id: 0,
        name: '',
        author: '',
        description: '',
        quantity: 0
    })

    const navigate = useNavigate()
    const [users, setUsers] = useState([])
    const [user, setUser] = useState({})

    useEffect(() => {
        const callAPI = async () => {
            const result = await userService.findAll()
            setUsers(result)
        }
        callAPI()
    }, [])

    const handlePay = async (id, bookName) => {

        const findBook = async () => {
            let result = await libraryService.findByName(bookName)
            result.quantity += 1
            libraryService.update(result.id, result)
        }

        await findBook()
        navigate('/')
    }
    return (
        <>
            <div>
                <Link to={'/'} role="button" className="btn btn-primary">Back</Link>
            </div>

            <div>
                <table>
                    <thead>
                        <tr>
                            <th>ID card</th>
                            <th>Student name</th>
                            <th>Book name</th>
                            <th>Date of borrow</th>
                            <th>Status</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            users.map((user) => (
                                <tr key={user.id}>
                                    <td>{user.idCard}</td>
                                    <td>{user.name}</td>
                                    <td>{user.bookName}</td>
                                    <td>{user.dateOfBorrow}</td>
                                    <td>{user.status === 1 ? 'Đang mượn' : 'Đã trả'}</td>
                                    {user.status === 0 ? '' : <button onClick={e => handlePay(user.id, user.bookName)} className='btn btn-primary'>Pay</button>}
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default UserList;