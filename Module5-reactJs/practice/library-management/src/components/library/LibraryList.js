import { useEffect, useState } from "react";
import * as libraryService from '../../service/LibraryService';
import { Link } from "react-router-dom";
import axios from "axios";
import Form from 'react-bootstrap/Form'
import InputGroup from 'react-bootstrap/InputGroup'

function LibraryList() {
    const [books, setBooks] = useState([]);
    const [searchResults, setSearchResults] = useState([]);
    const [search, setSearch] = useState('')

    useEffect(() => {
        const callAPI = async () => {
            const result = await libraryService.findAll()
            setBooks(result)
        }

        callAPI()
    }, [])

    const handleDelete = (id) => {
        try {
            axios.delete(libraryService.API_URL + '/' + id)
            setBooks(prev => prev.filter((book) => book.id !== id));
        }
        catch (e) {
            console.log(e);
        }
    }

    useEffect(() => {
        const Search = () => {
            const results = books.filter((book) =>
                book.title == (search) || book.quantity == (search)
            );
            setSearchResults(results);
        };

        Search();
    }, [search, books]);

    return (
        <>
            <div>
                <h1>LIST BOOKS</h1>
            </div>

            <Form>
                <InputGroup>
                    <Form.Control onChange={(e) => setSearch(e.target.value)} placeholder="Search book name" />
                </InputGroup>
            </Form>

            <table className="table">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        books.filter((book) => {
                            return search.toLowerCase() === '' ? book : book.name.toLowerCase().includes(search)
                        }).map((book) => (
                            <tr key={book.id}>
                                <td>{book.id}</td>
                                <td>{book.name}</td>
                                <td>{book.author}</td>
                                <td>{book.description}</td>
                                <td>{book.quantity}</td>

                                <td>
                                    <Link to={`/update/${book.id}`} role="button" className="btn btn-primary">Update</Link>
                                    <button className="btn btn-danger" onClick={e => handleDelete(book.id)}>Delete</button>
                                    <Link to={`/borrow/${book.id}`} className="btn btn-primary">Borrow</Link>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </>
    );
}

export default LibraryList;