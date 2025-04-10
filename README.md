# Work Calendars

A work calendar application for each country for a multinational company. A RESTful Web API is implemented in Spring Boot using the Onion architecture.

## Project Structure

### Folders

The project is divided into several layers, each responsible for a specific set of functionalities. The main layers are:

- **`api`**: Presentation layer that exposes services via a RESTful API.
- **`application`**: Application logic layer that handles business logic.
- **`domain`**: Domain layer containing entities and domain logic.
- **`infrastructure`**: Infrastructure layer that handles database interaction and external services.

## Architecture

The project follows the principles of hexagonal architecture, which allows for a clear separation of concerns and easier code maintenance. Each layer interacts with the next layer according to its responsibility, minimizing coupling between them.

## Dependencies

- **Spring Boot**: Framework for building Spring-based applications.
- **Lombok**: Library that helps reduce boilerplate code (e.g., getters, setters, constructors).
- **PostgreSQL**: Relational database used for persistence.
- **Spring Data JPA**: Provides functionality to interact with the database using JPA (Java Persistence API).

## Project Configuration

### Prerequisites

Ensure you have the following programs installed:

- [Java 17](https://openjdk.java.net/projects/jdk/17/) or higher.
- [Maven](https://maven.apache.org/) to build the project.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your_username/work-calendars.git
    ```

2. Navigate to the project directory:

    ```bash
    cd work-calendars
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the project:

    ```bash
    mvn spring-boot:run
    ```

### Database Configuration

The project uses PostgreSQL. Ensure that you have a running instance of PostgreSQL and create a database for the project.

Configure the database credentials in the `application.properties` file located in `src/main/resources`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

