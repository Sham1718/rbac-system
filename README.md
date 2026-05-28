# Role-Based Access Control (RBAC) System

## Brief One-Line Summary
A backend-focused Spring Boot RBAC system implementing JWT authentication, role-based authorization, and permission-level access control using Spring Security.

---

# Overview

The Role-Based Access Control (RBAC) System is a secure backend application developed using Spring Boot and Spring Security to demonstrate real-world authentication and authorization architecture.

This project focuses on:
- JWT-based authentication
- Role-based authorization
- Permission-level access control
- Secure API protection
- Clean backend architecture

The system allows users to:
- Register and login securely
- Access protected APIs using JWT tokens
- Restrict endpoints based on user roles and permissions
- Manage roles and permissions through admin APIs

The project follows backend-first development practices with layered architecture and security-focused implementation.

---

# Problem Statement

Modern applications require secure access management to:
- Prevent unauthorized access
- Protect sensitive endpoints
- Control user permissions
- Manage scalable authentication systems

This project solves these challenges by implementing:
- JWT-based stateless authentication
- Role and permission management
- Secure password encryption
- Protected API routes

using Spring Security and backend security best practices.

---

# Tools and Tech

## Backend
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Hibernate / JPA
- MySQL

## Build Tool
- Maven

## Security
- BCrypt Password Encryption
- JWT Authentication
- Role-Based Authorization

---

# Methods

## Authentication System

1. User registers using email and password
2. User logs in with credentials
3. Server generates JWT token
4. Client sends token in Authorization header
5. Token is validated on every request
6. Access is granted based on roles and permissions

---

## Authorization System

### Roles
- Admin
- User

### Permission-Based Access
- Role-specific endpoint access
- Permission validation using Spring Security
- Protected admin routes

---

## Security Implementation

- Password encryption using BCrypt
- Stateless authentication using JWT
- Filter-level request validation
- Unauthorized request blocking
- Secure protected APIs

---

## Backend Architecture

- Layered architecture implementation
- DTO-based request handling
- Repository pattern usage
- Global exception handling
- Clean separation of concerns

---

# Key Insights

- Learned implementation of JWT authentication
- Improved understanding of Spring Security
- Practiced secure backend API development
- Learned role-based authorization concepts
- Improved backend architecture design skills
- Understood stateless authentication flow
- Practiced secure password encryption using BCrypt

---

# How to Run Project

## Clone Repository

```bash
git clone https://github.com/Sham1718/rbac-system
```

---

## Navigate to Project

```bash
cd rbac-system
```

---

## Configure Database

Update database credentials inside:

```properties
application.properties
```

### Database Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rbac_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

---

## Default Server

```bash
http://localhost:8080
```

---

# API Endpoints

## Authentication APIs

```http
POST /api/auth/register
POST /api/auth/login
```

---

## User APIs

```http
GET /api/users/me
```

---

## Admin APIs (Protected)

```http
GET  /api/admin/users
POST /api/admin/roles
POST /api/admin/permissions
```

---

# Author and Contact

## Author
Shyam Bharaskar

## Contact
- GitHub: https://github.com/Sham1718
- Portfolio: https://shyam-neon.vercel.app/

---

⭐ If you found this project useful, consider giving it a star.
