package com.studentmanagement.service;

import com.studentmanagement.dao.ClassDao;
import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.entity.Class;
import com.studentmanagement.entity.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClassService {
    private ClassDao classDao = new ClassDao();
    private Scanner scanner = new Scanner(System.in);

    public  void findAll(){
        try {
            System.out.println("Find all");
            List<Class> classes = classDao.findAll();
            if (classes.isEmpty()) {
                System.out.println("List is empty");
            }
            for (Class classStudent : classes) {
                System.out.println(classStudent);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
    public void addClass() {
        try {
            System.out.println("Enter Class Id:");
            int classID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter className: ");
            String className = scanner.nextLine();
            System.out.print("Enter major: ");
            String major = scanner.nextLine();
            Class classStudent =  new Class(className,major);
            classDao.addClass(classStudent);

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
    public void findIdClass(){
        try {
            System.out.println("Enter ID Class");
            int idClass = scanner.nextInt();
            scanner.nextLine();
            Class classStudent = classDao.findById(idClass);
            System.out.println(classStudent);
        } catch (SQLException sqlException){
            System.out.println("sqlException");
        }
    }



    public void deleteClass(){
        try {
            System.out.println("Enter ID Class");
            int idClass = scanner.nextInt();
            scanner.nextLine();
            Class classStudent = classDao.deleteClass(idClass);
        } catch (SQLException sqlException){
            System.out.println("sqlException");
        }
    }
}
