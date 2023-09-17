import { Component } from "react";
class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [
                {
                    name: "Nguyen Van A",
                    age: 18,
                    address: "Da Nang"
                },
                {
                    name: "Nguyen Van B",
                    age: 20,
                    address: "Ha Noi",
                },
                {
                    name: "Nguyen Van C",
                    age: 21,
                    address: "Sai Gon",
                }
            ],
            name: String,
            age: Number,
            address: String
        }
    }

    // handleAddNewStudent = () => {
        
    // }

    // handleChangeName = (event) => {
    //     this.setState({name:event.target.value})
    // }

    // handleChangeAge = (event) => {
    //     this.setState({age:event.target.value})
    // }

    // handleChangeAddress = (event) => {
    //     this.setState({address:event.target.value})
    // }

    render() {
        return (
            <div> 
                <h1>Hello {this.props.userName}</h1>
                {/* <h2>Add new student</h2>
                <input type="text" onChange={event => this.handleChangeName(event)} value={this.state.name}/>
                <input type="text" onChange={event => this.handleChangeAge(event)} value={this.state.age}/>
                <input type="text" onChange={event => this.handleChangeAddress(event)} value={this.state.address}/>
                <button onClick={this.handleAddNewStudent}>Add</button> */}
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                    </tr>
                    {this.state.studentList.map(student => (
                        <tr>
                            <td>{student.name}</td>
                            <td>{student.age}</td>
                            <td>{student.address}</td>
                        </tr>
                    ))}
                </table>
            </div>
        );
    }
}

export default Home;