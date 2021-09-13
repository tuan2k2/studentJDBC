package com.studentmanagement.service;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.entity.Student;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class StudentService {

    private StudentDao studentDao = new StudentDao();
    private Scanner scanner = new Scanner(System.in);

    public void findAll() {
        try {
            System.out.println("Find all");
            List<Student> students = studentDao.findAll();
            if (students.isEmpty()) {
                System.out.println("List is empty");
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (SQLException sqlException) {
            System.out.println("sql exception");
        }
    }


    public void addStudent() {
        try {
            System.out.print("Enter lastName: ");
            String lName = scanner.nextLine();
            System.out.print("Enter firstName: ");
            String fName = scanner.nextLine();
            System.out.print("Enter City: ");
            String City = scanner.nextLine();
            System.out.print("Enter averageScore: ");
            double averageScore = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter Dob: ");
            String dob = scanner.nextLine();
            LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
            Student student = new Student(studentDao.generateId(), lName, fName, City, 0, gender.charAt(0), date);
            studentDao.addStudent(student);

        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }


    public void deleteById() {
        try {
            System.out.println("Search By id");
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = studentDao.deleteById(id);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }


    public void updateStudentName() {
        try {
            Student student = new Student();
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter lastName: ");
            String lName = scanner.nextLine();
            student.setLastName(lName);
            System.out.print("Enter firstName: ");
            String fName = scanner.nextLine();
            student.setFirstName(fName);
            studentDao.updateStudentName(student, id);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }




    public void findById() {
        try {
            System.out.println("Search By id");
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = studentDao.findById(id);
            System.out.println(student);
        } catch (SQLException sqlException) {
            System.out.println("sql exception");
        }
    }


    public void findByName() {
        try {
            System.out.println("Search By name");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            Student student = studentDao.findByName(name);
            System.out.println(student);
        } catch (SQLException sqlException) {
            System.out.println("sql exception");
        }
    }

    public void mediumScore() {
        try {
            System.out.println("GPA of all students:");
            studentDao.mediumScore();
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }



    public void searchStudentMaxAverageScore() {
        try {
            Student student = studentDao.searchStudentMaxAverageScore();
            System.out.println(student);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }




    public void updateStudentScore() {
        try {
            Student student = new Student();
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter averageScore: ");
            double averageScore = scanner.nextDouble();
            student.setAverageScore(averageScore);
            scanner.nextLine();
            studentDao.updateStudentScore(student, id);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }
    public void updateStudentDob() {
        try {
            Student student = new Student();
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Dob: ");
            String dob = scanner.nextLine();
            LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
            student.setDob(date);
            studentDao.updateStudentDob(student, id);
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }
    }
    public void updateAllScore() {
        try {
            Student student = new Student();
            System.out.print("Enter Score New: ");
            float score = scanner.nextFloat();
            scanner.nextLine();
            student.setAverageScore(score);
            studentDao.updateAllScore(score);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    public void averageAge(){
        try {
            System.out.println("average age is:");
            studentDao.averageAge();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }



    public void findByCity() {
        try {
            System.out.print("Enter City 1: ");
            String name1 = scanner.nextLine();
            System.out.print("Enter City 2: ");
            String name2 = scanner.nextLine();
            Student student = studentDao.findByCity(name1,name2);
            System.out.println(student);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
    public void sortByName() {
        try {
            Student student = studentDao.sortByName();
            System.out.println(student);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
}
