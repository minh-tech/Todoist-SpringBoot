# Todoist API

* Framework : Spring Boot
* Database  : PostgreSQL
* cUrl      : asset/Todoist_cUrl.sh
* jar       : target/todoist-0.0.2-SNAPSHOT.jar
* ERD       :

![Alt](https://github.com/minh-tech/todoist/blob/master/asset/Todolist_ERD.jpg "Title")

## Installations
1. Setup database via Docker
~~~~
# Install PostgreSQL via Docker
  $ sudo docker pull postgres:11
# Remove the container dev-todoist (skip the first time)
  $ sudo docker rm -f dev-todoist
# Create the container dev-todoist
  $ sudo docker run --name dev-todoist -p 5432:5432 -e POSTGRES_PASSWORD=111111 -d postgres:11
# CREATE db todoist
  $ sudo docker exec dev-todoist psql -U postgres -c"CREATE DATABASE todoist" postgres
~~~~
2. Run Application
~~~~
# Run .jar file:
$ java -jar target/todoist-0.0.2-SNAPSHOT.jar

# Grant permission and run asset/Todoist_cUrl.sh
$ chmod +x asset/Todoist_cUrl.sh
$ ./asset/Todoist_cUrl.sh 
~~~~

## HTTP API:
1. Get a list of todos
   * HTTP GET: http://localhost:8080/api/todo

2. Get a list of todos by conditions
   * HTTP GET: http://localhost:8080/api/todo?complete_date=2020-07-28&assignerId=1
   
3. Create a todo
   * HTTP POST: http://localhost:8080/api/todo

4. Edit a todo
   * HTTP PUT: http://localhost:8080/api/todo

5. Get a list of users
   * HTTP GET: http://localhost:8080/api/user

6. Add a new user
   * HTTP POST: http://localhost:8080/api/user

7. Assign multiple users into 1 todo
   * HTTP POST: http://localhost:8080/api/task

8. Get a list of the assignments
   * HTTP GET: http://localhost:8080/api/task

9. Assignee comments a todo
   * HTTP PATCH: http://localhost:8080/api/task

Thanks
