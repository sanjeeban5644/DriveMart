# 🚗 DriveMart

DriveMart is a Spring Boot application that provides REST APIs to manage **cars**, **brands**, **colors**, and **engines**. It demonstrates modern backend development practices using **Spring Boot**, **JPA**, **Hibernate**, and **Swagger**.

---

## ✅ Features
- **CRUD Operations** for:
  - Car
  - Brand
  - Color
  - Engine
- **Relationships:**
  - `Many-to-One` (Car → Brand)
  - `One-to-Many` (Brand → Car)
  - `Many-to-Many` (Car ↔ Color)
- **Database Support:**
  - Works with **MySQL**, **PostgreSQL**, or **H2 (for testing)**
- **Swagger Integration** for API documentation
- **Timestamps** with `@CreationTimestamp` and `@UpdateTimestamp`

---

## 🛠 Tech Stack
- **Java**: 17+
- **Spring Boot**: 3.x
- **Spring Data JPA**
- **Hibernate**
- **H2 / MySQL Database**
- **Swagger (Springdoc OpenAPI)**
- **Maven** for build automation

---

## 📂 Project Structure
```

DriveMart/
├── src/main/java/com/sanjeeban/DriveMart/
│   ├── controller/      # REST Controllers
│   ├── service/         # Service Layer
│   ├── repository/      # JPA Repositories
│   ├── entity/          # JPA Entities (Car, Brand, Color, Engine)
│   └── DriveMartApplication.java
├── src/main/resources/
│   ├── application.properties
│   ├── data.sql         # Initial data (optional)
│   └── schema.sql       # Custom schema (optional)
└── pom.xml

````

---

## ⚙️ Getting Started

### ✅ Prerequisites
- **Java 17+**
- **Maven 3.8+**
- **MySQL (or use H2 in-memory DB)**

### ✅ Steps to Run
1. **Clone the repository**:

   git clone https://github.com/<your-username>/DriveMart.git
   cd DriveMart


2. **Configure the database**:
   In `src/main/resources/application.properties`, update:

   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/drivemart_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   

3. **Build and run the app**:

   
   mvn clean install
   mvn spring-boot:run
   

4. **Access API Documentation**:
   Open:

   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📦 API Endpoints

| Method | Endpoint   | Description      |
| ------ | ---------- | ---------------- |
| GET    | `/cars`    | Get all cars     |
| POST   | `/cars`    | Add a new car    |
| GET    | `/brands`  | Get all brands   |
| POST   | `/brands`  | Add a new brand  |
| GET    | `/colors`  | Get all colors   |
| POST   | `/colors`  | Add a new color  |
| GET    | `/engines` | Get all engines  |
| POST   | `/engines` | Add a new engine |

(Full API details available in **Swagger UI**)

---

## 🧪 Running with H2 (In-memory)

Add this in `application.properties` for quick testing:

properties
spring.datasource.url=jdbc:h2:mem:drivemart_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.h2.console.enabled=true


Then access H2 console:


http://localhost:8080/h2-console





### 🔗 Connect

Developed by **Sanjeeban Mukhopadhyay**
GitHub: [@sanjeeban5644](https://github.com/sanjeeban5644)


