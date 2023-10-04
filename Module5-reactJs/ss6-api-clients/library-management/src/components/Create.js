import { Formik, Form, Field, ErrorMessage } from "formik"
import * as Yup from "yup"
import * as libraryService from '../service/LibraryService'
import { ToastContainer, toast } from "react-toastify"
import { useNavigate } from "react-router-dom"
import { FallingLines } from 'react-loader-spinner'
import 'react-toastify/dist/ReactToastify.css'
function Create() {
    const navigate = useNavigate()

    return (
        <>
            <Formik
                initialValues={{
                    title: '',
                    quantity: 0
                }}

                validationSchema={Yup.object({
                    title: Yup.string().required(),
                    quantity: Yup.number().required()
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        await libraryService.save(values)
                        toast(`Book ${values.title} created!`)
                        navigate('/')
                    }

                    setTimeout(() => {
                        setSubmitting(false)
                        create()
                    }, 3000)
                }}
            >
                {
                    ({ isSubmitting }) => (
                        <Form>
                            <h1>CREATE</h1>
                            <table className="table">
                                <tbody>
                                    <tr>
                                        <td>Title</td>
                                        <td><Field type='text' name='title' /></td>
                                    </tr>
                                    <tr>
                                        <td>Quantity</td>
                                        <td><Field type='number' name='quantity' /></td>
                                    </tr>
                                </tbody>
                            </table>

                            {
                                isSubmitting ?
                                    <FallingLines
                                        color="#4fa94d"
                                        width="100"
                                        visible={true}
                                        ariaLabel='falling-lines-loading'
                                    />
                                    :
                                    <button type="submit" className="btn btn-primary">Submit</button>
                            }
                        </Form>
                    )
                }

            </Formik>
        </>
    )
}

export default Create;