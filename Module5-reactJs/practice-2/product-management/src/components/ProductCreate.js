import { Formik, Form, Field, ErrorMessage } from 'formik'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import * as Yup from 'yup'
import * as categoryService from '../service/CategoryService'
import * as productService from '../service/ProductService'
function ProductCreate() {
    const navigate = useNavigate()

    const [categories, setCategories] = useState([])

    useEffect(() => {
        const getCategories = async () => {
            const result = await categoryService.findAll()
            setCategories(result)
        }
        getCategories()
    }, [])

    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    category: 1,
                    price: '',
                    quantity: '',
                    dateOfManufacture: '',
                    description: ''
                }}

                validationSchema={Yup.object({
                    name: Yup.string().required('Không được để trống!'),
                    dateOfManufacture: Yup.string().required('Không được để trống!'),
                    quantity: Yup.number().required('Không được để trống!'),
                    price: Yup.number().required('Không được để trống!').min(0, 'Giá phải lớn hơn 0')
                })}

                onSubmit={(values, { setSubmitting }) => {
                    const selectedCategory = categories.find(
                        (category) => category.id === values.category.id
                    );
                    const categoryId = selectedCategory ? selectedCategory.id : '';
                    const categoryName = selectedCategory ? selectedCategory.name : '';
                    console.log(categoryName);
                    values.category.name = categoryName

                    const create = async () => {
                        // setSubmitting(false)
                        await productService.save(values)
                        toast('🦄 Thêm mới thành công!', {
                            position: "top-right",
                            autoClose: 5000,
                            hideProgressBar: false,
                            closeOnClick: true,
                            pauseOnHover: true,
                            draggable: true,
                            progress: undefined,
                            theme: "light",
                        });
                        navigate('/')
                    }

                    create()
                }}
            >

                <Form>
                    <div>
                        <label>Tên sản phẩm</label>
                        <Field name='name' />
                        <ErrorMessage name='name' component='span' className='text-danger' />
                    </div>

                    <div>
                        <label>Loại sản phẩm</label>

                        <Field name='category.id' as="select">
                            <option value="">Select a category</option>
                            {
                                categories.map((category) => (
                                    <option key={category.id} value={category.id}>{category.name}</option>
                                ))
                            }
                        </Field>

                    </div>

                    <div>
                        <label>Giá sản phẩm</label>
                        <Field name='price' />
                        <ErrorMessage name='price' component='span' className='text-danger' />
                    </div>

                    <div>
                        <label>Ngày sản xuất</label>
                        <Field name='dateOfManufacture' />
                        <ErrorMessage name='dateOfManufacture' component='span' className='text-danger' />
                    </div>

                    <div>
                        <label>Số lượng sản phẩm</label>
                        <Field name='quantity' />
                        <ErrorMessage name='quantity' component='span' className='text-danger' />
                    </div>

                    <div>
                        <label>Mô tả sản phẩm</label>
                        <Field name='description' />
                    </div>

                    <div>
                        <button className='btn btn-primary' type='submit'>Thêm sản phẩm</button>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

export default ProductCreate