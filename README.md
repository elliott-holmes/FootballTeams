# FootballTeams

This project will allow you to generate a WAR file to deploy on a Java Application Server that can support Java 1.8. 

## Download

You can download this project using standard git into eclipse. This will give you the full application

##Build

To build the project you need to run a Maven Build with additional "Clean Install" goals. This should generate a WAR file to deploy.

##Access

Once the WAR file is deployed you should be able to navigate to http://<Server>:<Port>/FootballTeams/ 

Here you should be presented with an index giving you some details on how to use the system

I have tested the build and run using Apache Tomcat 7 and Eclipse JEE Neon.

Hopefully all should work ok, but if there are any build issues, please let me know via your normal contact channel and i'll get it sorted asap
