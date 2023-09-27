import { Formik, Form, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
function FormContact() {
    return (
        <>
            <h1>Contact form</h1>

            <Formik
                initialValues={{
                    name: '',
                    email: '',
                    phone: '',
                    message: ''
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required('Required'),
                    email: Yup.string().required('Required').matches('/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/'),
                    phone: Yup.number().required('Required'),
                    message: Yup.string().required('Required'),
                })}

                onSubmit={() => {

                }}
            >
                <Form>
                    <div>
                        <div className="form-group">
                            <label htmlFor="exampleFormControlInput1"><h4>Name</h4></label>
                            <Field type="text" className="form-control" id="exampleFormControlInput1" name='name' />
                            <ErrorMessage name="name" className="text-danger" component="span"/>
                        </div>

                        <div className="form-group">
                            <label htmlFor="exampleFormControlInput3"><h4>Email</h4></label>
                            <Field type="text" className="form-control" id="exampleFormControlInput3" name='email' />
                            <ErrorMessage name="email" className="text-danger" component="span" />
                        </div>

                        <div className="form-group">
                            <label htmlFor="exampleFormControlInput2"><h4>Phone</h4></label>
                            <Field type="text" className="form-control" id="exampleFormControlInput2" name='phone' />
                            <ErrorMessage name="phone" className="text-danger" component="span"/>
                        </div>

                        <div className="input-group">
                            <div className="input-group-prepend">
                                <span className="input-group-text">Message</span>
                            </div>
                            <textarea className="form-control" aria-label="With textarea"></textarea>
                        </div>

                        <button type="submit">Submit</button>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

export default FormContact;