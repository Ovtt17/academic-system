# Academic System

**Academic System** is an application built with Spring Boot to manage the actions and tasks of a teacher, such as class creation, assignment distribution, and student and evaluation management.

## Table of Contents
- [Requirements](#requirements)
- [Initial Setup](#initial-setup)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [License](#license)

## Requirements

Before starting, make sure you have the following installed in your environment:
- **Java 17** or higher
- **Apache Maven** (3.6.3 or higher)
- **MySQL** or **PostgreSQL** for the database (configurable in the `application.properties` file)

## Initial Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Ovtt17/academic-system.git
   cd academic-system
    ```
   
2. **Configure the database:**

Create a database in MySQL and set up the access details in the src/main/resources/application.properties file.

### MySQL connection setup
```markdown
spring.datasource.url=jdbc:mysql://localhost:3306/academic_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Additional configurations
```markdown
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3. **Install Dependencies:**
   
Run the following command to install the application dependencies:

```bash
mvn clean install
```

4. **Configure Environment Variables (Optional):**

Set environment variables for sensitive information if you prefer not to store them in the application.properties file.
    
```bash
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

5. **Verify Configuration:**

Open application.properties and confirm that all configurations are correct, especially for database connectivity and server ports.

## Running the Application

1. **Start the database server (MySQL):**
2. **Run the application from the command line:**

```bash
mvn spring-boot:run
```

Alternatively, you can generate the jar file and run it as follows:

```bash
mvn clean package
java -jar target/academic-system-0.0.1-SNAPSHOT.jar
```

3. **Access the application:**

Once running, the application will be available at http://localhost:8080.

## Usage

The Academic System application offers several routes to manage teacher functions. These routes are JWT-protected and require prior authentication.

```markdown
Some main routes include:

/api/classes: Manage classes and schedules.
/api/assignments: Create and assign tasks.
/api/students: Manage enrolled students.
Note: Check the API documentation (Swagger UI, if configured) at http://localhost:8080/swagger-ui.html for full details on each route.
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.