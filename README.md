# Java Application with REST API for Customer Management

## Introduction

In this project, we have developed a Java application that provides a REST API for performing operations such as customer registration, modification, deletion, and retrieval. The application follows best development practices, adhering to REST architectural standards to ensure efficiency, scalability, and ease of integration.

## Technologies Used

- **Java:** The primary programming language, known for its portability and robustness.
- **Spring Boot:** A framework that facilitates the creation of Java applications, offering minimal configuration and increased productivity.
- **Spring Data JPA:** Streamlines interaction with the database, providing an abstraction layer for data persistence.
- **Hibernate:** An ORM (Object-Relational Mapping) framework used to map Java objects to the relational database.
- **RESTful API:** Implementation of a RESTful web services architecture for communication between systems.

## Features

### 1. Customer Registration

The API allows for easy and quick registration of new customers. Data is sent through HTTP requests using the POST method and is validated to ensure the integrity of the stored data.

Example request to register a customer:

```http
POST /api/customers
Content-Type: application/json

{
  "name": "Brunno silva",
  "email": "brunno.silva@email.com",
  "phone": "+55 11 1234-5678"
}
```

### 2. Customer Modification

The application allows for the update of information for previously registered customers. Requests are made using the PUT method, ensuring complete or partial data updates as needed.

Example request to change a customer's email:

```http
PUT /api/customers/{id}
Content-Type: application/json

{
  "email": "brunno.new@email.com"
}
```

### 3. Customer Retrieval

The API provides endpoints for customer retrieval, allowing for the retrieval of specific information or a complete list. Requests can be made using the GET methods.

Example request to retrieve a customer by ID:

```http
GET /api/customers/{id}
```

### 4. Customer Deletion

To remove a customer from the system, the application provides an endpoint using the DELETE method.

Example request to delete a customer by ID:

```http
DELETE /api/customers/{id}
```