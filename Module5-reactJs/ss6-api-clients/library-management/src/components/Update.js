import { useEffect, useState } from "react";
import { useParams } from "react-router";
import * as libraryService from '../service/LibraryService'
import { Formik, Form, Field, ErrorMessage } from "formik"
import * as Yup from "yup"
import { ToastContainer, toast } from "react-toastify"
import { useNavigate } from "react-router-dom"
import { FallingLines } from 'react-loader-spinner'
import 'react-toastify/dist/ReactToastify.css'
function Update() {
    const navigate = useNavigate()

    const [item, setItem] = useState(
        {
            id: '',
            title: '',
            quantity: ''
        }
    )

    const { id } = useParams()

    useEffect(() => {
        const findBook = async () => {
            const result = await libraryService.findById(id);
            console.log(result)
            setItem(result)
        }
        console.log(id);
        findBook()
    }, [])

    return item.title !== "" ? (
        <>
            <Formik
                initialValues={{
                    title: item.title,
                    quantity: item.quantity
                }}

                validationSchema={Yup.object({
                    title: Yup.string().required(),
                    quantity: Yup.number().required()
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        await libraryService.update(id, values)
                        toast(`Book ${values.title} updated!`)
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
    ) : ""
}
export default Update;