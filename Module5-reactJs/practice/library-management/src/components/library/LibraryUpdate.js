import { useEffect, useState } from 'react';
import { useParams } from 'react-router'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'
import * as libraryService from '../../service/LibraryService'
import { useNavigate } from 'react-router-dom'
function LibraryUpdate() {
    const navigate = useNavigate()
    const {id} = useParams()
    const [book, setBook] = useState({
        id: '',
        name: '',
        author: '',
        description: '',
        quantity: ''
    })

    useEffect(() => {
        const findBook = async () => {
            const result = await libraryService.findById(id)
            setBook(result)
        }

        findBook()
    }, [])

    return book.name != "" ? (
        <>
            <Formik
                initialValues={{
                    id: book.id,
                    name: book.name,
                    author: book.author,
                    description: book.description,
                    quantity: book.quantity
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required('Name is not empty!'),
                    author: Yup.string().required('Author is not empty!'),
                    description: Yup.string(),
                    quantity: Yup.number().min(0, 'Must be bigger than 0!')
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const update = async () => {
                        setSubmitting(false)
                        await libraryService.update(id, values)
                        navigate('/')
                    }

                    update()
                }}
            >
                <Form>
                    <div>
                        <h1>UPDATE BOOK</h1>
                    </div>

                    <div>
                        <div>
                            <label>Name</label>
                            <Field name='name' />
                            <ErrorMessage name='name' component='span' className='text-danger' />
                        </div>

                        <div>
                            <label>Author</label>
                            <Field name='author' />
                            <ErrorMessage name='author' component='span' className='text-danger' />
                        </div>

                        <div>
                            <label>Description</label>
                            <Field name='description' />
                            <ErrorMessage name='description' component='span' className='text-danger' />
                        </div>

                        <div>
                            <label>Quantity</label>
                            <Field name='quantity' />
                            <ErrorMessage name='quantity' component='span' className='text-danger' />
                        </div>

                        <button type='submit'>SAVE</button>
                    </div>
                </Form>
            </Formik>
        </>
    ) : ""
}

export default LibraryUpdate;