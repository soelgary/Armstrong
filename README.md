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
