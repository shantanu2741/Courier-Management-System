# Courier Management System (Currently in development)

## Project Overview
The **Courier Management System** is a web-based application designed to handle courier orders, manage their statuses, and provide role-based access control. This project currently allows users to add, update, and delete courier orders. Role-based authentication and authorization are implemented for admin and user roles to ensure secure access control.

## Features Implemented
- **Courier Management**:
  - Add, update, and delete courier orders.
  - Manage courier statuses.
  
- **Role-Based Authentication and Authorization**:
  - Admin and User roles with specific privileges.
  - Admins can manage courier orders and statuses.
  - Users can view their own orders.

## Technologies Used
- **Java**: Core programming language used for the application.
- **Spring Boot**: Framework to simplify the development of web applications.
- **Spring Security**: For handling authentication and authorization based on user roles.
- **Thymeleaf**: Template engine for rendering dynamic HTML pages.
- **Spring Data JPA**: For data persistence and interaction with the MySQL database.
- **MySQL**: Relational database for storing courier, user, and role data.

