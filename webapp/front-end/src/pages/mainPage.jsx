import React from "react";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import ListItemSecondaryAction from "@material-ui/core/ListItemSecondaryAction";
import IconButton from "@material-ui/core/IconButton";
import AddIcon from "@material-ui/icons/Add";
import Button from "@material-ui/core/Button";

class mainPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  handleAddClick() {
    console.log("Add Button Pressed");
  }

  render() {
    // To something.
    return (
      <div>
        <div>
          <div id="welcomeMessage">
            <p>Welcome</p>
          </div>
          <Divider />
          <List>
            <ListItem>
              <ListItemText primary="SOFTENG 754" />
              <ListItemSecondaryAction>
                <IconButton
                  edge="end"
                  onClick={() => {
                    this.handleAddClick();
                  }}
                >
                  <AddIcon />
                </IconButton>
              </ListItemSecondaryAction>
            </ListItem>
            <ListItem>
              <ListItemText primary="SOFTENG 701" />
              <ListItemSecondaryAction>
                <IconButton edge="end">
                  <AddIcon />
                </IconButton>
              </ListItemSecondaryAction>
            </ListItem>
            <ListItem>
              <ListItemText primary="SOFTENG 750" />
              <ListItemSecondaryAction>
                <IconButton edge="end">
                  <AddIcon />
                </IconButton>
              </ListItemSecondaryAction>
            </ListItem>
          </List>
          <Divider />
        </div>
        <div>
          <Button variant="outlined">A Button</Button>
        </div>
      </div>
    );
  }
}

export default mainPage;
