import * as Yup from "yup";
import { ErrorMessage, Form, Field, Formik } from "formik";
import {toast, ToastContainer} from 'react-toastify';
import { Dna } from "react-loader-spinner";
import 'react-toastify/dist/ReactToastify.css'

export function Create() {
    return (
        <>
            <Formik initialValues={{
                name: "No name",
                age: 18,
                gender: '1',
                languages: ['JAVA', 'ReactJS']
            }}

                validationSchema={Yup.object({
                    name: Yup.string('Phai la chu!').required('Bat buoc nhap!'),
                    age: Yup.number().min(18).required('Bat buoc nhap!'),
                })}

                onSubmit={(values, {setSubmitting}) => {
                        setTimeout(() => {
                            setSubmitting(false)
                            toast("wow so eZ")
                        }, 3000)
                }}>

                {({isSubmitting}) => (
                    <div>
                    <Form>
                        <div>
                            <Field type="text" name='name' />
                            <ErrorMessage name='name' component='span'/>
                        </div>

                        <div>
                            <Field type="text" name='age' />
                            <ErrorMessage name='age' component='span'/>
                        </div>

                        <div>
                            <Field type="radio" name='gender' value='0' id='radio-gender-1' />
                            <label htmlFor="radio-gender-1">Female</label>

                            <Field type="radio" name='gender' value='1' id='radio-gender-2' />
                            <label htmlFor="radio-gender-2">Male</label>
                        </div>

                        <div>
                            <Field type="checkbox" name='languages' value='JAVA' id='check-box-languages-1' />
                            <label htmlFor="check-box-languages-1">JAVA</label>
                        </div>

                        <div>
                            <Field type="checkbox" name='languages' value='ReactJS' id='check-box-languages-2' />
                            <label htmlFor="check-box-languages-2">ReactJS</label>
                        </div>

                        <div>
                            <Field type="checkbox" name='languages' value='C#' id='check-box-languages-3' />
                            <label htmlFor="check-box-languages-3">C#</label>
                        </div>

                        <div>
                            <Field type="checkbox" name='languages' value='PHP' id='check-box-languages-4' />
                            <label htmlFor="check-box-languages-4">PHP</label>
                        </div>

                        {
                            isSubmitting ? 
                            <Dna 
                                visible={true}
                                height="80"
                                width="80"
                                ariaLabel="dna-loading"
                                wrapperClass="dna-wrapper"
                                wrapperStyle={{}}
                            />
                            :
                            <button type="submit">Submit</button>
                        }
                    </Form>
                </div>
                )}

            </Formik>
        </>
    )
}

export default Create;