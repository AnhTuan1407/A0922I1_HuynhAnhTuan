import axios from "axios"

export const getAllTopicNotApproval = async (id) => {
    try {
        const result = await axios.get('http://localhost:8080/get-topic-not-approval' + '?teacherId=' + id);
        return result.data;
    }
    catch (e) {
        console.log(e);
    }
}

export const approvalTopic = async (item) => {
    try {
        await axios.post('http://localhost:8080/approval', item);
    }
    catch (e) {
        console.log(e);
    }
}

export const cancelTopic = async (item) => {
    try {
        await axios.post('http://localhost:8080/api/public/topic-manager/cancel-topic', item);
    }
    catch (e) {
        console.log(e);
    }
}


export const createProcess = async (item) => {
    try {
        await axios.post('http://localhost:8080/api/public/topic-manager/create-process', item);
    }
    catch (e) {
        console.log(e);
    }
}
