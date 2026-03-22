# 📚 Learning Management System (LMS)

A full-stack **Learning Management System** built with a **Spring Boot** backend and **React (Vite)** frontend. It supports three user roles — **Admin**, **Faculty**, and **Student** — each with their own dedicated portal.

---

## 🗂️ Project Structure

```
LMS/
├── lmsbackend/          # Spring Boot REST API (Java 17, Maven)
└── lmsfrontend/         # React + Vite frontend (JavaScript)
```

---

## 🛠️ Tech Stack

### Backend
| Technology | Details |
|---|---|
| Framework | Spring Boot 3.4.4 |
| Language | Java 17 |
| Build Tool | Maven |
| Database | MySQL |
| ORM | Spring Data JPA (Hibernate) |
| Mail | Spring Boot Mail |
| Server Port | `2060` |

### Frontend
| Technology | Details |
|---|---|
| Framework | React 19 + Vite 6 |
| Routing | React Router DOM v7 |
| HTTP Client | Axios |
| Charts | Chart.js + react-chartjs-2 |
| Icons | react-icons |
| Port | `5173` (default Vite) |

---

## ⚙️ Prerequisites

Before running the project, make sure you have the following installed:

- **Java 17+**
- **Maven 3.6+**
- **Node.js 18+** and **npm**
- **MySQL 8.0+**

---

## 🗄️ Database Setup

1. Open MySQL and create the database:
   ```sql
   CREATE DATABASE lms;
   ```

2. The backend auto-creates tables using Hibernate (`ddl-auto=update`). No manual schema creation is needed.

3. Default DB credentials (configured in `application.properties`):
   ```
   URL:      jdbc:mysql://localhost:3306/lms
   Username: root
   Password: admin
   ```
   > ⚠️ Update `lmsbackend/src/main/resources/application.properties` if your MySQL credentials differ.

---

## 🚀 Running the Application

### 1. Start the Backend

```bash
cd lmsbackend
./mvnw spring-boot:run
```

Or on Windows:
```cmd
cd lmsbackend
mvnw.cmd spring-boot:run
```

The backend will start at: **`http://localhost:2060`**

---

### 2. Start the Frontend

```bash
cd lmsfrontend
npm install
npm run dev
```

The frontend will start at: **`http://localhost:5173`**

---

## 🏗️ Backend Architecture

The backend follows a standard **layered architecture**:

```
Controller → Service (Interface + Impl) → Repository → Database
```

### 📦 Package Structure

```
com.klef.fsd.sdpproject
├── controller/       # REST API endpoints
├── service/          # Business logic (interfaces + implementations)
├── repository/       # Spring Data JPA repositories
├── model/            # JPA entity classes
└── dto/              # Data Transfer Objects
```

### 🗃️ Models / Entities

| Entity | Description |
|---|---|
| `Admin` | Administrator user with username/password |
| `Student` | Student user with registration, login, and profile info |
| `Faculty` | Faculty/Instructor with login credentials |
| `Course` | Course entity with name, description, and duration |
| `EnrollCourse` | Enrollment record linking a student to a course |
| `Assignment` | Assignment linked to a specific course |
| `Grade` | Grade record for student course performance |

### 🌐 REST API Endpoints

#### Admin (`/admin`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/admin/checkadminlogin` | Admin login |
| `GET` | `/admin/viewallstudents` | List all students |
| `GET` | `/admin/viewallinstructors` | List all faculty |
| `POST` | `/admin/addfaculty` | Add a new faculty member |
| `DELETE` | `/admin/deletestudent?sid={id}` | Delete a student |
| `DELETE` | `/admin/deletefaculty?iid={id}` | Delete a faculty member |
| `GET` | `/admin/studentcount` | Total student count |
| `GET` | `/admin/facultycount` | Total faculty count |
| `GET` | `/admin/coursecount` | Total course count |

#### Student (`/student`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/student/registration` | Register a new student |
| `POST` | `/student/checkstudentlogin` | Student login |
| `PUT` | `/student/updateprofile` | Update student profile |
| `GET` | `/student/viewallcourses` | Browse all available courses |
| `POST` | `/student/enrollCourse` | Enroll in a course |
| `GET` | `/student/enrolledcourses/{sid}` | Get student's enrolled courses |

#### Faculty (`/api/faculty`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/faculty/login` | Faculty login |
| `POST` | `/api/faculty/add` | Add a new faculty |
| `GET` | `/api/faculty/all` | List all faculty |
| `GET` | `/api/faculty/{id}` | Get faculty by ID |

#### Course (`/course`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/course/add` | Add a new course |
| `GET` | `/course/{id}` | Get course by ID |
| `PUT` | `/course/{id}` | Update course |
| `DELETE` | `/course/{id}` | Delete course |

#### Assignments (`/assignments`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/assignments/create` | Create an assignment |
| `GET` | `/assignments/course/{courseId}` | Get assignments by course |

#### Enrollments (`/api/enrollments`)
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/enrollments/add` | Enroll a student |
| `GET` | `/api/enrollments/viewall` | View all enrollments |
| `GET` | `/api/enrollments/bystudent/{studentId}` | Enrollments by student |
| `GET` | `/api/enrollments/bycourse/{courseId}` | Enrollments by course |
| `DELETE` | `/api/enrollments/delete/{enrollId}` | Delete an enrollment |

---

## 🖥️ Frontend Architecture

The frontend is a **React SPA** with role-based routing and a shared authentication context.

### 📁 Folder Structure

```
lmsfrontend/src/
├── App.jsx              # Root component with role-based routing & navbars
├── AuthContext.jsx      # Authentication context provider
├── main.jsx             # Entry point (React DOM render)
├── admin/               # Admin portal components
├── faculty/             # Faculty portal components
└── student/             # Student portal components
```

### 🔐 Authentication

- On login, user role and session info are stored in `localStorage`.
- `App.jsx` reads `isLoggedIn` and `userRole` from localStorage to render the correct **Navbar** and protect routes.
- Three roles: `student`, `admin`, `faculty`.

### 👤 Admin Portal (`/src/admin/`)

| Component | Description |
|---|---|
| `AdminLogin.jsx` | Admin authentication page |
| `AdminHome.jsx` | Admin homepage/landing |
| `AdminDashboard.jsx` | Dashboard with stats overview |
| `AdminNavbar.jsx` | Navigation bar for admin |
| `ManageStudents.jsx` | View and delete students |
| `ManageFaculty.jsx` | View, add, and delete faculty |
| `ManageCourses.jsx` | Full CRUD for courses |
| `AdminCourses.jsx` | Course listing and management |
| `AdminAssignments.jsx` | Assignment management |
| `AdminReports.jsx` | Reports and analytics |
| `AdminAnnouncements.jsx` | Send announcements |
| `AdminRemainders.jsx` | Reminder management |
| `AdminSettings.jsx` | Admin settings page |
| `AdminSupport.jsx` | Support/help center |
| `ManageUsers.jsx` | Unified user management view |

### 👨‍🏫 Faculty Portal (`/src/faculty/`)

| Component | Description |
|---|---|
| `FacultyLogin.jsx` | Faculty authentication page |
| `Home.jsx` | Faculty homepage |
| `Dashboard.jsx` | Faculty dashboard |
| `FacultyNavbar.jsx` | Navigation bar for faculty |
| `Courses.jsx` | View assigned courses |
| `CourseDetails.jsx` | Detailed view of a course |
| `Assignments.jsx` | Manage assignments for courses |
| `Announcements.jsx` | Post announcements to students |
| `DiscussionForum.jsx` | Discussion board |
| `profile.jsx` | Faculty profile management |
| `Help.jsx` | Help and support page |
| `Navbar.jsx` / `Navbar.css` | Shared navbar utilities |

### 🎓 Student Portal (`/src/student/`)

| Component | Description |
|---|---|
| `LMSLogin.jsx` | Main LMS landing/login selector |
| `StudentLogin.jsx` | Student-specific login |
| `Home.jsx` | Student homepage |
| `Dashboard.jsx` | Student dashboard |
| `StudentNavbar.jsx` | Navigation bar for students |
| `Courses.jsx` | Browse available courses |
| `CourseDetails.jsx` | View course details and enroll |
| `CourseGrades.jsx` | View grades per course |
| `AssignmentUpload.jsx` | Submit assignments |
| `AcademicRecords.jsx` | View academic history |
| `QuizPage.jsx` | Interactive quiz page |
| `Badges.jsx` | Achievement badges display |
| `Profile.jsx` | Student profile management |
| `Reminders.jsx` | Study reminders |
| `SearchResults.jsx` | Course/content search results |
| `Help.jsx` | Help and support page |
| `DAA.jsx` / `ENG.jsx` / `FSAD.jsx` / `OS.jsx` | Subject-specific content pages |

---

## 🔑 Default Login Credentials

> ⚠️ Admin credentials are seeded directly in the database. Ensure you insert an admin record manually or use a database seeder.

| Role | How to Access |
|---|---|
| Admin | Navigate to `/admin/login` |
| Faculty | Navigate to `/faculty/login` (credentials added by Admin) |
| Student | Navigate to `/student/login` (self-registration available) |

---

## 📐 Application Flow

```
User visits /
    └── LMSLogin.jsx (Role selection: Student / Faculty / Admin)
             ├── /student/login  → StudentLogin → /student/home (StudentNavbar)
             ├── /faculty/login  → FacultyLogin → /faculty/home (FacultyNavbar)
             └── /admin/login    → AdminLogin   → /admin/home   (AdminNavbar)
```

---

## 🛠️ Configuration

### Backend (`lmsbackend/src/main/resources/application.properties`)
```properties
spring.application.name=SDProject
server.port=2060

spring.datasource.url=jdbc:mysql://localhost:3306/lms
spring.datasource.username=root
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### Frontend Vite Config (`lmsfrontend/vite.config.js`)
- Default port: `5173`
- Uses `@vitejs/plugin-react` for React support.

---

## 📜 Available Scripts

### Backend
```bash
./mvnw spring-boot:run      # Run the Spring Boot application
./mvnw test                 # Run unit tests
./mvnw package              # Build a JAR file
```

### Frontend
```bash
npm run dev       # Start development server
npm run build     # Build for production
npm run preview   # Preview production build
npm run lint      # Run ESLint
```

---

## 📝 Notes

- CORS is enabled (`@CrossOrigin("*")`) on all controllers for development. **Restrict this in production.**
- Hibernate auto-DDL is set to `update` — it auto-creates/updates tables on startup.
- The frontend uses `localStorage` for session management (no JWT or cookie-based auth currently).
- Subject content pages (`DAA.jsx`, `ENG.jsx`, `FSAD.jsx`, `OS.jsx`) provide static course material.

---

