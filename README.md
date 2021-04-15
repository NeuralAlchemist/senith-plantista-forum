# Welcome to Plantista Webforum
Last updated: 15-April-2021

Plant lovers unite! Whether you’re a seasoned plant parent or a nervous newbie, Plantista is the online forum for you!
Post your best green-fingered tips or seek help for your floral conundrums.

This project is a Full Stack Application created, tested and implemented by the following SDA members: En-Chi Liu, Diana Bao, Pei-Nen Chee, Qinyu Jia and Yashaswini Seeta. The project's main purpose is to serve as a real-life practice of working in a collaborating environment. Please feel free to use this repo if you wish to implement it in your team.

## Contents

- [Description](https://github.com/NeuralAlchemist/senith-plantista-forum#description)
- [Getting started](https://github.com/NeuralAlchemist/senith-plantista-forum#getting-started)
- [Instructions for the starter template and dependencies](https://github.com/NeuralAlchemist/senith-plantista-forum#instructions-for-the-starter-template-and-dependencies)
- [Credits](https://github.com/NeuralAlchemist/senith-plantista-forum#credits)

## Functionality

The functionalities of the online forum are:
- Make a post
- Delete a post
- View all posts
- Write a comment on a post
- Delete a comment on a post
- View all comments on a post

## Getting started

### For you looking for running the app
1. Clone the repo using `git clone https://github.com/NeuralAlchemist/senith-plantista-forum.git`
2. Open the project in your preferred IDE/Text editor
3. Follow the instructions on [starting the database](https://github.com/NeuralAlchemist/senith-plantista-forum#starting-the-database)
4. Follow the instructions on [starting the frontend development server](https://github.com/NeuralAlchemist/senith-plantista-forum#starting-the-frontend-development-server)
5. Open your browser and navigate to http://localhost:3000
6. Have fun! :)

### For you looking to implement this in your team
1. Clone the repo
2. You'll find the instructions in the "SDA starter template and dependencies below"
3. Make sure you make the necessary edit/changes before using the code

### Q&A and issue tracking

If you have any questions, feedback, or feature requests, don't hesitate to add an issue to the GitHub repo.

# Instructions for the starter template and dependencies

This web starter template is based on Spring, PostgreSQL, React, React router and Axios. Check the following links for documentation and guides:

- [Spring](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org)
- [React](https://reactjs.org)
- [React Router](https://reacttraining.com/react-router/web/guides/quick-start)
- [Axios](https://github.com/axios/axios)

## Setup for developers
Our development environment for a full-stack web application will consist of three main parts:

1. Database (Postgres).
2. Backend server (Spring).
3. Frontend development server (React).

### Prerequisites
- `docker` and `docker-compose`.
- `nodejs`.

### Starting the database
In the root folder, run
```
docker-compose up
```

### Starting the backend server
Open the root folder and run
```
./gradlew bootRun
```

### Starting the frontend development server
The frontend application is in the directory `frontend`. From there, run 
```
npm install
```
to install all the dependencies needed for the project.

Then start the frontend application by running
```
npm start
```

### Inviting collaborators
The following should be done by one person in each group.

Now that you have a repo, you can start inviting your group members as collaborators so that they can work
with you on your repo. Go to `Settings` -> `Manage Access` and then add your group members via their usernames.

### Task instructions
You will find your task instructions in [`Task.md`](Task.md)

## Credits

- Many thanks to all the amazing work from the core team!
- KTH University staff
- Novare
