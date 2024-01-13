import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom"
import * as productService from "../Product_service/productService"
import * as categoryService from "../Category_service/categoryService"
import {Field, Form, Formik} from "formik";
import {toast} from "react-toastify";

export function Edit() {
    const nagivate = useNavigate();
    const {id} = useParams();
    const [categories, setCategories] = useState([]);
    const [product, setProduct] = useState({
        id: 0,
        name: " ",
        quantity: " ",
        category: 1,
        status: " "
    })
    const findAll = async () => {
        const result = await categoryService.findAllCategory();
        setCategories(result)
    }
    useEffect(() => {
        const findByid = async () => {
            try {
                console.log(id)
                const result = await productService.findById(id);
                console.log(result)
                setProduct(result);
            } catch (e) {
                console.log(e)
            }
        }
        findByid()
        findAll()
    }, [])
    return product.name !== " " ? (
        <>
            <Formik initialValues={{
                id: product.id,
                name: product.name,
                quantity: product.quantity,
                category: product.category,
                status: product.status
            }} onSubmit={(productEdited) => {
                const update = async () => {
                    try {
                        const result = productService.updateProduct(id, productEdited);
                        toast(`🦁 Edit student ${productEdited.name} successful!!!`)
                        nagivate("/");
                    } catch (e) {
                        console.log(e);
                    }
                }
                update();
            }}>
                <div>
                    <h1>Create new product</h1>
                    <Form className="form">
                        <div>
                            <label>Id</label>
                            <Field type="text" name="id"/>
                        </div>
                        <div>
                            <label>Name</label>
                            <Field type="text" name="name"/>
                        </div>
                        <div>
                            <label>Quantity</label>
                            <Field type="text" name="quantity"/>
                        </div>
                        <div>
                            <label>Category</label>
                            <Field name="category" as="select">
                                {categories.map((category) => (
                                    <option value={(category.id)}>{category.nameCategory}</option>
                                ))}
                            </Field>
                        </div>
                        <div>
                            <label>Status</label>
                            <Field type="text" name="status"/>
                        </div>
                        <div>
                            <button type='submit' className='btn btn-primary'>Submit</button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    ) : ""
}
