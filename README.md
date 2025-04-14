## Smart Expense Tracker - Spring Boot Project

### Project Overview
Smart Expense Tracker is a full-featured Spring Boot application that allows users to manage their income and expenses, view analytics, and download financial reports. The app includes user authentication, role-based access control, and support for admin dashboards.

---

### Folder Structure
```
smart-expense-tracker/
├── src/
│   ├── main/
│   │   ├── java/com/gyarsilal/expense/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── security/
│   │   │   └── ExpenseTrackerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
├── Dockerfile
├── pom.xml
└── README.md
```

---

### Sample API Endpoints

#### Auth APIs
```
POST   /api/auth/register        → Register a new user
POST   /api/auth/login           → Login and receive JWT token
```

#### User APIs
```
GET    /api/user/profile         → Get user details
PUT    /api/user/profile         → Update profile
```

#### Expense APIs
```
POST   /api/expense              → Add an expense
GET    /api/expense              → Get all expenses
GET    /api/expense/{id}         → Get a specific expense
PUT    /api/expense/{id}         → Update an expense
DELETE /api/expense/{id}         → Delete an expense
```

#### Analytics APIs
```
GET    /api/analytics/monthly    → Monthly trend line chart
GET    /api/analytics/category   → Category-wise spending pie chart
```

#### Admin APIs (ADMIN role only)
```
GET    /api/admin/users          → List all users
DELETE /api/admin/users/{id}     → Remove user
PUT    /api/admin/users/role     → Change user role
```

#### Export APIs
```
GET    /api/export/pdf           → Download PDF report
GET    /api/export/excel         → Download Excel report
```

---

### Tech Stack
- Spring Boot
- Spring Security + JWT
- JPA/Hibernate
- PostgreSQL
- Thymeleaf
- Swagger for API documentation
- Chart.js for analytics UI

---

### Future Enhancements
- Email notification for budget alerts
- Recurring transactions
- Multi-language support
- Docker + CI/CD deployment

---

### License
Open source for learning and portfolio use.
