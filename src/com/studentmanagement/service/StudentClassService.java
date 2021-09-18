package com.studentmanagement.service;

import com.studentmanagement.dao.ClassDao;
import com.studentmanagement.dao.StudentClassDao;
import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.entity.Class;
import com.studentmanagement.entity.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StudentClassService {
    private ClassDao aClass = new ClassDao();
    private StudentClassDao studentClassDao = new StudentClassDao();
    private Scanner scanner = new Scanner(System.in);
    // find all  Students   Class
    public void addStudentClass() {
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
            System.out.println("please choose a class id");
            List<Class> classes = aClass.findAll();
            for (Class classList : classes){
                System.out.println(classList);
            }
            int choose =  scanner.nextInt();
            scanner.nextLine();
            Class classs = aClass.findById(choose);
            if (classs == null){
                System.out.println("not found class");
                return;
            }
            Student student = new Student(lName, fName, City, averageScore, gender.charAt(0), date,null);
            student.setClassId(classs);
            studentClassDao.addAllStudentClass(student);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }



    // find Student Class By major


    public  void  findStudentClassByMajor(){
        try {
            System.out.println("Enter Major");
            String major = scanner.next();
            List<Student> students = studentClassDao.findStudentsByMajor(major);
            for (Student student : students){
                System.out.println(student);
            }
        } catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    // find Student By ClassName


    public  void  findStudentClassByClassName(){
        try {
            System.out.println("Enter ClassName");
            String className = scanner.next();
            List<Student> students = studentClassDao.findStudentByClassName(className);
            for (Student student : students){
                System.out.println(student);
            }
        } catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }


    // calculate Average Score By ClassName

    public void  calculateAverageScoreByClassName(){
        try {
            System.out.println("ClassName:");
            String className = scanner.next();
            System.out.println("grade point average of class  " + className);
            System.out.println(studentClassDao.calculateAverageScoreByClassName(className));
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    // DisplayTheNumberOfStudentsByClassName
    public void  displayTheNumberOfStudentsByClassName(){
        try {
            System.out.println("ClassName:");
            String className = scanner.next();
            System.out.println("class " + className + " has " + studentClassDao.DisplayTheNumberOfStudentsByClassName(className) + " student");
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
    // DisplayTheNumberOfStudentsByMajor
    public void  displayTheNumberOfStudentsByMajor(){
        try {
            System.out.println("Major:");
            String major = scanner.next();
            System.out.println("Major " + major + " has " + studentClassDao.DisplayTheNumberOfStudentsByMajor(major) + " student");
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
    // update class name


    public  void updateClassName(){
        try {
            Class  aclass = new Class();
            System.out.println("Enter id:");
            int id = scanner.nextInt();
            scanner.nextLine();
            aclass.setID(id);
            System.out.println("Enter ClassName");
            String className = scanner.nextLine();
            aclass.setClassName(className);
            studentClassDao.updateByClassName(id,className);
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }



    //

    public void  averageAgeByClass(){
        try {
            System.out.println("Enter Class Name:");
            String className = scanner.next();
            System.out.println("average age by grade:");
            System.out.println(studentClassDao.averageAgeByClass(className));
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
}