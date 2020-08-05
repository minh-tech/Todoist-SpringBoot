# Get a list of todos
curl --location -w "\n" --request GET 'http://localhost:8080/api/todo'

# Get a list of todos by date and user Id
curl --location -w "\n" --request GET 'http://localhost:8080/api/todo?complete_date=2020-07-28&assignerId=1'

# Create a todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/todo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "content": "Do exercise 2",
    "complete_date": "2020-09-09",
    "assignerId": 3,
    "status": "open"
}'

# Edit a todo
curl --location -w "\n" --request PUT 'http://localhost:8080/api/todo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todoId": 6,
    "content": "Read a handbook",
    "complete_date": "2020-09-05",
    "status": "open"
}'

# Assigner changes status of a todo
curl --location -w "\n" --request PUT 'http://localhost:8080/api/todo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todoId": 4,
    "assignerId": 2,
    "status": "done"
}'

# Get a list of users
curl --location -w "\n" --request GET 'http://localhost:8080/api/user'

# Assign multiple users into 1 todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/task' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todoId": 5,
    "assigneeIds": [
        4, 5
    ]
}'

# Get a list of the assignments
curl --location -w "\n" --request GET 'http://localhost:8080/api/task'

# Assignee comments a todo
curl --location --request PATCH 'http://localhost:8080/api/task' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todoId": 4,
    "assigneeId": 4,
    "comment": "Still Planning"
}'

# Add a new user
curl --location -w "\n" --request POST 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "Minh5"
}'

