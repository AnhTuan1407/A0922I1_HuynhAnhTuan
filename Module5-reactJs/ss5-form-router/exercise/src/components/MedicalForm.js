import { Formik, Form, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import { ColorRing } from 'react-loader-spinner'
import 'react-toastify/dist/ReactToastify.css'
function MedicalForm() {
    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    identityCard: '',
                    yearOfBirth: 0,
                    gender: '',
                    nationality: '',
                    company: '',
                    position: '',
                    healthInsuranceCard: '1',
                    province: '',
                    district: '',
                    ward: '',
                    apartmentNumber: '',
                    phoneNumber: '',
                    email: ''
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required('Required!'),
                    identityCard: Yup.number().required('Required!'),
                    yearOfBirth: Yup.number().min(1900),
                    nationality: Yup.string().required('Required!'),
                    province: Yup.string().required('Required!'),
                    district: Yup.string().required('Required!'),
                    ward: Yup.string().required('Required!'),
                    apartmentNumber: Yup.number().required('Required!'),
                    phoneNumber: Yup.number().required('Required!'),
                    email: Yup.string().required('Required!').matches('/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$', 'Invalid email address!'),
                })}

                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                        setSubmitting(false)
                    }, 3000)
                }}
            >
                {({ isSubmitting }) => (
                    <>
                        <Form>
                            <div className="background-form">
                                <h1>TỜ KHAI Y TẾ</h1>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput1"><h4>Họ tên</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput1" name='name' />
                                    <ErrorMessage name="name" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput2"><h4>Số hộ chiếu/CMND</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput2" name='identityCard' />
                                    <ErrorMessage name="identityCard" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput3"><h4>Năm sinh</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput3" name='yearOfBirth' />
                                    <ErrorMessage name="yearOfBirth" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <h4>Giới tính</h4>
                                    <label htmlFor="exampleFormControlInput4">Nam</label>
                                    <Field type="radio" id="exampleFormControlInput4" name='gender' value='1' />

                                    <label htmlFor="exampleFormControlInput5">Nữ</label>
                                    <Field type="radio" id="exampleFormControlInput5" name='gender' value='0' />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput6"><h4>Quốc tịch</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput6" name='nationality' />
                                    <ErrorMessage name="nationality" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput7"><h4>Công ty làm việc</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput7" name='company' />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput8"><h4>Bộ phận làm việc</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput8" name='position' />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput9"><h4>Có thẻ bảo hiểm y tế</h4></label>
                                    <Field type="checkbox" id="exampleFormControlInput9" name='healthInsuranceCard' value='1' />
                                </div>

                                <h2>Địa chỉ liên lạc tại Việt Nam</h2>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput10"><h4>Tỉnh thành</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput10" name='province' />
                                    <ErrorMessage name="province" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput11"><h4>Quận/huyện</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput11" name='district' />
                                    <ErrorMessage name="district" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput12"><h4>Phường/Xã</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput12" name='ward' />
                                    <ErrorMessage name="ward" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput13"><h4>Số nhà</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput13" name='apartmentNumber' />
                                    <ErrorMessage name="apartmentNumber" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput14"><h4>Điện thoại</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput14" name='phoneNumber' />
                                    <ErrorMessage name="phoneNumber" className="text-danger" component="span" />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput15"><h4>Email</h4></label>
                                    <Field type="text" className="form-control" id="exampleFormControlInput15" name='email' />
                                    <ErrorMessage name="email" className="text-danger" component="span" />
                                </div>

                                {
                                    isSubmitting ?
                                        <ColorRing
                                            visible={true}
                                            height="80"
                                            width="80"
                                            ariaLabel="blocks-loading"
                                            wrapperStyle={{}}
                                            wrapperClass="blocks-wrapper"
                                            colors={['#e15b64', '#f47e60', '#f8b26a', '#abbd81', '#849b87']}
                                        />
                                        :
                                        <button type="submit">Submit</button>
                                }
                            </div>

                        </Form>
                    </>
                )}
            </Formik>
        </>
    )
}

export default MedicalForm;