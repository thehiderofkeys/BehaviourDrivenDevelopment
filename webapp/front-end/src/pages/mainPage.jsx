import React from "react";
import moment from "moment";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";
import AddIcon from "@material-ui/icons/Add";
import RemoveIcon from "@material-ui/icons/Remove";
import Button from "@material-ui/core/Button";
import {
  Typography,
  ExpansionPanel,
  ExpansionPanelSummary,
  ExpansionPanelDetails,
} from "@material-ui/core";
import TextField from "@material-ui/core/TextField";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";

class mainPage extends React.Component {
  componentDidMount() {
    this.updateCourse();
  }

  constructor(props) {
    super(props);
    this.state = {
      enrolledCourses: [],
      userName: this.props.match.params.username,
      unenrollCourses: [],
      searchedCourses: [],
      courseSearch: "",
      coursesToEnrol: [],
    };
  }

  updateCourse() {
    fetch(`/api/enrollments/${this.state.userName}`, {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => res.json())
      .then((response) => this.setState({ enrolledCourses: response }))
      .then(console.log(this.state.enrolledCourses));
  }

  handleRemoveClick(courseName) {
    this.setState((prevState) => ({
      unenrollCourses: [...prevState.unenrollCourses, courseName],
    }));

    console.log(this.state.unenrollCourses);
  }

  async handleUnenrollClick() {
    fetch(`/api/enrollments/${this.state.userName}/unenroll`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(this.state.unenrollCourses),
    })
      .then((res) => res.json())
      .then(() => this.updateCourse());
  }

  handleEnrolling() {
    fetch(`/api/enrollments/${this.state.userName}/enroll`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(this.state.coursesToEnrol),
    })
      .then((res) => res.json())
      .then(() => this.updateCourse());
  }

  async handleUpdateEnrolmentClick() {
    await this.handleUnenrollClick();
    await this.handleEnrolling();
    this.setState({
      coursesToEnrol: [],
      unenrollCourses: [],
      searchedCourses: [],
    });
  }

  handleChange(event) {
    const val = event.target.value;

    this.setState({
      courseSearch: val,
    });
  }

  handleAddClick(courseName) {
    const foundCourse = this.state.enrolledCourses.some(
      (course) => course.courseName === courseName
    );

    if (foundCourse) {
      alert("You are already enrolled in this course");
    } else {
      this.setState((prevState) => ({
        coursesToEnrol: [...prevState.coursesToEnrol, courseName],
      }));
    }
  }

  handleSearchClick() {
    fetch(`/api/courses?search=` + this.state.courseSearch, {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    })
      .then((res) => res.json())
      .then((response) => this.setState({ searchedCourses: response }))
      .then(console.log(this.state.searchedCourses));
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
            <TextField
              id="courseSearchBar"
              label="Search Course"
              onChange={(event) => {
                this.handleChange(event);
              }}
            />
            <Button
              id="searchButton"
              variant="outlined"
              onClick={() => this.handleSearchClick()}
            >
              Search
            </Button>
            <div>
              <Divider />
            </div>
            <div>
              <Typography align="left">Searched Courses</Typography>
            </div>
            <List>
              {this.state.searchedCourses.map((course) => (
                <div>
                  <ListItem key={course.courseName}>
                    <ExpansionPanel style={{ width: "100%" }}>
                      <ExpansionPanelSummary
                        expandIcon={
                          <IconButton
                            id="searchDetailsButton"
                            courseName={course.courseName}
                          >
                            <ExpandMoreIcon />
                          </IconButton>
                        }
                      >
                        <div
                          style={{
                            display: "flex",
                            justifyContent: "center",
                            alignItems: "center",
                          }}
                        >
                          <Typography id="currentEnrolledCourse">
                            {course.courseName}
                          </Typography>
                          <IconButton
                            id="enrollButton"
                            edge="end"
                            courseName={course.courseName}
                            onClick={() => {
                              this.handleAddClick(course.courseName);
                            }}
                          >
                            <AddIcon />
                          </IconButton>
                        </div>
                      </ExpansionPanelSummary>
                      <ExpansionPanelDetails>
                        <div>
                          <Typography
                            id="LectureTime"
                            courseName={course.courseName}
                          >
                            Lecture Time:{" "}
                            {moment(course.courseSchedule[0].startTime).format(
                              "dddd ha"
                            )}
                          </Typography>
                          <Typography
                            id="TutorialTime"
                            courseName={course.courseName}
                          >
                            Tutorial Time:{" "}
                            {moment(course.courseSchedule[1].startTime).format(
                              "dddd ha"
                            )}
                          </Typography>
                          <Typography
                            id="LabTime"
                            courseName={course.courseName}
                          >
                            Lab Time:{" "}
                            {moment(course.courseSchedule[2].startTime).format(
                              "dddd ha"
                            )}
                          </Typography>
                        </div>
                      </ExpansionPanelDetails>
                    </ExpansionPanel>
                  </ListItem>
                </div>
              ))}
            </List>
          </div>
          <div>
            <Divider />
          </div>
          <div>
            <Typography align="left">My Enrolment Cart</Typography>
          </div>
          <List>
            {this.state.coursesToEnrol.map((course) => (
              <div>
                <ListItem key={course}>
                  <ListItemText primary={course} />
                </ListItem>
              </div>
            ))}
          </List>
          <div>
            <Divider />
          </div>
          <div>
            <Typography align="left">My Enrolments</Typography>
          </div>
          <Divider />
          <List>
            {this.state.enrolledCourses.map((course) => (
              <ListItem key={course.courseName}>
                <ExpansionPanel style={{ width: "100%" }}>
                  <ExpansionPanelSummary
                    expandIcon={
                      <IconButton
                        id="enrolledDetailsButton"
                        courseName={course.courseName}
                      >
                        <ExpandMoreIcon />
                      </IconButton>
                    }
                  >
                    <div
                      style={{
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                      }}
                    >
                      <Typography
                        id="currentEnrolledCourse"
                        style={
                          this.state.unenrollCourses.includes(course.courseName)
                            ? { textDecorationLine: "line-through" }
                            : {}
                        }
                      >
                        {course.courseName}
                      </Typography>
                      <IconButton
                        id="unenrollButton"
                        courseName={course.courseName}
                        edge="end"
                        onClick={(event) => {
                          event.stopPropagation();
                          this.handleRemoveClick(course.courseName);
                        }}
                      >
                        <RemoveIcon />
                      </IconButton>
                    </div>
                  </ExpansionPanelSummary>
                  <ExpansionPanelDetails>
                    <div>
                      <Typography
                        id="LectureTime"
                        courseName={course.courseName}
                      >
                        Lecture Time:{" "}
                        {moment(course.courseSchedule[0].startTime).format(
                          "dddd ha"
                        )}
                      </Typography>
                      <Typography
                        id="TutorialTime"
                        courseName={course.courseName}
                      >
                        Tutorial Time:{" "}
                        {moment(course.courseSchedule[1].startTime).format(
                          "dddd ha"
                        )}
                      </Typography>
                      <Typography id="LabTime" courseName={course.courseName}>
                        Lab Time:{" "}
                        {moment(course.courseSchedule[2].startTime).format(
                          "dddd ha"
                        )}
                      </Typography>
                    </div>
                  </ExpansionPanelDetails>
                </ExpansionPanel>
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
