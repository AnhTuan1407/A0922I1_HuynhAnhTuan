import { Formik, Form, Field, ErrorMessage } from 'formik'
import { useEffect, useState } from 'react';
import { useParams } from 'react-router'
import * as libraryService from '../../service/LibraryService';
import * as userService from '../../service/UserService';
import * as Yup from 'yup'
import { useNavigate } from 'react-router-dom';
function UserCreate() {
    const navigate = useNavigate()

    const [book, setBook] = useState({
        id: '',
        name: '',
        author: '',
        description: '',
        quantity: ''
    })
    const { id } = useParams()

    useEffect(() => {
        const findBook = async () => {
            let result = await libraryService.findById(id)
            result.quantity -= 1
            setBook(result)
        }

        findBook()
    }, [])

    const today = new Date();
    const date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();

    return book.name != "" ? (
        <>
            <Formik
                initialValues={{
                    idCard: '',
                    name: '',
                    dateOfBorrow: date,
                    bookName: book.name,
                    status: 1
                }}

                validationSchema={Yup.object({

                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        await userService.save(values)
                        await libraryService.update(id, book)
                        navigate('/')
                    }

                    create()
                }}
            >
                <Form>
                    <div>
                        <label>ID Card</label>
                        <Field type='text' name='idCard' />
                    </div>

                    <div>
                        <label>Student name</label>
                        <Field type='text' name='name' />
                    </div>

                    <div>
                        <label>Date of borrow</label>
                        <Field type='text' name='dateOfBorrow' />
                    </div>

                    <div>
                        <label>Book name</label>
                        <Field type='text' name='bookName' />
                    </div>

                    <button type='submit'>Add</button>
                </Form>
            </Formik>
        </>
    ) : ""
}

export default UserCreate;