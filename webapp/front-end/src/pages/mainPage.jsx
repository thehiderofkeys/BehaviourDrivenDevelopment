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
      userName: this.props.match.params.username,
      unenrollCourses: []
    };
  }

  async handleUnenrollClick() {
    fetch(`/api/enrollments/${this.state.userName}/unenroll`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(this.state.unenrollCourses)
    })
      .then(res => res.json())
      .then(() => this.updateCourse());
  }

  handleRemoveClick(courseName) {
    this.setState(prevState => ({
      unenrollCourses: [...prevState.unenrollCourses, courseName]
    }));

    console.log(this.state.unenrollCourses);
  }

  async handleUpdateEnrolmentClick() {
    await this.handleUnenrollClick();
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
                  style={
                    this.state.unenrollCourses.includes(course.courseName)
                      ? { textDecorationLine: "line-through" }
                      : {}
                  }
                />
                <ListItemSecondaryAction>
                  <IconButton
                    courseName={course.courseName}
                    id="unenrollButton"
                    edge="end"
                    onClick={() => {
                      this.handleRemoveClick(course.courseName);
                    }}
                  >
                    <RemoveIcon />
                  </IconButton>
                </ListItemSecondaryAction>
              </ListItem>
            ))}
          </List>
          <Divider />
        </div>
        <div>
          <Button
            id="saveButton"
            variant="outlined"
            onClick={() => this.handleUpdateEnrolmentClick()}
          >
            Update Enrolments
          </Button>
        </div>
      </div>
    );
  }
}

export default mainPage;
