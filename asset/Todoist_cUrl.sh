# Get a list of todos
curl --location -w "\n" --request GET 'http://localhost:8080/api/todo'

# Create a todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/todo/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "content": "Do exercise 2",
    "complete_date": "2020-08-08"
}'

# Edit a todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/todo/edit' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todoId": 1,
    "content": "Do exercise 1",
    "complete_date": "2020-07-30"
}'

# Get a list of users
curl --location -w "\n" --request GET 'http://localhost:8080/api/user'

# Assign multiple users into 1 todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/task' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId_list": [
        1, 2, 3
    ],
    "todoId": 1
}'

# Get a list of the assignments
curl --location -w "\n" --request GET 'http://localhost:8080/api/task'

# Complete a todo
curl --location -w "\n" --request POST 'http://localhost:8080/api/task/done' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 1,
    "todoId": 1
}'

# Get a list of todos by date
curl --location -w "\n" --request GET 'http://localhost:8080/api/todo/2020-07-28'

# Add a new user
curl --location -w "\n" --request POST 'http://localhost:8080/api/user/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "Minh"
}'

