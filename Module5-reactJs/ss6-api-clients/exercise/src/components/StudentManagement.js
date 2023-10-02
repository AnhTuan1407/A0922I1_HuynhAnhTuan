import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { FallingLines } from 'react-loader-spinner'
import * as studentService from "../service/StudentService"
import { ToastContainer, toast } from "react-toastify"
import 'react-toastify/dist/ReactToastify.css'
import { Navigate, useNavigate } from "react-router-dom"
function StudentManagement() {

    const navigate = useNavigate();
    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    email: '',
                    phoneNumber: '',
                    address: ''
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required(),
                    email: Yup.string().required(),
                    phoneNumber: Yup.number().required(),
                    address: Yup.string().required()
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        await studentService.save(values)
                        toast(`Student ${values.name} created!`)
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
                        <div>
                            <Form>
                                <div id="wizard" style={{ backgroundColor: "wheate" }}>
                                    <h4>CREATE NEW STUDENT</h4>
                                    <div className="form-row">
                                        <Field type="text" className="form-control" placeholder="Name" name='name' />
                                        <ErrorMessage name="name" component="span" className="text-danger" />
                                    </div>
                                    <div className="form-row">
                                        <Field type="text" className="form-control" placeholder="Email" name='email' />
                                        <ErrorMessage name="email" component="span" className="text-danger" />
                                    </div>
                                    <div className="form-row">
                                        <Field type="text" className="form-control" placeholder="Phone number" name='phoneNumber' />
                                        <ErrorMessage name="phoneNumber" component="span" className="text-danger" />
                                    </div>
                                    <div className="form-row">
                                        <Field type="text" className="form-control" placeholder="Address" name='address' />
                                        <ErrorMessage name="address" component="span" className="text-danger" />
                                    </div>

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
                                </div>
                            </Form>
                        </div>
                    )
                }
            </Formik>
        </>
    )
}

export default StudentManagement;