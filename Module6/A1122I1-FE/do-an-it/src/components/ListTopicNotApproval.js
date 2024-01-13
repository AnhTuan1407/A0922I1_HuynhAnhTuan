import { useState, useEffect } from 'react';
import { Formik, Form, Field } from 'formik'
import * as approvalTopicService from '../service/ApprovalTopicService';
import { useParams } from "react-router";
import 'react-toastify/dist/ReactToastify.css'
import { ToastContainer, toast } from "react-toastify"
import './ListTopicNotApproval.css'
import { showCancelForm } from './ListTopicNotApprovalScript'
function ListTopicNotApproval() {
    const [topics, setTopics] = useState([])
    const { id } = useParams()
    const [infoTopics, setInfoTopics] = useState([])
    const [infoTopicRegister, setInfoTopicRegister] = useState([])
    const [infoTopicRegisterId, setInfoTopicRegisterId] = useState()
    const [topicId, setTopicId] = useState()
    useEffect(() => {
        const fetchApi = async () => {
            const result = await approvalTopicService.getAllTopicNotApproval(id);
            setTopics(result);
        }
        fetchApi()
    }, [])

    // const handleApproval = async (item) => {
    //     await approvalTopicService.approvalTopic(item)
    //     toast('🦄 Duyệt thành công!!!!');
    // }

    // const handleCancel = async (item) => {
    //     await approvalTopicService.cancelTopic(item)
    //     toast('🦄 Hủy thành công!!!!');
    // }

    const handleApproval = async (item) => {
        displayApprovalForm()
    }

    const handleCancel = async (item) => {
        console.log(item);
        let arrTopic = [item.topic.name, item.topic.content, item.topic.id]
        let arrInfoTopic = [item.id, item.status, item.topicCancel]

        const setInfo = async () => {
            // setInfoTopics((prevState) => prevState = arrTopic)
            // setInfoTopicRegister((prevState) => prevState = arrInfoTopic);
            // setInfoTopicRegisterId((prevState) => prevState = arrInfoTopic[0])
            // setTopicId((prevState) => prevState = arrTopic[2])

            setInfoTopics((prevState) => ({ ...prevState, ...arrTopic }));
            setInfoTopicRegister((prevState) => ({ ...prevState, ...arrInfoTopic }));

            console.log(infoTopics);
            console.log(infoTopicRegister);
        }
        await setInfo()

        if (infoTopics && infoTopicRegister) {
            displayCancelForm()
        } else {
            console.log("Loading....");
        }


        // Ẩn tất cả các form trước khi hiển thị form mới
        // var forms = document.getElementsByClassName("cancel-form");
        // for (var i = 0; i < forms.length; i++) {
        //     forms[i].style.display = "none";
        // }

        // Thêm thông tin id vào form để xác định đề tài cần hủy
        // var hiddenInput = document.createElement("input");
        // hiddenInput.type = "hidden";
        // hiddenInput.name = "cancelId";
        // hiddenInput.value = item.id;
        // cancelForm.appendChild(hiddenInput);
    }

    const displayCancelForm = () => {
        var formsApproval = document.getElementsByClassName("approval-form");
        for (var i = 0; i < formsApproval.length; i++) {
            formsApproval[i].style.display = "none";
        }
        var formsCancel = document.getElementsByClassName("cancel-form");
        for (var i = 0; i < formsCancel.length; i++) {
            formsCancel[i].style.display = "none";
        }
        // Hiển thị form cho id tương ứng
        var cancelForm = document.getElementById("cancelForm");
        cancelForm.style.display = "block";
    }

    const displayApprovalForm = () => {
        var formsApproval = document.getElementsByClassName("approval-form");
        for (var i = 0; i < formsApproval.length; i++) {
            formsApproval[i].style.display = "none";
        }
        var formsCancel = document.getElementsByClassName("cancel-form");
        for (var i = 0; i < formsCancel.length; i++) {
            formsCancel[i].style.display = "none";
        }
        // Hiển thị form cho id tương ứng
        var approvalForm = document.getElementById("approvalForm");
        approvalForm.style.display = "block";
    }

    return topics ? (
        <>
            <div className="header">
                <h2 className="title">KIỂM DUYỆT ĐỀ TÀI</h2>
            </div>

            <div className='container'>
                <div className="content">
                    <div className="row">
                        <div className="col-1"></div>
                        <div className="col-10">
                            <table className="form-table">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên nhóm</th>
                                        <th>Tên đề tài</th>
                                        <th>Mô tả</th>
                                        <th>Duyệt đề tài</th>
                                        <th>Hủy đề tài</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    {
                                        topics.map((item, index) => (
                                            <tr key={item.id}>
                                                <td>{index + 1}</td>
                                                <td>{item.groupAccount.name}</td>
                                                <td>{item.topic.name}</td>
                                                <td>{item.description}</td>
                                                <td className="text-center">
                                                    <button className="btn btn-outline-success"
                                                        onClick={(e) => handleApproval(item)}>Duyệt
                                                    </button>
                                                </td>
                                                <td className="text-center">
                                                    <button className="btn btn-outline-danger"
                                                        onClick={(e) => handleCancel(item)}>Hủy
                                                    </button>
                                                </td>
                                            </tr>
                                        ))
                                    }
                                </tbody>

                            </table>
                        </div>
                        <div className="col-1"></div>
                    </div>
                </div>
            </div>

            <div id="cancelForm" className="cancel-form">
                <h2>Hủy đề tài</h2>
                <div className="col-sm">
                    <label><b>Đề tài</b>: {infoTopics[0]}</label>
                    <br />
                    <label><b>Mô tả</b>: {infoTopics[1]}</label>
                </div>

                <Formik
                    initialValues={{
                        id: infoTopicRegister[0],
                        status: 0,
                        topicCancel: 0,
                        topicId: infoTopics[2],
                        // groupAccountId: 1,
                        // messageCancel: '',
                        // url: 'aaaa',
                        // teacher: null,
                        // studentList: null,
                        // topicProcessList: null
                    }}
                    enableReinitialize

                    onSubmit={(values) => {
                        console.log(values);
                        const cancel = async () => {
                            await approvalTopicService.cancelTopic(values);
                        }
                        cancel()
                        document.getElementById("cancelForm").style.display = "none";
                        toast('🦄 Hủy thành công!!!!');
                    }}
                >
                    <Form>
                        <Field name="id" type="hidden"/>
                        <Field name="status" type="hidden"/>
                        <Field name="topicCancel" type="hidden"/>
                        <Field name="topicId" type="hidden"/>
                        {/* <Field name="groupAccountId" type="hidden" />
                        <Field name="url" type="hidden" />
                        <Field name="teacher" type="hidden" />
                        <Field name="studentList" type="hidden" />
                        <Field name="topicProcessList" type="hidden" /> */}
                        <label htmlFor="reason">Nguyên nhân: </label>
                        <Field style={{ margin: "0 20px" }} type="text" id="reason" name="messageCancel" required />
                        <button type="submit" >Xác nhận hủy</button>
                    </Form>
                </Formik>
            </div>



            <div id='approvalForm' className='approval-form'>
                <Formik
                    initialValues={{

                    }}

                    onSubmit={() => {

                    }}
                >
                    <div>
                        <div className="card">
                            <div className="row">
                                <div className="col-sm">
                                    <Form>
                                        <div>
                                            <div>
                                                <div className="row g-2" data-date-format="dd-mm-yyyy">
                                                    <h5><b>Giai đoạn 1</b></h5>
                                                    <div className="col-sm">
                                                        <label htmlFor="start">Ngày bắt đầu</label>
                                                        <Field className="form-control" name="dateStart" id="start" type="date" required />
                                                    </div>
                                                    <div className="col-sm">
                                                        <label htmlFor="end">Ngày kết thúc</label>
                                                        <Field className="form-control" name="dateEnd" id="end" type="date" required />
                                                    </div>
                                                    <hr />
                                                </div>
                                                <Field name="processNumber" hidden />
                                                <Field name="infoTopicRegister" hidden />
                                            </div>
                                        </div>
                                        <div className="d-grid gap-2">
                                            <button type="button" className="btn btn-secondary" >Thêm mới giai đoạn</button>
                                            <button type="submit" className="btn btn-success">Duyệt</button>
                                            <button type="reset" className="btn btn-info" >Hủy</button>
                                        </div>
                                    </Form>
                                </div>
                                <div className="col-sm" >
                                    <label><b>Đề tài</b>: </label>
                                    <br />
                                    <label><b>Mô tả</b>: </label>
                                </div>
                            </div>

                        </div>
                    </div>
                </Formik>
            </div>
        </>
    ) : "Tất cả đề tài đã đươc phê duyệt!"
}

export default ListTopicNotApproval