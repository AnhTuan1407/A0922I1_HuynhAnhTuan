import axios from "axios";

export const API_URL = 'http://localhost:8080/products'

export const findAll = async () => {
    try {
        const result = await axios.get(API_URL)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const save = async (product) => {
    try {
        await axios.post(API_URL, product)
    } catch (e) {
        console.log(e)
    }
}
export const findById = async (id) => {
    try {
        const result = await axios.get(API_URL + '/' + id)
        return result.data
    } catch (e) {
        console.log(e)
    }
}

