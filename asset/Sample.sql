-- SQL for tables

START TRANSACTION;
DROP TABLE IF EXISTS todo_table;
DROP TABLE IF EXISTS user_table;
DROP TABLE IF EXISTS task_table;

CREATE TABLE todo_table ("todoId" serial NOT NULL PRIMARY KEY, content text NOT NULL, complete_date date NOT NULL);

CREATE TABLE user_table ("userId" serial NOT NULL PRIMARY KEY, username character varying(100) NOT NULL);

CREATE TABLE task_table ("todoId" integer NOT NULL, "userId" integer NOT NULL, complete boolean NOT NULL, PRIMARY KEY ("todoId", "userId"));

INSERT INTO todo_table (content, complete_date) VALUES ('Init an exercise', '2020-07-27');
INSERT INTO todo_table (content, complete_date) VALUES ('Create database', '2020-07-28');
INSERT INTO todo_table (content, complete_date) VALUES ('Code the exercise', '2020-07-28');
INSERT INTO todo_table (content, complete_date) VALUES ('Write documents', '2020-07-28');
INSERT INTO todo_table (content, complete_date) VALUES ('Read a handbook', '2020-07-29');

INSERT INTO user_table (username) VALUES ('minh');
INSERT INTO user_table (username) VALUES ('minh1');
INSERT INTO user_table (username) VALUES ('minh2');

COMMIT;