import { Component } from "react";
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      num: 0,
      backgroundColor : "white"
    }
  }

  componentDidMount() {
    setTimeout(() => {
      this.setState({backgroundColor : this.state.backgroundColor = "pink"})
    }, 5000)
  }

  increase = () => {
    this.setState({num : this.state.num + 1});
  }

  decrease = () => {
    this.setState({num : this.state.num - 1});
  }

  render() {
    return(
      <div style={{backgroundColor: this.state.backgroundColor, color: "while", paddingTop: 20, width: "100%", height: 80, margin: 'auto'}}>
          <button onClick={this.increase}>Increase</button>
          <span style={{ padding: 10 }}>{this.state.num}</span>
          <button onClick={this.decrease}>Decrease</button>
      </div>
    )
  }
}

export default App;