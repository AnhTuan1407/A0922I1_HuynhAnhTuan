import axios from "axios";
export const findAll = async () => {
    try {
        const result = await axios.get('http://localhost:8080/students');
        return result.data;
    }
    catch(e) {
        console.log(e);
    }
}


export const save = async (student) => {
    try {
        const result = await axios.post('http://localhost:8080/students', student);
    }catch (e) {
        console.log(e);
    }
}