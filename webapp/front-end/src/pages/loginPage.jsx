import React from "react";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { withRouter } from "react-router-dom";

class loginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: ""
    };
  }

  handleChange(event) {
    const val = event.target.value;
    const id = event.target.id;

    this.setState({
      [id]: val
    });

    console.log(this.state.username);
    console.log(this.state.password);
  }

  handleClick() {
    fetch("/api/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: this.state.username,
        password: this.state.password
      })
    })
      .then(res => res.json())
      .then(isLoginSuccessful => {
        this.props.history.push(
          isLoginSuccessful ? `/${this.state.username}/main` : "/"
        );
      });
  }

  render() {
    // To something.
    return (
      <div>
        <TextField
          id="username"
          label="Username"
          onChange={event => {
            this.handleChange(event);
          }}
        />
        <TextField
          id="password"
          label="Password"
          onChange={event => {
            this.handleChange(event);
          }}
        />
        <Button
          id="loginButton"
          variant="outlined"
          onClick={() => {
            this.handleClick();
          }}
        >
          {" "}
          Login{" "}
        </Button>
      </div>
    );
  }
}

export default withRouter(loginPage);
