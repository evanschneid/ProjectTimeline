BEGIN TRANSACTION;

INSERT INTO Users (isManager, userEmail, isActivated)
VALUES
    (true, 'johndoe@email.com', true),
    (false, 'janedoe@email.com', true),
    (false, 'jimmylee@email.com', false),
    (true, 'sarahjohnson@email.com', true),
    (false, 'jackharrison@email.com', true),
    (TRUE, 'jill.smith@example.com', TRUE);

INSERT INTO Project (projectTitle, projectDescription, projectImg, projectIsCompleted, projectDueDate, projectCompletionDate, userId, isShared)
VALUES
    ('Website Redesign', 'Redesign the company website', 'website.jpg', FALSE, '2023-03-01', NULL, 1, TRUE),
    ('Mobile App Development', 'Develop a new mobile app for the company', 'mobileapp.jpg', FALSE, '2023-05-01', NULL, 2, FALSE),
    ('Company Retreat', 'Plan the annual company retreat', 'retreat.jpg', FALSE, '2023-07-01', NULL, 1, TRUE),
    ('Marketing Campaign', 'Develop and execute a new marketing campaign', 'marketing.jpg', TRUE, '2023-02-01', '2023-02-28', 2, TRUE),
    ('Project EXPERIENCE', 'A project to enhance customer experience', 'projecte.jpg', true, '2023-04-30', '2023-04-29', 5, true),
    ('Product Launch', 'Launch of new product line', 'product_launch.jpg', FALSE, '2023-01-31', NULL, 2, FALSE),
    ('Sales Dashboard', 'Creation of a sales dashboard for management', 'sales_dashboard.jpg', TRUE, '2023-01-15', '2023-01-10', 4, FALSE);

INSERT INTO Task (tasktitle, taskdescription, taskiscompleted, taskduedate, taskcompletiondate, projectid)
VALUES
    ('Design Homepage', 'Design the homepage for the website redesign project', FALSE, '2023-03-01', NULL, 1),
    ('Develop Login Feature', 'Develop the login feature for the mobile app', FALSE, '2023-02-11', NULL, 2),
    ('Plan Team Building Activities', 'Plan team building activities for the company retreat', FALSE, '2023-07-01', NULL, 3),
    ('Create Social Media Ads', 'Create social media ads for the marketing campaign', TRUE, '2023-02-01', '2023-02-15', 4),
    ('Design Login Screen', 'Design the login screen for the mobile app', TRUE, '2023-05-01', '2023-05-01', 2),
    ('Design About Us Page', 'Design the About Us page for the website', TRUE, '2022-12-20', '2022-12-19', 1),
    ('Write Press Release', 'Write a press release for the product launch', FALSE, '2023-02-10', NULL, 2),
    ('Create Marketing Plan', 'Create a marketing plan for the new product', FALSE, '2023-02-10', NULL, 3),
    ('Build Sales Dashboard', 'Build the sales dashboard for management', TRUE, '2023-02-010', '2023-01-02', 4),
    ('Test Sales Dashboard', 'Test the sales dashboard for functionality', TRUE, '2023-02-10', '2023-01-07', 4);

INSERT INTO WorkLog (userid, clockin, clockout, projectid, totaltime, addedcomment)
VALUES
    (1, '2022-12-26 10:00:00', '2022-12-26 12:00:00', 1, 120, 'Worked on designing homepage'),
    (2, '2022-12-26 08:00:00', '2022-12-26 11:00:00', 2, 180, 'Worked on developing login feature'),
    (1, '2022-12-27 09:00:00', '2022-12-27 11:00:00', 3, 120, 'Worked on planning team building activities'),
    (2, '2022-12-28 10:00:00', '2022-12-28 12:00:00', 4, 120, 'Worked on creating social media ads'),
    (1, '2022-12-29 09:00:00', '2022-12-29 11:00:00', 5, 120, 'Worked on designing login screen'),
    (4, '2022-12-30 7:00:00', '2022-12-20 2:00:00', 6, 420, 'Worked on homepage and about us page designs'),
    (4, '2022-12-31 1:00:00', '2022-12-31 2:00:00', 7, 60, 'Wrote first draft of press release'),
    (3, '2023-1-02 11:00:00', '2022-1-02 2:00:00', 3, 180, 'Worked on marketing plan'),
    (4, '2023-1-20 10:00:00', '2022-1-20 2:00:00', 4, 240, 'Built and tested sales dashboard'),
    (5, '2023-1-21 9:00:00', '2022-1-21 2:00:00', 1, 300, 'Finalized homepage design'),
    (2, '2023-1-22 9:00:00', '2022-1-22 2:00:00', 2, 300, 'Testing'),
    (3, '2023-1-23 10:00:00', '2022-1-23 5:00:00', 3, 420, 'Completed project requirements analysis'),
    (2, '2023-1-23 12:00:00', '2022-1-23 3:00:00', 2, 180, 'Finished project design phase'),
    (6, '2023-1-24 1:00:00', '2022-1-24 4:00:00', 1, 180, 'Implemented project features'),
    (4, '2023-1-24 9:00:00', '2022-1-24 4:00:00', 1, 420, 'Debugged and tested project functionality');

COMMIT TRANSACTION;
