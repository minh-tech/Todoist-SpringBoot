CREATE TABLE todo_table ("todoId" serial NOT NULL PRIMARY KEY, content text NOT NULL, complete_date date NOT NULL);

CREATE TABLE user_table ("userId" serial NOT NULL PRIMARY KEY, username character varying(100) NOT NULL);

CREATE TABLE task_table ("todoId" integer NOT NULL, "userId" integer NOT NULL, complete boolean NOT NULL, PRIMARY KEY ("todoId", "userId"));