# Student CRUD Operations with Spring Boot and MongoDB

This project is a simple CRUD (Create, Read, Update, Delete) application using **Spring Boot** and **MongoDB**. The application manages student records and supports basic CRUD operations through a RESTful API.

## Features

- Add new students with unique `email` and `studentId`
- Retrieve all student records
- Get student details by `id`
- Update student information
- Delete a student record
- Proper exception handling with custom `StudentNotFoundException`
- Clear API responses using `ApiResponse`

## Technologies Used

- **Spring Boot**
- **MongoDB**
- **Lombok**
- **Java 17**
- **RESTful API**

## Project Structure

```
src/main/java/com/crud/crudoperation
├── controller
│   └── StudentController.java
├── entity
│   └── Student.java
├── exception
│   └── StudentNotFoundException.java
├── repository
│   └── StudentRepository.java
├── response
│   └── ApiResponse.java
├── service
│   └── StudentService.java
├── service/impl
│   └── StudentServiceImpl.java
├── CrudoperationApplication.java
```

## Endpoints

| HTTP Method | Endpoint          | Description          |
|------------ |------------------ |--------------------- |
| POST        | /v1/student/create | Create a new student |
| GET         | /v1/student/all    | Get all students     |
| GET         | /v1/student/{id}   | Get student by ID    |
| PUT         | /v1/student/update/{id} | Update student by ID |
| DELETE      | /v1/student/delete/{id} | Delete student by ID |

## Setup Instructions

### 1. Clone the repository

```bash
git clone <repository-url>
cd crudoperation
```

### 2. Configure MongoDB

Ensure MongoDB is running locally. The default configuration is in `application.properties`:

```properties
spring.data.mongodb.database=crud
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
```

### 3. Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```

The app will be running at: `http://localhost:8080`

## Manual Git Push Steps

If you want to manually push your project to GitHub, follow these steps:

### 1. Initialize a Git repository

```bash
git init
```

### 2. Add all files

```bash
git add .
```

### 3. Commit the changes

```bash
git commit -m "Initial commit"
```

### 4. Add remote repository

```bash
git remote add origin <your-repo-url>
```

### 5. Push to GitHub

```bash
git push -u origin main
```

> If the default branch is not `main`, use `git push -u origin master`.

## Conclusion

You now have a fully functional CRUD application using Spring Boot and MongoDB. Feel free to customize and extend the project. If you have any suggestions or improvements, please open an issue or a pull request.

---

Made with ❤️ by [subburathinam M]

