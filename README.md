# 🎓 Student–Course Microservices System

### Spring Boot | Spring Cloud | JPA | MySQL | Distributed Architecture

![Java](https://img.shields.io/badge/Java-17%2F21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.x-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Architecture](https://img.shields.io/badge/Architecture-Microservices-red)
![Build](https://img.shields.io/badge/Build-Maven-yellow)

---

## 📌 Project Overview

This project is a **distributed microservices-based backend system** built using **Spring Boot and Spring Cloud**.

It manages:

* 👨‍🎓 Students
* 📚 Courses
* 🔗 Enrollments

The system demonstrates real-world microservice architecture including:

* Service Discovery
* API Gateway Routing
* Database per Service pattern
* Centralized Monitoring
* Layered Architecture
* Inter-service communication

This project reflects **production-style backend architecture design**.

---

# 🏗 System Architecture

```
Client
   │
   ▼
API Gateway (3333)
   │
   ▼
Eureka Server (8761)
   │
   ├── Student Service
   ├── Course Service
   └── Enrollment Service
          │
          ▼
     MySQL Databases
          
Admin Server (Monitoring All Services)
```

---

# 🧩 Microservices Breakdown

## 1️⃣ Service Registry – `student-course-service-registry`

* Eureka Server
* Handles service discovery
* All services register here
* Port: **8761**

Dashboard:

```
http://localhost:8761
```

---

## 2️⃣ API Gateway – `student-course-api-gateway`

* Single entry point for client requests
* Routes requests using `lb://service-name`
* Integrated with Eureka
* Port: **3333**

Example:

```
http://localhost:3333/student/1
```

---

## 3️⃣ Student Service – `student-service`

* CRUD operations for Students
* JPA + Hibernate
* MySQL database
* Registered with Eureka
* Layered Architecture

---

## 4️⃣ Course Service – `course-service`

* CRUD operations for Courses
* JPA + Hibernate
* MySQL database
* Registered with Eureka

---

## 5️⃣ Enrollment Service – `enrollment-service`

* Manages relationship between Students and Courses
* Handles enrollment logic
* Own database
* Demonstrates microservice responsibility separation

---

## 6️⃣ Admin Server – `student-course-admin-server`

* Spring Boot Admin
* Monitors all services
* Displays Actuator health endpoints
* Centralized monitoring dashboard

---

# 🗂 Project Structure

```
student-course-microservices-jpa/
│
├── student-course-service-registry
├── student-course-api-gateway
├── student-service
├── course-service
├── enrollment-service
└── student-course-admin-server
```

Each service follows:

```
Controller → Service → Repository → Database
```

---

# 🛢 Database Design

Each service follows **Database per Service Pattern**.

### Student Database

* id
* name
* email

### Course Database

* id
* title
* description

### Enrollment Database

* id
* student_id
* course_id

---

# ⚙️ Tech Stack

| Layer             | Technology           |
| ----------------- | -------------------- |
| Language          | Java 17 / 21         |
| Framework         | Spring Boot          |
| Microservices     | Spring Cloud         |
| Service Discovery | Eureka               |
| API Gateway       | Spring Cloud Gateway |
| ORM               | Hibernate            |
| Persistence       | Spring Data JPA      |
| Database          | MySQL                |
| Monitoring        | Spring Boot Admin    |
| Build Tool        | Maven                |

---

# 🚀 How To Run The Project

## ✅ Step 1 – Start MySQL

Create databases:

```sql
CREATE DATABASE studentdb;
CREATE DATABASE coursedb;
CREATE DATABASE enrollmentdb;
```

---

## ✅ Step 2 – Start Services (Order Matters)

Start in this sequence:

1. student-course-service-registry
2. student-course-admin-server
3. student-service
4. course-service
5. enrollment-service
6. student-course-api-gateway

---

## ✅ Step 3 – Verify Registration

Open:

```
http://localhost:8761
```

All services should appear as **UP**.

---

## ✅ Step 4 – Test APIs

Access via Gateway:

```
http://localhost:3333/student/1
http://localhost:3333/course/1
```

---

# 🧠 Architecture Patterns Used

* Microservices Architecture
* Service Discovery Pattern
* API Gateway Pattern
* Database per Service Pattern
* Layered Architecture
* DTO Pattern
* Distributed System Communication

---

# 🎯 Key Highlights

✔ Independent deployable services
✔ Dynamic service discovery
✔ Centralized API routing
✔ Clean separation of concerns
✔ Production-style scalable design
✔ Monitoring dashboard integration

---

# 📈 What This Project Demonstrates

* Real-world backend system design
* Enterprise-level microservice structure
* Understanding of distributed systems
* Service-to-service communication
* Scalable backend architecture

---
