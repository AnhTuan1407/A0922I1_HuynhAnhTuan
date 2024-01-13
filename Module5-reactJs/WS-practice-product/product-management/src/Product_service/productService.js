import axios from "axios";

export const findAll = async () => {
    try {
        const result = await axios.get("http://localhost:8080/product")
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const createProduct = async (product) => {
    try {
        const result = await axios.post("http://localhost:8080/product/", product)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const findById = async (id) => {
    try {
        const result = await axios.get("http://localhost:8080/product/" + id)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const updateProduct = async (id, product) => {
    try {
        const result = await axios.put("http://localhost:8080/product/" + id, product)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const deleteProduct = async (id) => {
    try {
        const result = await axios.delete("http://localhost:8080/product/" + id)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
