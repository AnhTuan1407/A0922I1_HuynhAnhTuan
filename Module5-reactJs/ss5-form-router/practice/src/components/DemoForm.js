import { Field, Formik, Form, ErrorMessage } from "formik";
import { toast } from "react-toastify";
import * as Yup from "yup";
import { Dna } from "react-loader-spinner";

function DemoForm() {

    return (
        <>
            <h1>CREATE FORM</h1>

            <Formik
                initialValues={{
                    name: 'No name',
                    age: 18,
                    gender: '1',
                    email: 'abc@gmail.com',
                    languages: ['JAVA', 'ReactJS']
                }}

                validationSchema={Yup.object({
                    name: Yup.string('Phải là chữ!').required('Không được để trống'),
                    age: Yup.number().min(18).required('Không được để trống'),
                    email: Yup.string().required('Không được để trống')
                })}

                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                        setSubmitting(false)
                        toast("wow so eZ")
                    }, 3000)
                }}
            >
                {({ isSubmitting }) => (
                    <Form>
                    <div class="form-group">
                        <label htmlFor="exampleFormControlInput1">Name</label>
                        <Field type="text" className="form-control" id="exampleFormControlInput1" name='name' />
                        <ErrorMessage name="name" className="text-danger" />
                    </div>

                    <div class="form-group">
                        <label htmlFor="exampleFormControlInput2">Age</label>
                        <Field type="text" className="form-control" id="exampleFormControlInput2" name='age' />
                        <ErrorMessage name="age" className="text-danger" />
                    </div>

                    <div class="form-group">
                        <label htmlFor="exampleFormControlInput3">Email</label>
                        <Field type="text" className="form-control" id="exampleFormControlInput3" name='email' />
                        <ErrorMessage name="email" className="text-danger" />
                    </div>

                    <div>
                        <h4>Gender</h4>
                    </div>

                    <div class="form-check">
                        <Field className="form-check-input" type="radio" name="gender" id="exampleRadios1" value='1' />
                        <label className="form-check-label" htmlFor="exampleRadios1">
                            Male
                        </label>
                    </div>

                    <div class="form-check">
                        <Field class="form-check-input" type="radio" name="gender" id="exampleRadios2" value='0' />
                        <label class="form-check-label" htmlFor="exampleRadios2">
                            Female
                        </label>
                    </div>

                    <div>
                        <h4>Languages</h4>
                    </div>

                    <div class="form-check">
                        <Field className="form-check-input" type="checkbox" value="JAVA" id="defaultCheck1" name='languages' />
                        <label className="form-check-label" htmlFor="defaultCheck1">
                            JAVA
                        </label>
                    </div>

                    <div class="form-check">
                        <Field className="form-check-input" type="checkbox" value="ReactJS" id="defaultCheck2" name="languages" />
                        <label className="form-check-label" htmlFor="defaultCheck2">
                            ReactJS
                        </label>
                    </div>

                    <div class="form-check">
                        <Field className="form-check-input" type="checkbox" value="C#" id="defaultCheck3" name="languages" />
                        <label className="form-check-label" htmlFor="defaultCheck3">
                            C#
                        </label>
                    </div>

                    <div class="form-check">
                        <Field className="form-check-input" type="checkbox" value="PHP" id="defaultCheck4" name="languages" />
                        <label className="form-check-label" htmlFor="defaultCheck4">
                            PHP
                        </label>
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
                )}

            </Formik>
        </>

    )
}

export default DemoForm;