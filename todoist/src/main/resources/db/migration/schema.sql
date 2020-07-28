CREATE TABLE todo_table (
    "todoId" serial NOT NULL,
    content text NOT NULL,
    complete_date date NOT NULL,
    PRIMARY KEY ("todoId")
);

CREATE TABLE user_table (
    "userId" serial NOT NULL,
    username character varying(100) NOT NULL,
    PRIMARY KEY ("userId")
);

CREATE TABLE task_table (
    "todoId" integer NOT NULL,
    "userId" integer NOT NULL,
    complete boolean NOT NULL,
    PRIMARY KEY ("todoId", "userId")
);
