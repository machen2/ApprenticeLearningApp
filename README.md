[![Build Status](https://travis-ci.org/machen2/ApprenticeLearningApp.svg?branch=master)](https://travis-ci.org/machen2/ApprenticeLearningApp)

# Pillar Learning Center

The Pillar Learning Center is a tool for Apprentices to track their learning progress. 
Inspiration for this project came from the book "Apprenticeship Patterns", specifically around the Record What You Learn pattern.
The overall idea of this pattern is to create a chronological record of your learning progress so that
you can inspire those around you, revisit what you've learned on a regular basis, and 
preserve your journey.

The Pillar Learning Center is a Spring Boot application and uses MySQL as the database.

#### Current Functionality

`/posts` endpoint for getting a list of all posts

`/posts/new` endpoint for creating a new post

### Getting Started

Build the application with:

```
./gradlew build
```

Run the application with:

```
./gradlew bootRun
```

You can open localhost:8080 to view the application in your browser.

### Testing

#### Run your unit tests

If you are using IntelliJ, you can right click on the unitTest directory select
'Run Tests in com.pillar.pillarLearningCenter...'.

Another option for running your unit tests is to run the following command in your terminal:

```
./gradlew test
```

#### Run your e2e tests

The testing tool used for the end to end tests, along with JUnit, is Geb. http://www.gebish.org/

To run your e2e tests, first start your application with:

```
./gradlew bootRun
```

With your application running, you can now run your e2e tests by right clicking on the
endToEndTests directory and selecting 'Run Tests in com.pillar.pillarLearningCenter...'.
