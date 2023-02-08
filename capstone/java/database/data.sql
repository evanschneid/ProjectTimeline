BEGIN TRANSACTION;

INSERT INTO Users (isManager, userEmail, isActivated)
VALUES
    (true, 'manager1@example.com', true),
    (false, 'user1@example.com', false),
    (false, 'user2@example.com', true);

INSERT INTO Project (projectTitle, projectDescription, projectImg, projectIsCompleted, projectDueDate, projectCompletionDate, userId, isShared)
VALUES
    ('Project 1', 'Description for Project 1', 'project1.jpg', false, '2023-03-01', null, 1, true),
    ('Project 2', 'Description for Project 2', 'project2.jpg', false, '2023-03-15', null, 2, false),
    ('Project 3', 'Description for Project 3', 'project3.jpg', true, '2022-12-31', '2022-12-31', 3, true);

INSERT INTO Task (taskTitle, taskDescription, taskisCompleted, taskDueDate, taskCompletionDate, projectID)
VALUES
    ('Task 1', 'Description for Task 1', false, '2023-03-01', null, 1),
    ('Task 2', 'Description for Task 2', true, '2023-03-15', '2023-03-15', 2),
    ('Task 3', 'Description for Task 3', false, '2022-12-31', null, 3);

INSERT INTO WorkLog (userID, clockIn, clockOut, projectID, totalTime, addedComment)
VALUES
(1, '2022-12-31 08:00:00', '2022-12-31 17:00:00', 1, INTERVAL '9 hours', 'Worked on Project 1'),
(1, '2022-12-31 08:00:00', '2022-12-31 12:00:00', 2, INTERVAL '4 hours', 'Worked on Project 2'),
(1, '2022-12-31 08:00:00', '2022-12-31 17:00:00', 3, INTERVAL '9 hours', 'Worked on Project 3'),
(1, '2023-02-01 08:00:00', '2023-02-07 17:00:00', 1, INTERVAL '9 hours', 'Worked on Project 4'),
(1, '2023-02-01 08:00:00', '2023-02-07 17:00:00', 1, INTERVAL '9 hours', 'Worked on Project 5');

COMMIT TRANSACTION;
