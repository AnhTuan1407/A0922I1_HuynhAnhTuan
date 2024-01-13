import { useEffect, useState } from "react"
import * as productService from '../service/ProductService'
import * as categoryService from '../service/CategoryService'
function ProductList() {
    const [products, setProducts] = useState([])
    const [categories, setCategories] = useState([])

    useEffect(() => {
        const callAPIProduct = async () => {
            const result = await productService.findAll()
            setProducts(result)
        }

        const callAPICategory = async () => {
            const result = await categoryService.findAll()
            setCategories(result)
        }

        callAPIProduct()
        callAPICategory()
    }, [])

    return (
        <>
            <h1>DANH SÁCH SẢN PHẨM</h1>

            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Loại</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Ngày sản xuất</th>
                            <th>Mô tả</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            products.map((product) => (
                                <tr key={product.id}>
                                    <td>{product.name}</td>
                                    <td>{
                                        categories.find(category => String(category.id) === String(product.category))?.nameCategory
                                    }</td>
                                    <td>{product.price}</td>
                                    <td>{product.quantity}</td>
                                    <td>{product.dateOfManufacture}</td>
                                    <td>{product.description}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default ProductList