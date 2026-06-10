# 🏥 MedJobs India

India's First Dedicated Job Portal for Medical Professionals & Students

## 🚀 Tech Stack
- **Backend:** Java, Spring Boot 3.5
- **Database:** PostgreSQL + JPA/Hibernate
- **Security:** JWT Authentication + BCrypt
- **Frontend:** React.js

## 📋 Features
- User Registration & Login (SEEKER / EMPLOYER)
- JWT Token based Authentication
- Job Post & Browse
- Filter jobs by Location & Specialization
- Apply for Jobs
- View Applications

## 🔗 API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/users/register | Register user |
| POST | /api/users/login | Login & get JWT token |
| POST | /api/jobs/post | Post a job |
| GET | /api/jobs/all | Get all jobs |
| POST | /api/applications/apply | Apply for job |

## ⚙️ Setup
1. Install PostgreSQL & create database `medjobs`
2. Update `application.properties` with your DB password
3. Run `MedjobsApplication.java`
4. Frontend: `cd medjobs-frontend && npm start`

## 🔮 Upcoming Features
- [ ] Document verification for doctors & hospitals
- [ ] Role based access control (EMPLOYER/SEEKER)
- [ ] Admin panel for profile verification
- [ ] Email notifications for applications
- [ ] AI-powered job recommendations
- [ ] Resume upload feature
