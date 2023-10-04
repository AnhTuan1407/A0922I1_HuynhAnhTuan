import axios from "axios"

export const findAll = async () => {
    try {
        const result = await axios.get('http://localhost:8080/library')
        return result.data
    } catch (e) {
        console.log(e);
    }
}

export const save = async (item) => {
    try {
        const result = await axios.post('http://localhost:8080/library', item)
    } catch (e) {
        console.log(e);
    }
}

export const update = async (id, item) => {
    try {
        const result = await axios.put('http://localhost:8080/library/' + id, item)
    } catch (e) {
        console.log(e);
    }
}

export const remove = async () => {

}

export const findById = async (id) => {
    try {
        const result = await axios.get('http://localhost:8080/library/' + id)
        return result.data
    } catch (e) {
        console.log(e);
    }
}