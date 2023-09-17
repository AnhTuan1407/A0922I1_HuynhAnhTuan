import { Component } from "react";
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todoList: [],
      item: ''
    }
  }

  handleChange = (event) => {
    this.setState({
      item: event.target.value
    })
  }

  handleAddNew = () => {
    if (this.state.item != '') {
      this.setState({
        todoList: [...this.state.todoList, this.state.item]
      })
    }

    this.setState({
      item: ''
    })
  }

  render() {
    return (
      <div>
        <h1>Add new</h1>
        <input type="text" onChange={(event => this.handleChange(event))} value={this.state.item} />
        <button onClick={this.handleAddNew}>Add</button>
        <h1>Todo List</h1>
        <table>
          {this.state.todoList.map(todo => (
            <tr>
              <td>{todo}</td>
            </tr>
          ))}
        </table>
      </div>
    )
  }
}
export default App;
