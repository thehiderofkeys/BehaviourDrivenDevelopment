import React from "react";
import "./App.css";
import LoginPage from "./pages/loginPage";
import MainPage from "./pages/mainPage";
import { Route, Switch, BrowserRouter } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={LoginPage} />
          <Route exact path="/:username/main" component={MainPage} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
