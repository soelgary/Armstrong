Armstrong
=========

Houston, we have deployed code.

![Alt text](http://www.kidport.com/reflib/science/moonlanding/Images/MoonLanding.jpg )

Armstrong is a custom deployer that I use for all the websites that I have. It works by keeping track of all of my hosts and what project is running where and deploys new code to them when appropriate.

ArmstrongService
===============

Api's concerning applications that are/want to be deployed

```GET /application```

Gets a list of all the applications in the Armstrong db

```GET /application/{appName}```

Gets a single application

```POST /application```

Creates a new deployable application

Example payload is as follows
```json
{
  "name": "testApp",
  "ymlPath": "/var/lib/jenkins/jobs/TestService/workspace/TestService/service.yml",
  "buildPath": "/var/lib/jenkins/jobs/TestService/builds/lastSuccessfulBuild/com.gsoeller.testapp$TestService/archive/com.gsoeller.testapp/TestService/0.0.1-SNAPSHOT/TestService-0.0.1-SNAPSHOT.jar",
  "deployPath": "/var/www/TestApp/TestService-0.0.1-SNAPSHOT.jar"
}
```

ArmstrongUI
===========

Static app for Armstrong

To run the app, ```cd``` to ```ArmstrongUI``` then execute ```python -m SimpleHTTPServer 8000```. Once the server is running, you can view the page at ```127.0.0.1:8000``` with your browser.


Want to contribute? Follow these steps

1) clone this repository by running ```git clone https://github.com/soelgary/Armstrong.git```
2) create a new branch ```git checkout -b branch-name```
3) make a change to the code, then add changes to be committed by running ```git add filename```
4) commit changes by running ```git commit```. Use good commit messages so I know what the change is all about.
5) push the change to the repo by running ```git push origin  branch-name```
6) When the changes are ready create a pull request on github for code review.
7) After the code has been approved, merge it into master
