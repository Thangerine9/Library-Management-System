Library-Management-System
A Java-based console application for managing class sections, student records, and tracking attendance using flat-file storage.

Student Attendance Monitoring System (SAMS)

SAMS is a Java-based console application designed to manage class sections, maintain student records, and streamline attendance monitoring. The system utilizes a flat-file database approach to save and manage data across user sessions for persistent storage


 Features

- Password Authentication: Restricts unauthorized access with password-protected login.
- Class Section Management: Create, edit, list, and delete class sections and course codes (`Classes.txt`).
- Student Data Handling: Structure student records linked to corresponding courses and sections.
- File Persistence: Reads and writes section data directly to local text files using Java File I/O.
- Console UI: Clear, menu-driven command-line navigation with title screens and error-handling loops.



 Tech Stack & Architecture

- Language: Java
- Data Storage: Plain Text File I/O (`BufferedReader`, `PrintWriter`, `FileWriter`)
- Data Structures: `ArrayList` for dynamic object handling
- Paradigm: Object-Oriented Programming (OOP)

---

 File Structure
SAMS/
├── RunProgram.java      # Main entry point to launch the application
├── Program.java         # Initializes authentication and routes to HomePage
├── Login.java           # Authentication handler validating against Password.txt
├── HomePage.java        # Main dashboard displaying loaded class lists
├── ClassModify.java     # Class management workflow (Add, Edit, Delete)
├── Information.java     # In-memory storage arrays for Classes and Students
├── QualityOfLife.java   # Formatting helpers (screen clearing, headers)
├── Classes.txt          # File database storing class/section records
└── Password.txt         # File database storing system access password
