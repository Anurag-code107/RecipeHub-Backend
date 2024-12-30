# **Recipe Hub - Backend**

## **Overview**

Recipe Hub is a full-stack web application for food enthusiasts to explore, share, and manage recipes. Users can create, update, delete, and like recipes, fostering a community-driven experience.This repository contains the backend for the application, which is built using **Spring Boot 3** and connected to a **MySQL** database.

For the frontend, check out the [Recipe Hub Frontend repository](https://github.com/Anurag-code107/RecipeHub-Frontend).

---

## **Technologies Used**

- **Spring Boot 3**: Backend framework
- **Spring Data JPA (Hibernate)**: ORM for MySQL interaction
- **MySQL**: Database for storing recipes and user data
- **JWT Authentication**: Planned for secure access
- **Maven**: For building and managing the project dependencies

---

## **Features**

- **Recipe Management**: Users can create, update, delete, and list recipes.
- **Like Functinality**: Users can like the recipes they like.
- **Multipe Users**: Multiple users can register and use this application.
- **Database Integration**: MySQL database stores all recipe data and user data.
- **Basic Security**: Authentication and authorization using Spring Security and JWT tokens.

---

## **Live Demo**

You can try the live version of the Recipe Hub through the link below:
[Live Demo](https://recipehub-cwd.pages.dev/)

The project is deployed on Railway (backend) and Cloudflare pages (frontend), leveraging free-tier services for scalability and cost efficiency.
Note that authentication will be required to fully interact with the application.

---

## **Installation Guide**

### **Pre-requisites**

To run the backend locally, ensure you have the following tools installed:

- **JDK 17+** - Required to run the Spring Boot application
- **Maven** - For building and managing the project
- **MySQL** - For the database

### **Clone the Repository**

Clone the repository to your local machine:

```bash
git clone https://github.com/Anurag-code107/RecipeHub-Backend.git
cd RecipeHub-Backend
```

### **Database Setup**

1. **Create the MySQL Database:**
   - Create a database in MySQL (e.g., `recipehub_db`).

2. **Configure the Database:**
   - Update the `application-dev.yml` file in `src/main/resources` with your MySQL connection details:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/recipehub_db
    username: your-db-username
    password: your-db-password
```

---

## **Running the Application**

### **Build the Project**

To compile the application and resolve dependencies, run the following command:

```bash
mvn clean install
```

### **Run the Application**

Start the Spring Boot application by running:

```bash
mvn spring-boot:run
```

The backend will be accessible at:  
`http://localhost:8282/api`

---

## **API Endpoints**

### **1. Get All Recipes**
- **Method**: `GET`  
- **Endpoint**: `/api/recipes`  
- **Description**: Retrieves a list of all recipes.

---

### **2. Create a New Recipe**
- **Method**: `POST`  
- **Endpoint**: `/api/recipes`  
- **Request Body**:

```json
{
  "title": "Recipe Title",
  "image": "Image URL",
  "description": "Recipe Description",
  "category": "Vegetarian or Non Vegetarian",
  "ingredients": ["Ingredient 1", "Ingredient 2", "Ingredient 3"],
  "instructions": "Step-by-step cooking instructions",
}
```

- **Description**: Creates a new recipe in the database.

---

### **3. Update an Existing Recipe**
- **Method**: `PUT`  
- **Endpoint**: `/api/recipes/{id}`  
- **Description**: Updates the details of a recipe with the specified `id`.

---

### **4. Delete a Recipe**
- **Method**: `DELETE`  
- **Endpoint**: `/api/recipes/{id}`  
- **Description**: Deletes the recipe with the specified `id`.

---

### **4. Like a Recipe**
- **Method**: `PUT`  
- **Endpoint**: `/api/recipes/{id}/like`  
- **Description**: Like the recipe with user's id `userId`.

---

## **Authentication (Planned)**

- **JWT Authentication**: The application uses **JSON Web Tokens (JWT)** for securing endpoints. JWTs are issued after successful user login and are required for accessing protected routes. 
- **Spring Security**: Spring Security is integrated to provide authentication and basic security for the application, ensuring that only authenticated users can perform certain actions (e.g., creating, updating, or deleting recipes).

--- 

## **Error Handling**

- **400**: Bad Request  
- **404**: Resource Not Found  
- **500**: Internal Server Error  

---

## **Contributing**

We welcome contributions to this project! Please fork the repository and submit a pull request with your changes.

---

## **License**

This project is licensed under the [**Apache License 2.0**](LICENSE).

---

## **Support**

If you encounter any issues or have any questions, feel free to open an issue in the [GitHub repository issues page](https://github.com/Anurag-code107/RecipeHub-Backend/issues) or contact us directly at [anuragnegi2704@gmail.com](mailto:anuragnegi2704@gmail.com).

---

