import { useEffect, useState } from "react";
import * as productService from "../service/ProductService"
import * as categoryService from "../service/CategoryService"
import { NavLink } from "react-router-dom";
import { useNavigate } from "react-router-dom"


function List() {
    const navigate = useNavigate()
    const [search, setSearch] = useState("")
    const [searchCategory, setSearchCategory] = useState([])
    const [productsSearch, setProductsSearch] = useState([]) 
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);

    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 100;
    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = productsSearch.slice(indexOfFirstItem, indexOfLastItem);

    useEffect(() => {
        const fetchApi = async () => {
            const products = await productService.findAll();
            setProducts(products);
            const categories = await categoryService.findAll();
            setCategories(categories);
        }

        fetchApi();
    }, [])

    const paginate = (pageNumber) => {
        setCurrentPage(pageNumber);
    }


    //==========================Search===================================
    useEffect(() => {
        const searchAll = () => {
            const result = products.filter((product) =>
                product.name.toLowerCase().includes(search.toLowerCase())
            );
            setProductsSearch(result);
        }

        const searchAllCategory = () => {
            const result = products.filter((product) =>
                String(searchCategory) === String(product.category)
            );
            setSearchCategory(result);
        }
        searchAll();
        searchAllCategory();
    }, [search, products, searchCategory])

    const filteredProducts = products.filter(product => product.name.includes(search));

    return (
        <>

            <h1>DANH SÁCH SẢN PHẨM
                <span> <NavLink to="/create" className="btn btn-primary">Thêm mới</NavLink></span>
            </h1>
            <form>
                <input type="text" placeholder="Tìm tên sản phẩm" value={search}
                    onChange={(e) => {
                        setSearch(e.target.value)
                    }} />

                <select onChange={(e) => {
                    setSearchCategory(e.target.value)
                }}
                    value={searchCategory}
                >
                    {categories.map((category) => (
                        <option value={(category.id)}>{category.name}</option>
                    ))}
                </select>
            </form>


            <table className="table">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Thể loại</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Ngày nhập</th>
                    </tr>
                </thead>
                <tbody>
                    
                    {
                        currentItems.map(product => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.idProduct}</td>
                                <td>{product.name}</td>
                                <td>{
                                    categories.find(category => String(category.id) === String(product.category))?.name
                                }</td>
                                <td>{product.quantity}</td>
                                <td>{product.price}</td>
                                <td>{product.date}</td>
                            </tr>

                        ))
                    }
                </tbody>
            </table>

            {/* <nav>
                <ul className="pagination justify-content-center">
                    <div className={`page-item ${currentPage === 1 ? 'disabled' : ''}`}>
                        <button className="page-link" onClick={() => paginate(currentPage - 1)}>Previous</button>
                    </div>
                    {Array.from({length: Math.ceil(filteredProducts.length / itemsPerPage)}).map((_, index) => (
                        <div key={index} className={`page-item ${index + 1 === currentPage ? 'active' : ''}`}>
                            <button className="page-link" onClick={() => paginate(index + 1)}>{index + 1}</button>
                        </div>
                    ))}
                    <div className={`page-item ${currentPage === Math.ceil(filteredProducts.length / itemsPerPage) ? 'disabled' : ''}`}>
                        <button className="page-link" onClick={() => paginate(currentPage + 1)}>Next</button>
                    </div>
                </ul>
            </nav> */}
        </>
    )
}
export default List
