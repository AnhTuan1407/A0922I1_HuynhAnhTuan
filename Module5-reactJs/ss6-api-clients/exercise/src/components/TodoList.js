import { Formik, Form, Field } from "formik";
import { useEffect, useState } from "react";
import * as todoService from '../service/TodoService'
import { Navigate, useNavigate } from "react-router-dom"
function TodoList() {
    const navigate = useNavigate();
    const [todoList, setTodoList] = useState([]);

    useEffect(() => {
        const callApi = async () => {
            const result = await todoService.findAll();
            setTodoList(result);
        }
        callApi()
    }, [])

    return (
        <>
            <Formik
                initialValues={{
                    item: ''
                }}

                onSubmit={(values, { setSubmitting }) => {
                    todoService.save(values);
                    setSubmitting(false)
                    window.location.reload();
                }}
            >
                <Form>
                    <div>
                        <h1>ADD NEW TODO</h1>

                        <div>
                            <Field name='item' />
                        </div>

                        <button type="submit">Submit</button>
                    </div>
                </Form>
            </Formik>

            <div>
                <h1>TODO LIST</h1>

                <table className="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Item</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            todoList.map((todo) => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.item}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default TodoList;