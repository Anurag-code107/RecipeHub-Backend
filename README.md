# Recipe Hub - Backend

Overview

Recipe Hub is a platform for managing and sharing recipes, where users can search for, view, and manage recipes. This repository contains the backend for the application, which is built using Spring Boot 3 and connected to a MySQL database.
Technologies Used

    Spring Boot 3: Backend framework
    Spring Data JPA (Hibernate): ORM for MySQL interaction
    MySQL: Database for storing recipes and user data
    JWT Authentication: Planned for secure access
    Maven: For building and managing the project dependencies

Features

    Recipe Management: Users can create, update, delete, and list recipes.
    Search Functionality: Recipes can be searched based on titles or descriptions.
    Database Integration: MySQL database stores all recipe data.
    Basic Security: Authentication and authorization using Spring Security and JWT tokens (to be implemented).

Installation Guide
Pre-requisites

To run the backend locally, ensure you have the following tools installed:

    JDK 17+ - Required to run the Spring Boot application
    Maven - For building and managing the project
    MySQL - For the database

Clone the Repository

Clone the repository to your local machine:

git clone https://github.com/your-username/recipe-hub-backend.git
cd recipe-hub-backend

Database Setup

    Create the MySQL Database:
        Create a database in MySQL (e.g., recipehub_db).

    Configure the Database:
        Update the application-dev.yml file in src/main/resources with your MySQL connection details:

        spring:
          datasource:
            url: jdbc:mysql://localhost:3306/recipehub_db
            username: your-db-username
            password: your-db-password

Running the Application
Build the Project

To compile the application and resolve dependencies, run the following command:

mvn clean install

Run the Application

Start the Spring Boot application by running:

mvn spring-boot:run

The backend will be accessible at http://localhost:8282/api.
API Endpoints

1.  Get All Recipes

    GET /api/recipes
    Retrieves a list of all recipes.

2.  Search Recipes

    GET /api/recipes/search?query={query}
    Searches recipes by title or description based on the provided query.

3.  Create a New Recipe

    POST /api/recipes
    Request Body:

        {
          "title": "Recipe Title",
          "description": "Recipe Description",
          "vegetarian": true
        }

        Creates a new recipe in the database.

4.  Update an Existing Recipe

    PUT /api/recipes/{id}
    Updates the details of a recipe with the specified id.

5.  Delete a Recipe

    DELETE /api/recipes/{id}
    Deletes the recipe with the specified id.

Authentication (Planned)

    JWT Authentication: A JSON Web Token (JWT) authentication mechanism will be used for securing endpoints.
    Roles and Permissions: Role-based access control (RBAC) for user-specific actions (e.g., only admins can delete recipes).

Error Handling

    400: Bad Request
    404: Resource Not Found
    500: Internal Server Error

Contributing

We welcome contributions to this project! Please fork the repository and submit a pull request with your changes.

License

This project is licensed under the MIT License.
Support

If you encounter any issues or have any questions, feel free to open an issue in the GitHub repository or contact us directly.
