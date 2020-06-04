# SE754-Assignment-5
 
 This reposotory contains a fullstack web application for enrollment at the University of Auckland. It contains both frontend and backend code. 
 
 The backend is written in Java using the Jax-RS framework to create a REST API. 
 
 The frontend is written in React.
 
 
 ## Running the back-end
 
 The backend is deployed using Apache Tomcat. This is provided as part of intelliJ Uiltimate. More information regarding the set up of Apache Tomcat can be found [here](http://tomcat.apache.org/).
 
 Use intelliJ to run the backend and deploy it via Apache Tomcat. Follow the steps outlined in [this tutorial](https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/).
 Note that when setting up the configuration, in the deployment tab, set the application context of the 
 Tomcat application to '/'. Also, make sure to use Java JRE version 11.

## Running the front-end

The frontend requires an installation of node.js with a version greater than 12. An installation guide can be found
 [here](https://nodejs.org/en/download/0).

To run the frontend, navigate into where the repository has been installed.
From there, navigate to SE754-Assignment-5/webapp/frontend 

Within this directory, open a terminal and enter the command: 

`npm i`

This will install the necessary dependencies for the frontend.

Then you can run the frontend application with the command: 

`npm start`

## Running tests

Pre-requisite: Firefox web browser version 76+. Download [here](https://www.mozilla.org/en-US/firefox/new/)

Before tests can be run, Gecko driver must first be added to the repository. To do so,
download the zip file corresponding to your operating system from [here](https://github.com/mozilla/geckodriver/releases).
Next, copy and paste the `geckodriver.exe` into the root directory of the project (same location as this README).

In Intellij, ensure the backend and the frontend are running before starting the tests.