import { useEffect, useState } from "react";
import * as libraryService from '../service/LibraryService'
import { NavLink, Link } from 'react-router-dom';
function LibraryList() {
    const [list, setList] = useState([])

    useEffect(() => {
        const callApi = async () => {
            const result = await libraryService.findAll()
            setList(result)
        }
        callApi()
    }, [])

    return (
        <>
            <div>
                <h1>Library</h1>
            </div>

            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Title</td>
                            <td>Quantity</td>
                            <td>Action</td>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            list.map((item) => (
                                <tr key={item.id}>
                                    <td>{item.title}</td>
                                    <td>{item.quantity}</td>

                                    <tr>
                                        <Link to={`/update/${item.id}`} className="btn btn-primary">Update</Link>
                                        <button onClick={e => handleDelete(item.id)} className="btn btn-danger">Delete</button>
                                    </tr>
                                </tr>
                            ))
                        }   
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default LibraryList;