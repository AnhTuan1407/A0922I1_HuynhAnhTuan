import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'
import * as libraryService from '../../service/LibraryService'
import { useNavigate } from 'react-router-dom'
function LibraryCreate() {
    const navigate = useNavigate()
    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    author: '',
                    description: '',
                    quantity: ''
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required('Name is not empty!'),
                    author: Yup.string().required('Author is not empty!'),
                    description: Yup.string(),
                    quantity: Yup.number().min(0, 'Must be bigger than 0!')
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        setSubmitting(false)
                        await libraryService.save(values)
                        navigate('/')
                    }

                    create()
                }}
            >
                <Form>
                    <div>
                        <h1>ADD NEW BOOK</h1>
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

                        <button type='submit'>ADD</button>
                    </div>
                </Form>
            </Formik>
        </>
    )
}
export default LibraryCreate;