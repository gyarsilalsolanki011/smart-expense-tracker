## 📊 Smart Expense Tracker - Spring Boot Project

### 📃 Project Overview
**Smart Expense Tracker** is a comprehensive Spring Boot-based web application designed to help users track their income and expenses efficiently, visualize financial trends, manage budgets, and receive timely notifications. It features role-based access control for **Users**, **Managers**, and **Admins**, making it ideal for both personal and team financial management.

---

### 🚀 Key Features

#### 🔐 User Authentication & Authorization
- Secure login with **JWT (JSON Web Tokens)**
- Role-based access:
    - **User**: Manage own income and expenses
    - **Manager**: View and analyze team or department-level data
    - **Admin**: Full access to manage users, roles, and application settings

#### 💰 Expense & Income Management
- Perform **CRUD operations** on income and expenses
- Assign **categories** to transactions (Food, Rent, Travel, etc.)
- **Monthly budget planning** per user
- Link expenses to specific users (multi-user support)

#### 📊 Data Visualization & Analytics
- **Pie chart**: Visualize category-wise spending
- **Line chart**: Show monthly financial trends
- Tools: **Chart.js** or **Google Charts**

#### 📄 PDF & Excel Export
- Export expense reports within a date range
- Download in **PDF** or **Excel (XLSX)** format
- Useful for tax, audits, or sharing

#### 📧 Email Notifications (Planned/Future Enhancement)
- Notify users when expenses exceed their set budget
- Automated **weekly/monthly summary emails**

#### 🔁 RESTful APIs
- Clean and structured **REST APIs** for all features
- Documented using **Swagger / OpenAPI**
- Easy to integrate with mobile or SPA frontend

#### 💻 Frontend
- Basic UI with **Thymeleaf**
- (Optional) Can be integrated with **React**, **Angular**, or **Vue.js** for a more modern single-page experience

---

### 📂 Project Structure
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

### 🔮 Sample API Endpoints

#### 🔑 Auth
```http
POST /api/auth/register        # Register a new user
POST /api/auth/login           # Login and receive JWT
```

#### 👤 User
```http
GET /api/user/profile          # Get user profile
PUT /api/user/profile          # Update profile
```

#### 💸 Expenses
```http
POST /api/expense              # Add a new expense
GET /api/expense               # Get all expenses (user-specific)
PUT /api/expense/{id}          # Update an expense
DELETE /api/expense/{id}       # Delete an expense
```

#### 📈 Analytics
```http
GET /api/analytics/monthly     # Line chart data
GET /api/analytics/category    # Pie chart data
```

#### 🛠️ Admin (Admin Role Only)
```http
GET /api/admin/users           # View all users
PUT /api/admin/users/role      # Change user role
DELETE /api/admin/users/{id}   # Delete a user
```

#### 📅 Export
```http
GET /api/export/pdf            # Download PDF report
GET /api/export/excel          # Download Excel report
```

---

### 🛠️ Tech Stack

| Layer           | Technology                          |
|----------------|--------------------------------------|
| Backend         | Spring Boot, Spring Security (JWT)  |
| ORM & DB        | JPA (Hibernate), MySQL/PostgreSQL   |
| Visualization   | Chart.js / Google Charts            |
| Export          | Apache POI, iText (PDF & Excel)     |
| API Docs        | Swagger/OpenAPI                     |
| Frontend (UI)   | Thymeleaf / React / Angular (opt.)  |
| Deployment      | Docker (containerization)           |

---

### 🧰 Future Enhancements
- Recurring transactions
- Notification via SMS/Email
- Multi-language support
- CI/CD integration
- Mobile app support (Android/iOS)

---

### 📜 License
Open source project for educational and portfolio use.

---

### ✨ Author
Developed by **Gyarsilal Solanki**

Feel free to fork, contribute, and suggest improvements!

