import { useNavigate } from "react-router-dom"
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useEffect, useState } from "react";
import * as productService from "../service/ProductService"
import * as categoryService from "../service/CategoryService"
import { toast } from "react-toastify";
import * as Yup from 'yup'

function Create() {
    const nagivate = useNavigate();
    const [categories, setCategories] = useState([])
    useEffect(() => {
        findAll();
    }, []);
    const findAll = async () => {
        const result = await categoryService.findAll();
        setCategories(result)
    }
    return (
        <>
            <Formik initialValues={{
                idProduct: '',
                name: '',
                description: '',
                category: 1,
                price: 0,
                quantity: 0,
                date: ''
            }}

                validationSchema={Yup.object({
                    idProduct: Yup.string().required('Không được để trống!').matches(/^PROD-[0-9]{4}$/, 'Mã sản phẩm phải có dạng PROD-xxxx'),
                    name: Yup.string().required('Không được để trống!'),
                    description: Yup.string().required('Không được để trống!'),
                    price: Yup.number().required('Không được để trống!'),
                    quantity: Yup.number().required('Không được để trống!').min(0, 'Phải lớn hơn 0').integer('Phải là số nguyên'),
                    date: Yup.string().required('Không được để trống!'),
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const create = async () => {
                        setSubmitting(false)
                        await productService.save(values);

                    }
                    toast("😺 Create successful!!!")
                    nagivate("/")
                    create();
                }}>


                <div>
                    <h1>Thêm mới sản phẩm</h1>
                    <Form className="form">

                        <table className="table">
                            <tbody>
                                <tr>
                                    <td>
                                        <div>
                                            <label>Mã sản phẩm</label>
                                        </div>
                                    </td>

                                    <td>
                                        <Field type="text" name="idProduct" />
                                        <ErrorMessage name="idProduct" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Tên sản phẩm</label>
                                    </td>

                                    <td>
                                        <Field type="text" name="name" />
                                        <ErrorMessage name="name" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Thể loại</label>
                                    </td>

                                    <td>
                                        <Field name="category" as="select">
                                            {categories.map((category) => (
                                                <option value={(category.id)}>{category.name}</option>
                                            ))}
                                        </Field>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Giá</label>
                                    </td>
                                    <td>
                                        <Field type="number" name="price" />
                                        <ErrorMessage name="price" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Số lượng</label>
                                    </td>

                                    <td>
                                        <Field type="number" name="quantity" />
                                        <ErrorMessage name="quantity" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Ngày nhập</label>
                                    </td>

                                    <td>
                                        <Field type="date" name="date"/>
                                        <ErrorMessage name="date" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Mô tả sản phẩm</label>
                                    </td>

                                    <td>
                                        <Field type="text" as='textarea' name="description" />
                                        <ErrorMessage name="description" className="text-danger" component='span' />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <div>
                                            <button type='submit' className='btn btn-primary'>Thêm mới</button>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </Form>
                </div>
            </Formik>
        </>
    )
}
export default Create