BEGIN;

DROP TABLE IF EXISTS WorkLog;
DROP TABLE IF EXISTS Task;
DROP TABLE IF EXISTS Project;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    userId serial PRIMARY KEY,
    isManager boolean,
    userEmail varchar(255)
);

CREATE TABLE Project (
    projectID serial PRIMARY KEY,
    projectTitle varchar(255),
    projectDescription varchar(255),
    projectImg varchar(255),
    projectIsCompleted boolean,
    projectDueDate date,
    projectCompletionDate date,
    userId integer REFERENCES Users(userId),
    isShared boolean
);

CREATE TABLE Task (
    taskID serial PRIMARY KEY,
    taskTitle varchar(255),
    taskDescription varchar(255),
    taskisCompleted boolean,
    taskDueDate date,
    taskCompletionDate date,
    projectID integer REFERENCES Project(projectID)
);

CREATE TABLE WorkLog (
    logID serial PRIMARY KEY,
    userId integer REFERENCES Users(userId),
    clockIn timestamp,
    clockOut timestamp,
    projectID integer REFERENCES Project(projectID),
    totalTime interval,
    addedComment varchar(255)
);

COMMIT;