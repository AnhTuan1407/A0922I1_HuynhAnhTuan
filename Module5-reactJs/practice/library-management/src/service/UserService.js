import axios from "axios";
const API_URL = 'http://localhost:8080/users'
export const findAll = async () => {
    try {
        const result = await axios.get(API_URL)
        return result.data
    } catch (e) {
        console.log(e);
    }
} 

export const findById = async (id) => {
    try {
        const result = await axios.get(API_URL + '/' + id)
        return result.data
    } catch (e) {
        console.log(e);
    }
} 

export const save = async (item) => {
    try {
        await axios.post(API_URL, item)
    } catch (e) {
        console.log(e);
    }
} 

export const update = async (id, item) => {
    try {
        await axios.put(API_URL + '/' + id, item)
    } catch (e) {
        console.log(e);
    }
}