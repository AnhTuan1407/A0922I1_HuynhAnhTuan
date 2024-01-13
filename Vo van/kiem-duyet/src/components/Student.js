import {Formik, Form, Field} from 'formik'
function Student() {

    return(
        <>
            <h1>ĐĂNG KÝ ĐỀ TÀI</h1>

            <div>
                <Formik
                    initialValues={{
                        nameProject: '',
                        descriptionProject: ''
                    }}

                    onSubmit={(values) => {
                        
                    }}
                >
                    <Form>
                        <div>
                            <label>Tên đề tài</label>
                            <Field type='text' name='nameProject'/>
                        </div>

                        <div>
                            <label>Nội dung đề tài</label>
                            <Field as='textarea' name='descriptionProject'></Field>
                        </div>

                        <button type='submit'>ĐĂNG KÝ</button>
                    </Form>
                </Formik>
            </div>
        </>
    )
}

export default Student