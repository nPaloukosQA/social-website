# social-website
Coverage: 65%
# Project Title : Social Website

This project is based on famous websites for social media. It is an OOP project that uses a big amount of different technologies that are described below. 
The project uses 3 tables (Register, Social, Post) and the user can interact with that data using a browser. On that specific version of the program, you 
can use the 'GET' method that collects all data from the post table, and the 'POST' method that creates a post. In future improvements the project will be able to do more functions and interact with all the tables. 
The project is tested through a CI pipeline and 
for the testing and troubleshooting, i used jenkins, sonarqube, nexus and Git.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes (Jenkins, Sonarqube, Nexus, Git).

1.Clone the repository on your computer.
2.Using git bash or other command prompt that can access git, clone the repository with the command git clone (and the link of the repo).
3.Open the project as a maven file from your IDE.
4.You have access to the project.


### Prerequisites

What things you need to install the software and how to install them

Java SE 8 or later in order to run the jar file.
Maven to create the jar.
MySQL from your local machine or from GCP instance.
Git and Git Bash
An IDE of your choice
Jenkins as a CI pipeline
Postman (optional)


## Running the tests

To run the tests you can go in the location (ims\src\test\java\com\qa\ims) and incide the folders 
are the Junit tests. In order to run use right click and choose Run as Junit tests or Coverage as Junit test per file.


### Integration Tests 
 Mockito is used for intergration testing. It tests how different classes interact with each other. 


### And coding style tests

Sonarqube is used for static analysis. That tool is useful because it help me find the percentage of coverage for
my tests, and reporting for 'smelly code', bugs and security issues.

To run those tests i used the CI pipeline on jenkins with the configurations below:


1. Login on Jenkins
2. Start your VM instance and run the command (docker start sonarqube).
3. Create a freestyle project and give it any name
4. For the setup on the build window Execute a Windows batch command (for windows machines) mvn sonar:sonar -Dsonar.host.url=http://34.105.244.19:9000 -Dsonar.login.admin='your admin name' -Dsonar.password='your password' 
5. Apply and save the settings and press build now.
## Deployment

1. Clone the repository on your computer.
2. Using a command prompt incide the reposetory directory use the command git bash.
3. Run the commands below:

(ls target)
(mvn clean package)
(java -jar target/NikolaosPaloukos-jar-with-dependencies.jar)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Vaidotas Tadas** 


## Acknowledgments

* Vaidotas Tadas [tvaidotas] (https://github.com/tvaidotas)for providing initial teaching for the new technologies for that project.

* Nick Johnson [nickrstewarttds] (https://github.com/nickrstewarttds) for his knowledge on the Project/Java fundementals and helping.


# Social Website
