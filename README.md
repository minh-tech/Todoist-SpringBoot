Todolist API

IDE: IntelliJ IDEA

Database: PostgreSQL

Management tool: Maven

ERD: asset/Todolist_ERD.jpg


1. Run asset/sample.sql on PostgreSQL server
2. Import asset/Todolist_API_collection.json into Postman
3. Import the project into IntelliJ IDEA
4. Reload pom.xml
5. Change database, username, and password in resources/application.yml
6. Run TodoistApplication and use Postman to test API

API:
- Get a list of todos
Request HTTP GET: http://localhost:8080/api/todo
Response: 200 OK + JSON

- Get a list of todos by date
Request HTTP GET: http://localhost:8080/api/todo/2020-07-28
Response: 400 Bad Request + Message: "Date is invalid."
          200 OK

- Create a todo
Request HTTP POST: http://localhost:8080/api/todo/add
Response: 200 OK

- Edit a todo
Request HTTP POST: http://localhost:8080/api/todo/edit
Response: 400 Bad Request + Message: "A todo Id is invalid."
          404 Not Found + Message: "A todo not found."
          200 OK

- Get a list of users
Request HTTP GET: http://localhost:8080/api/user
Response: 200 OK + JSON

- Add a new user
Request HTTP POST: http://localhost:8080/api/user/add
Response: 200 OK

- Assign multiple users into 1 todo
Request HTTP POST: http://localhost:8080/api/task
Response: 400 Bad Request + Message: "A todo Id is invalid."
          404 Not Found + Message: "A todo not found."
          400 Bad Request + Message: "One of user Ids is invalid."
          404 Not Found + Message: "One of users not found."
          400 Bad Request + Message: "Json format is incorrect."
          400 Bad Request + Message: "Assignments are duplicated."

- Get a list of the assignments
Request HTTP GET: http://localhost:8080/api/task
Response: 200 OK + JSON

- Complete a todo
Request HTTP POST: http://localhost:8080/api/task/done
Response: 400 Bad Request + Message: "Json format is incorrect."
          400 Bad Request + Message: "A user Id is invalid."
          404 Not Found + Message: "A user not found."
          400 Bad Request + Message: "A todo Id is invalid."
          404 Not Found + Message: "A todo not found."
          404 Not Found + Message: "Cannot found the assignment."
          200 OK

Thanks
