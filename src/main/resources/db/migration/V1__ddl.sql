CREATE TABLE todo_table
(
    "todoId" serial NOT NULL,
    content text NOT NULL,
    complete_date date NOT NULL,
    "assignerId" integer NOT NULL,
    status character varying(50) NOT NULL,
    PRIMARY KEY ("todoId")
);

CREATE TABLE user_table
(
    "userId" serial NOT NULL,
    username character varying(100) NOT NULL,
    PRIMARY KEY ("userId")
);

CREATE TABLE task_table
(
    "todoId" integer NOT NULL,
    "assigneeId" integer NOT NULL,
    comment text,
    PRIMARY KEY ("todoId", "assigneeId")
);