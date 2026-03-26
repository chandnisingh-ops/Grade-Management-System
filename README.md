# 📊 Grade Management System 

## 📌 Overview

The **Grade Management System** is a Java-based console application that manages student academic records. It allows users to store marks for multiple subjects, calculate averages, assign grades, and generate performance reports.

This project demonstrates core programming concepts such as **arrays, loops, conditional logic, and input validation**.

---

## 🎯 Features

* ➕ Add student marks for multiple subjects
* 📋 View all student records in tabular format
* 📊 Calculate average marks and grades
* 🏆 Identify the top-performing student
* 🔍 Search student by name
* 📈 Generate overall performance report
* ⚠️ Input validation for marks and menu selection

---

## 🧱 Project Structure

```bash
GradeManagementSystem.java
```

### Key Components:

* **studentNames[]**

  * Stores names of students

* **studentMarks[][]**

  * 2D array storing marks for 5 subjects

* **subjects[]**

  * List of subjects:

    * Mathematics
    * Science
    * English
    * Hindi
    * Computer

---

## ⚙️ Technologies Used

* Java (JDK 17)
* Arrays (1D & 2D)
* Scanner (User Input Handling)

---

## ▶️ How to Run

### Prerequisites

* Install **JDK 17**
* Install **VS Code** (with Java Extension Pack)

---

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/chandnisingh-ops/Grade-Management-System
   ```

2. Open project in VS Code

3. Compile the code:

   ```bash
   javac GradeManagementSystem.java
   ```

4. Run the program:

   ```bash
   java GradeManagementSystem
   ```

---

## 🧠 Functional Workflow

1. User selects an option from the menu
2. System performs the selected operation
3. Data is stored in arrays during runtime
4. Results are displayed in formatted output

---

## 📊 Grading Logic

| Average Marks | Grade |
| ------------- | ----- |
| 90 – 100      | A     |
| 80 – 89       | B     |
| 70 – 79       | C     |
| 60 – 69       | D     |
| Below 60      | F     |

---

## 📈 Performance Report Includes

* Total number of students
* Highest average marks
* Lowest average marks
* Overall class average

---

## ⚠️ Limitations

* ❌ Data is not stored permanently (no database/file system)
* ❌ Console-based (no GUI)
* ❌ Maximum student limit: 100

---

## 🔮 Future Improvements

* Add database integration (MySQL / JDBC)
* Develop GUI using JavaFX or Swing
* Export reports to file (CSV / PDF)
* Remove fixed student limit

---

## 👤 Author

**Chandni Singh**

---

## 📄 License

This project is created for educational purposes only.


Give this repo a star ⭐ and improve it further!
