<div align="center">

# Banking System Web Application

### Full-Stack Banking Management System using Spring Boot, Thymeleaf & MySQL

## 🌐 Live Demo
👉 Try the application here:  
https://banking-system-q5pp.onrender.com/login

</div>

---

## Project Overview

The Banking System Web Application is a full-stack web application developed using **Spring Boot**, **Thymeleaf**, and **MySQL**.

The application allows users to securely perform banking operations such as:

- User Registration & Login
- Deposit Money
- Withdraw Money
- Transfer Funds
- View Transaction History

The project follows the **MVC Architecture** and demonstrates frontend-backend integration, database connectivity, session handling, and transaction management.

---

# Features

## Authentication Module
- User Signup
- User Login
- Session-based Authentication
- Logout Functionality

## Banking Operations
- Deposit Money
- Withdraw Money
- Transfer Money Between Accounts
- Real-time Balance Updates

## Transaction Management
- Transaction History Tracking
- Transaction Status Recording
- Timestamp for Every Transaction

## Admin Features
- View All Registered Users
- View All Transactions
- Monitor Banking Activities

## User Interface
- Responsive UI Design
- Modern Dashboard
- Beautiful Forms & Navigation
- Clean User Experience

---

# Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Backend Development |
| Spring Boot | Application Framework |
| Spring MVC | Web Architecture |
| Thymeleaf | Template Engine |
| MySQL | Database |
| HTML5 | Structure |
| CSS3 | Styling |
| Git | Version Control |
| GitHub | Project Hosting |

---

# Project Structure

```bash
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ bankingsystem
 ┃ ┃ ┣ controller
 ┃ ┃ ┣ entity
 ┃ ┃ ┣ repository
 ┃ ┃ ┣ service
 ┃ ┃ ┗ BankingsystemApplication.java
 ┃ ┗ resources
 ┃ ┃ ┣ templates
 ┃ ┃ ┣ static
 ┃ ┃ ┗ application.properties
```

---

# Setup Instructions

## Clone Repository

```bash
git clone https://github.com/Yogithaturala/banking-system.git
```

---

## Open Project

Open the project in:
- IntelliJ IDEA

---

## Configure MySQL

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run Application

Run:

```bash
BankingsystemApplication.java
```

OR

```bash
mvn spring-boot:run
```

---

## 📍 Application URLs

| Page | URL |
|------|-----|
| Login | https://banking-system-q5pp.onrender.com/login |
| Dashboard | https://banking-system-q5pp.onrender.com/dashboard |
| Transfer | https://banking-system-q5pp.onrender.com/transfer |
| History | https://banking-system-q5pp.onrender.com/history |
| Admin | https://banking-system-q5pp.onrender.com/admin |

---

# Screenshots

## Login Page

![Login Page](https://github.com/user-attachments/assets/35f551e7-70a7-4be8-8a39-dc27f7024c0a)

---

## Dashboard

![Dashboard](https://github.com/user-attachments/assets/0ff2d10a-3835-4501-bd00-164bd59f0f49)

![Dashboard Features](https://github.com/user-attachments/assets/d7180675-a897-41dd-8246-1fd149dcc033)

---

## Transfer Money

![Transfer Money](https://github.com/user-attachments/assets/728d167f-ad9c-44d8-9666-2bbad95a9068)

---

## Transaction History

![Transaction History](https://github.com/user-attachments/assets/c4a6182a-8806-4992-b2e1-98b2453c8c2a)
---

# Future Enhancements

- Password Encryption using Spring Security
- OTP Verification
- Email Notifications
- Account Statement PDF Download
- Role-Based Authentication
- Online Deployment
- REST API Integration

---

# Learning Outcomes

Through this project, I learned:

- Full-stack web development using Spring Boot
- MVC Architecture
- Database Integration with MySQL
- Session Handling
- CRUD Operations
- Git & GitHub Workflow
- Frontend-Backend Integration

---

# Author

## Yogitha Turala

B.Tech Student | Java Developer | Aspiring Entrepreneur

🔗 GitHub:  
https://github.com/Yogithaturala

---

<div align="center">

### If you found this project useful, consider giving it a star on GitHub!

</div>
