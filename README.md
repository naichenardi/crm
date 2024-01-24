# CRM Application

This is a Customer Relationship Management (CRM) application built using Java and Spring Boot. The application is designed to manage and analyze customer interactions and data throughout the customer lifecycle.

## Technologies Used

- Java 21
- Spring Boot 3.1.4
- Gradle
- Docker
- MySQL
- Kafka
- Zookeeper
- PostgreSQL
- Conduktor

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 21
- Docker
- Gradle

### Installation

1. Clone the repository
```bash
git clone https://github.com/naichenardi/crm.git
```
2. Navigate to the project directory
```bash
cd crm
```
3. Build the project using Gradle
```bash
./gradlew build
```
4. Start the services using Docker Compose
```bash
docker-compose up
```
The application should now be running at `localhost:8080`.

## Usage

Detailed usage instructions will be provided here.

## Running the tests

To run the tests, use the following command:

```bash
./gradlew test
```

## Contributing

Please read `CONTRIBUTING.md` for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the `LICENSE.md` file for details.

## Acknowledgments

- Thanks to the Spring Boot team for their great framework.
- Thanks to Confluent for their Kafka and Zookeeper images.
- Thanks to PostgreSQL and MySQL for their database systems.
- Thanks to Conduktor for their platform.