BEGIN;

DROP TABLE IF EXISTS WorkLog;
DROP TABLE IF EXISTS Task;
DROP TABLE IF EXISTS Project;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    userId serial PRIMARY KEY,
    isManager boolean,
    userEmail varchar(255),
    isActivated boolean
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
    taskid serial PRIMARY KEY,
    tasktitle varchar(255),
    taskdescription varchar(255),
    taskiscompleted boolean,
    taskduedate date,
    taskcompletiondate date,
    projectid integer REFERENCES Project(projectID)
);

CREATE TABLE WorkLog (
    logid serial PRIMARY KEY,
    userid integer REFERENCES Users(userId),
    clockin varchar(255),
    clockout varchar(255),
    projectid integer REFERENCES Project(projectID),
    totaltime integer,
    addedcomment varchar(255)
);

COMMIT;