import axios from "axios";
export const API_URL = 'http://localhost:8080/categories'

export const findAll = async () => {
    try {
        const result = await axios.get(API_URL);
        return result.data
    } catch (e) {
        console.log(e);
    }
}
