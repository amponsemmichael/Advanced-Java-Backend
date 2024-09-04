
```markdown
# Hospital System - NoSQL Integration with Redis and MongoDB

## Project Overview

This project involves integrating Redis and MongoDB into a Hospital System using Spring Boot. The primary objectives are to explore NoSQL databases' capabilities, perform CRUD operations, and utilize Spring Data for seamless database interactions.

## Project Objectives

- **Understand NoSQL Databases:** Gain a fundamental understanding of the differences between relational and NoSQL databases.
- **Redis Integration:** Set up a Redis connection and perform basic operations like setting and retrieving data, working with hashes, and managing lists.
- **MongoDB Integration:** Transition from relational databases to MongoDB, setting up a connection, creating collections, and performing CRUD operations.
- **Spring Data:** Utilize Spring Data Redis and Spring Data MongoDB for repository-based database access.
- **Querying NoSQL Databases:** Execute basic and advanced queries on both Redis and MongoDB to retrieve and manipulate data.

## Technologies Used

- **Spring Boot:** The primary framework for building the application.
- **Redis:** An in-memory data structure store used for caching and real-time data processing.
- **MongoDB:** A document-oriented NoSQL database used for storing and retrieving hospital data.
- **Spring Data Redis:** Simplifies the integration with Redis by providing repository support.
- **Spring Data MongoDB:** Provides a familiar and consistent way to interact with MongoDB.

## Lab Exercises

### 1. Redis Integration
- Set up a Redis connection.
- Perform basic Redis operations: 
  - **SET:** Store data.
  - **GET:** Retrieve data.
  - **HASH:** Store and retrieve data in hash format.
  - **LIST:** Work with lists.

### 2. Spring Data Redis
- Use Spring Data Redis for repository-based access to Redis.
- Implement CRUD operations using Redis repositories.

### 3. MongoDB Integration
- Set up a MongoDB connection.
- Create and manage MongoDB collections.
- Perform CRUD operations on MongoDB documents.

### 4. Spring Data MongoDB
- Use Spring Data MongoDB for repository-based access.
- Implement CRUD operations using MongoDB repositories.

### 5. Querying NoSQL Databases
- Execute basic queries on Redis and MongoDB.
- Perform advanced queries, such as filtering, sorting, and aggregation.

## Deliverables

- **Spring Boot Applications:** 
  - Redis integration with Spring Data Redis.
  - MongoDB integration with Spring Data MongoDB.
- **CRUD Operations:** Implementations for both Redis and MongoDB.
- **Comparison Document:** A PDF comparing relational and NoSQL data modeling.
- **Summary Document:** A PDF summarizing Spring Data for NoSQL databases.

## Installation and Setup

### Prerequisites
- Java 17+
- Spring Boot 3.x
- Redis Server
- MongoDB Server
- Maven 3.x

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/hospital-system-nosql.git
   ```
2. Navigate to the project directory:
   ```bash
   cd hospital-system-nosql
   ```
3. Set up Redis and MongoDB servers on your local machine.
4. Configure application properties for Redis and MongoDB connections in `application.properties` or `application.yml`.
5. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Usage

- **Redis Operations:** Use the provided REST endpoints to perform basic Redis operations like setting and getting values, managing hashes, and working with lists.
- **MongoDB Operations:** Use the REST endpoints to perform CRUD operations on hospital-related data, such as patients, doctors, and departments.

## Contribution Guidelines

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add some feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-branch-name
   ```
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please contact [amponsem_michael@yahoo.com).

```
