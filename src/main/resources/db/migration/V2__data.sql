INSERT INTO todo_table (content, complete_date, "assignerId", status) VALUES ('Init an exercise', '2020-07-27', 1, 'done');
INSERT INTO todo_table (content, complete_date, "assignerId", status) VALUES ('Create database', '2020-07-28', 1, 'late');
INSERT INTO todo_table (content, complete_date, "assignerId", status) VALUES ('Code the exercise', '2020-07-28', 2, 'done');
INSERT INTO todo_table (content, complete_date, "assignerId", status) VALUES ('Write documents', '2020-08-28', 2, 'open');
INSERT INTO todo_table (content, complete_date, "assignerId", status) VALUES ('Read a handbook', '2020-08-29', 1, 'open');

INSERT INTO user_table (username) VALUES ('Minh0');
INSERT INTO user_table (username) VALUES ('Minh1');
INSERT INTO user_table (username) VALUES ('Minh2');
INSERT INTO user_table (username) VALUES ('Minh3');
INSERT INTO user_table (username) VALUES ('Minh4');


INSERT INTO task_table ("todoId", "assigneeId", comment) VALUES (1, 3, 'I finished it');
INSERT INTO task_table ("todoId", "assigneeId", comment) VALUES (1, 4, 'Done!');
INSERT INTO task_table ("todoId", "assigneeId", comment) VALUES (2, 4, 'Still working');
INSERT INTO task_table ("todoId", "assigneeId", comment) VALUES (4, 4, 'Planning');

