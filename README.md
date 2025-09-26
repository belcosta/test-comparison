# Test Comparison Project

This project is a Spring Boot application designed to manage `BedSheet` entities. It includes RESTful APIs for creating, updating, deleting, and retrieving `BedSheet` records. The project also demonstrates the use of different testing approaches, including unit tests with JUnit and integration tests with Spring Test.

## Features

- **CRUD Operations**:
    - Create a new `BedSheet`
    - Update an existing `BedSheet`
    - Delete a `BedSheet`
    - Retrieve all `BedSheet` records
- **Testing**:
    - Unit tests using JUnit and Mockito
    - Integration tests using Spring Test and MockMvc

## Technologies Used

- **Languages**: Java
- **Frameworks**: Spring Boot
- **Database**: SQL (JPA/Hibernate)
- **Build Tool**: Gradle
- **Testing**: JUnit, Mockito, Spring Test
- **Other Libraries**: Lombok, Jackson

## Project Structure

- `src/main/java`: Contains the main application code.
    - `domain`: Contains the domain entities and DTOs.
    - `infrastructure/api`: Contains the REST controllers.
    - `infrastructure/service`: Contains the service layer.
- `src/test/java`: Contains the test cases.
    - `infrastructure/api`: Contains unit and integration tests for the controllers.

## Endpoints

### `BedSheetController`

| HTTP Method | Endpoint                  | Description                     |
|-------------|---------------------------|---------------------------------|
| POST        | `/bed-sheet/create`       | Create a new `BedSheet`.       |
| POST        | `/bed-sheet/update-{id}`  | Update an existing `BedSheet`. |
| DELETE      | `/bed-sheet/delete-{id}`  | Delete a `BedSheet`.           |
| GET         | `/bed-sheet/all`          | Retrieve all `BedSheet` records.|

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd test-comparison