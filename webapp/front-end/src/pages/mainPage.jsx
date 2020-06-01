import React from "react";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import ListItemSecondaryAction from "@material-ui/core/ListItemSecondaryAction";
import IconButton from "@material-ui/core/IconButton";
import AddIcon from "@material-ui/icons/Add";
import RemoveIcon from "@material-ui/icons/Remove";
import Button from "@material-ui/core/Button";
import { Typography } from "@material-ui/core";
import TextField from "@material-ui/core/TextField";

class mainPage extends React.Component {
  componentDidMount() {
    this.updateCourse();
  }

  constructor(props) {
    super(props);
    this.state = {
      enrolledCourses: [{}],
      userName: this.props.match.params.username
    };
  }

  updateCourse() {
    fetch(`/api/enrollments/${this.state.userName}`, {
      method: "GET",
      headers: { "Content-Type": "application/json" }
    })
      .then(res => res.json())
      .then(response => this.setState({ enrolledCourses: response }))
      .then(console.log(this.state.enrolledCourses));
  }

  render() {
    // To something.
    return (
      <div>
        <div>
          <div id="welcomeMessage">
            <p>Welcome</p>
          </div>
          <div>
            <Divider />
          </div>
          <div>
            <Typography align="left">My Enrolments</Typography>
          </div>
          <Divider />
          <List>
            {this.state.enrolledCourses.map(course => (
              <ListItem key={course.courseName}>
                <ListItemText
                  primary={course.courseName}
                  id="currentEnrolledCourse"
                />
                <ListItemSecondaryAction>
                  <IconButton edge="end" onClick={() => {}}>
                    <RemoveIcon />
                  </IconButton>
                </ListItemSecondaryAction>
              </ListItem>
            ))}
          </List>
          <Divider />
        </div>
        <div></div>
      </div>
    );
  }
}

export default mainPage;
