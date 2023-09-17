import { Component } from "react";
import Home from './components/Home';
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    }
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true })
  }

  handelLogout = () => {
    this.setState({ isLoggedIn: false })
  }

  render() {

    return (
      <>
        {this.state.isLoggedIn && <div>
          <Home userName="Master" />
          <button onClick={this.handelLogout}>Logout</button>
        </div>}

        {!this.state.isLoggedIn && <div style={{ textAlign: "center" }}>
          <h1>Login please</h1>
          <button onClick={this.handleLogin}>Login</button>
        </div>}
      </>
    );
  }
}

export default App;