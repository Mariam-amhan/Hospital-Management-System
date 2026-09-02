# Hospital Management System

A console-based Hospital Management System developed in Java using Object-Oriented Programming (OOP). The project allows users to manage patients, doctors, and appointments, with support for data storage using text files.

---

## Features

- Add, update, search, remove, and display patients. 
- Add, update, search, remove, and display doctors.
- Book, search, remove, and display appointments.
- Save all data to text files.
- Load saved data automatically when the program starts.
- Menu-driven console interface.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- VS Code
- Git & GitHub

---

## Project Structure

```
src
│
├── Main.java
│
├── models
│   ├── Person.java
│   ├── Patient.java
│   ├── Doctor.java
│   └── Appointment.java
│
└── services
    ├── HospitalSystem.java
    └── FileManager.java
```

---

## How to Run

1. Clone the repository.
2. Open the project in VS Code.
3. Compile and run `Main.java`.
4. Use the menu to manage patients, doctors, and appointments.

---

## OOP Concepts Used

- Classes & Objects
- Encapsulation
- Inheritance
- Constructors
- Association

---

## Sample Menu

```text
1. Add Patient
2. Update Patient
3. Search Patient
4. Remove Patient
5. Display Patients
6. Add Doctor
7. Update Doctor
8. Search Doctor
9. Remove Doctor
10. Display Doctors
11. Book Appointment
12. Search Appointment
13. Remove Appointment
14. Display Appointments
15. Save & Exit
```

---


## Learning Outcomes

Through this project, I strengthened my understanding of:

- Object-Oriented Programming (OOP) principles in Java.
- Designing classes and managing relationships between objects.
- File handling for persistent data storage.
- Organizing Java projects into models and services.
- Building a complete console-based management system.

---


## Future Improvements

* Migrate the current console-based application to Spring Boot.
* Develop RESTful APIs for managing patients, doctors, and appointments.
* Replace text file storage with a relational database such as MySQL.
* Use Spring Data JPA for database operations.
* Add authentication and role-based access for different users.
* Develop a web-based user interface for the system.

---


