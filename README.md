# SOAP TP - Spring Boot Application for Managing Bank Accounts

This project is a **Spring Boot application** that provides SOAP web services to manage bank accounts. It allows for CRUD operations (Create, Read, Update, Delete) on the `Compte` entity, which represents a bank account. The application is designed to expose these operations via a SOAP API, making it easy to integrate with other systems.

## Features

- **Fetch All Accounts**: Retrieve a list of all bank accounts.
- **Fetch Account by ID**: Retrieve a specific bank account by its unique identifier.
- **Create Account**: Create a new bank account with initial values.
- **Update Account**: Update an existing bank account's details.
- **Delete Account**: Delete a specific bank account by its ID.

## Project Structure

The project follows a typical Spring Boot application structure. Below is the directory and file breakdown:

```
src/
├── main/
│   ├── java/
│   │   └── org/
│   │       └── marouanedbibih/
│   │           └── soap_p/
│   │               ├── compte/
│   │               │   ├── Compte.java             
│   │               │   ├── CompteRepository.java    
│   │               │   ├── CompteServiceSOAP.java   
│   │               │   └── TypeCompte.java          
│   │               ├── config/
│   │               │   ├── CxfConfig.java           
│   │               │   └── DatabaseInit.java        
│   │               └── SoapTpApplication.java       #
│   └── resources/
│       ├── application.properties  
│       ├── static                 
│       └── templates              
└── test/
    └── java/
        └── org/
            └── marouanedbibih/
                └── soap_p/
                    └── SoapTpApplicationTests.java  ation

```

## Requirements

- **Java 17 or higher**.
- **Maven** for building the application.
- **Spring Boot**.
- **CXF** for SOAP services.
- **H2 Database** (or any preferred database) to store bank account data.

## Installation

1. **Clone the repository**:
    
    ```bash
    git clone https://github.com/marouanedbibih/soap-tp.git
    cd soap-tp
    
    ```
    
2. **Configure your database**:
    - Update the `application.properties` file with your database details (e.g., MySQL connection settings).
3. **Build the project**:
    
    If you have Maven installed, run the following command to build the project:
    
    ```bash
    mvn clean install
    
    ```
    
4. **Run the application**:
    
    Start the Spring Boot application:
    
    ```bash
    mvn spring-boot:run
    
    ```
    
    This will start the application on the default port (`8080`).
    

## API Endpoints

The SOAP web service exposes the following operations for managing bank accounts:

### 1. **Fetch All Accounts**

- **Endpoint**: `/ws`
- **SOAP Action**: `fetchAllComptes`
- **Response**: A list of all bank accounts with their details.

### 2. **Fetch Account by ID**

- **Endpoint**: `/ws`
- **SOAP Action**: `fetchCompteById`
- **Request**: `compteId` (Long) - The unique ID of the account.
- **Response**: A single bank account with the specified ID.

### 3. **Create Account**

- **Endpoint**: `/ws`
- **SOAP Action**: `createCompte`
- **Request**: A `Compte` object with the details of the account (amount, created date, and type).
- **Response**: Confirmation of the created account with its ID.

### 4. **Update Account**

- **Endpoint**: `/ws`
- **SOAP Action**: `updateCompte`
- **Request**: A `Compte` object with the updated details (account ID must be included).
- **Response**: Confirmation of the updated account.

### 5. **Delete Account**

- **Endpoint**: `/ws`
- **SOAP Action**: `deleteCompte`
- **Request**: `compteId` (Long) - The ID of the account to delete.
- **Response**: Confirmation of the account deletion.

## Configuration

The configuration files are located in `src/main/resources/`:

- **`application.properties`**: Contains database and Spring Boot-specific configurations.
- **CXF SOAP Configuration**: Handled in `CxfConfig.java`, where the SOAP endpoints are set up.

## Testing

Unit tests for the application are located in the `src/test/java` directory. The tests cover the main functionalities of the application and ensure the SOAP services work as expected.

To run the tests, you can use Maven:

```bash
mvn test

```

## Database Initialization

The `DatabaseInit.java` class is used to populate the database with sample data upon startup. It initializes the database with a few example bank accounts.

### Example Data Inserted:

- Account ID: `1`, Amount: `1000.0`, Type: `SAVINGS`
- Account ID: `2`, Amount: `5000.0`, Type: `CHECKING`

## Conclusion

This project demonstrates how to expose CRUD operations for managing bank accounts via a SOAP web service in a Spring Boot application. It is a basic implementation and can be extended with additional features, security, and error handling as needed.

## License

This project is licensed under the MIT License - see the [LICENSE](https://www.notion.so/LICENSE) file for details.

---

This README provides a clear, professional overview of your SOAP-based Spring Boot application, including installation instructions, features, API usage, and project structure.