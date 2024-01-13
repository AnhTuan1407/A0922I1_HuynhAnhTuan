import {useEffect, useState} from "react";
import * as productService from "../Product_service/productService"
import * as categoryService from "../Category_service/categoryService"
import {NavLink} from "react-router-dom";
import {toast} from "react-toastify";
import {useNavigate} from "react-router-dom"
import ReactPaginate from "react-paginate";

export function ShowList() {
    const navigate = useNavigate()
    const [search, setSearch] = useState("")
    const [productsSearch, setProductsSearch] = useState([])
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);

    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 2; // Số mục trên mỗi trang
    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = productsSearch.slice(indexOfFirstItem, indexOfLastItem);


    useEffect(() => {
        const fetchApi = async () => {
            const products = await productService.findAll();
            setProducts(products);
            const categories = await categoryService.findAllCategory();
            setCategories(categories);
        }

        fetchApi();
    }, [])

    const paginate = (pageNumber) => {
        setCurrentPage(pageNumber);
    }

    //=========================DELETE========================================================
    const deleteProduct = async (id) => {
        const result = await productService.deleteProduct(id);
        toast("🐈Delete success!!!!")
        navigate("/")

    }
    //==========================Search===================================
    useEffect(() => {
        const searchAll = () => {
            const result = products.filter((product) =>
                product.name.toLowerCase().includes(search.toLowerCase()) || product.quantity.includes(search)
            );
            setProductsSearch(result);
        }
        searchAll();
    }, [search, products])

    const filteredProducts = products.filter(product => product.name.includes(search));

    return (
        <>

            <h1>Product List
                <span> <NavLink to="/Create" className="btn btn-primary">Create</NavLink></span>
            </h1>
            <form>
                <input type="text" placeholder="Search" value={search}
                       onChange={(e) => {
                           setSearch(e.target.value)
                       }}/>
            </form>
            <table className="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Category</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {currentItems.map(product => (
                    <tr key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.quantity}</td>
                        <td>{
                            categories.find(category => String(category.id) === String(product.category))?.nameCategory
                        }</td>
                        <td>{product.status}</td>
                        <td>
                            <NavLink to={`/edit/${product.id}`} className="btn btn-primary"> Edit</NavLink>
                            <button onClick={fn => deleteProduct(product.id)} className='btn btn-danger'>Delete</button>
                        </td>
                    </tr>

                ))}
                </tbody>
            </table>


            <nav>
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
            </nav>
        </>
    )

}
