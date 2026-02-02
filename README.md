# Role-Based Access Control (RBAC) System

A backend-focused Role-Based Access Control (RBAC) system built using Spring Boot and JWT authentication. This project demonstrates secure user authentication, authorization, and role-permission management following real-world backend standards.

---

## Features

- JWT-based authentication
- Role-based authorization (Admin, User)
- Permission-level access control
- Secure login and registration APIs
- Protected routes using Spring Security
- Password encryption with BCrypt
- Global exception handling
- Clean layered architecture
- Backend-first implementation

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Hibernate / JPA
- MySQL (configurable)
- Maven

---

## Project Structure

src/main/java/com/example/rbac  
controller – REST controllers  
service – Business logic  
repository – Database access layer  
model – User, Role, Permission entities  
security – JWT and Spring Security configuration  
dto – Request and response DTOs  
exception – Global exception handling  
config – Application configuration  

---

## Authentication Flow

1. User registers with email and password
2. User logs in using credentials
3. Server generates a JWT token
4. Client sends token in Authorization header
5. Token is validated for every request
6. Access is granted based on role and permissions

---

## API Endpoints (Sample)

Auth  
POST /api/auth/register – Register a new user  
POST /api/auth/login – Login and receive JWT  

User  
GET /api/users/me – Get logged-in user details  

Admin (Protected)  
GET /api/admin/users – Get all users  
POST /api/admin/roles – Create roles  
POST /api/admin/permissions – Assign permissions  

---

## Security Highlights

- Passwords encrypted using BCrypt
- Stateless authentication using JWT
- Role and permission checks enforced by Spring Security
- Unauthorized access blocked at filter level

---

## Configuration

Update database credentials in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/rbac_db  
spring.datasource.username=root  
spring.datasource.password=your_password  

---

## How to Run

1. Clone repository  
git clone https://github.com/your-username/rbac-system.git  

2. Navigate to project  
cd rbac-system  

3. Run application  
mvn spring-boot:run  

4. Server runs at  
http://localhost:8080  

---

## Learning Outcomes

- Implemented real-world RBAC system
- Hands-on experience with Spring Security
- JWT authentication and authorization
- Backend architecture best practices
- Improved API security understanding

---

## Future Improvements

- Refresh token support
- Admin dashboard UI
- Rate limiting
- Audit logs
- Docker deployment

---

## Author

Shyam  
Backend / Full Stack Developer  

---

If you found this project useful, give it a star ⭐
