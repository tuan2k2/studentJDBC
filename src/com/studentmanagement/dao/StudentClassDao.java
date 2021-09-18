package com.studentmanagement.dao;

import com.studentmanagement.entity.Student;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentClassDao {
    private Connection conn;

    public Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "anhtuank56");
            return conn;
        }
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    // findAll
    public boolean addAllStudentClass(Student student) throws SQLException{
        String dob = student.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String query = "insert into student(first_name,last_name,city,average_score,gender,dob,class_id) values ("
                + "'" + student.getFirstName() + "', '" + student.getLastName() + "', '" +
                student.getCity() + "', " + student.getAverageScore() + ", '" + student.getGender() + "', '" +
                dob + "'," + student.getClassId().getID() + " )";
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate(query);
        if (result != 0) {
            System.out.println("Add Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }


    // display students by class

    public List<Student> findStudentByClassName(String className) throws SQLException {
        String query = "select  *FROM Student JOIN Class ON Student.class_ID = Class.ID where class_name ='" + className + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student result = new Student(resultSet);
            students.add(result);
        }
        return students;
    }

    // calculate AverageScore By ClassName
    public Double calculateAverageScoreByClassName(String className) throws SQLException {
        String query = "SELECT AVG(Student.average_score) AS average FROM " +
                "Student JOIN Class ON Student.class_id = Class.ID " +
                "WHERE class_name = '" + className +
                "' GROUP BY class_name";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if(resultSet.next()) {
            double average = resultSet.getDouble(1);
            return average;
        }
        return null;
    }


    // find Students By major
    public List<Student> findStudentsByMajor(String major) throws SQLException {
        String query = " select * from student join class on student.class_id = class.ID where class.major = '" + major + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student result = new Student(resultSet);
            students.add(result);
        }
        return students;
    }

    // DisplayTheNumberOfStudentsByClassName
    public  Integer DisplayTheNumberOfStudentsByClassName(String className) throws  SQLException{
        String query = "SELECT count(Student.ID) AS number_student" +
                " FROM Student JOIN Class ON Student.class_id = Class.ID " +
                "where class.class_name = '" + className + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()){
            int count = resultSet.getInt(1);
            return count;
        }
        return null;
    }


    //DisplayTheNumberOfStudentsByMajor
    public  Integer DisplayTheNumberOfStudentsByMajor(String major) throws  SQLException{
        String query = "SELECT count(Student.ID) AS number_student" +
                " FROM Student JOIN Class ON Student.class_id = Class.ID " +
                "where class.major = '" + major + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()){
            int count = resultSet.getInt(1);
            return count;
        }
        return null;
    }

    // update Class name
    public  Boolean updateByClassName(int id , String className ) throws SQLException{
        String query =" update class set class_name = '" + className + "' where id= " +id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet!=0){
            System.out.println("successful fix");
            return true;
        }
        return false;
    }


    //


    public Double averageAgeByClass(String className) throws SQLException {
        String query = "select avg((YEAR(CURDATE()) - YEAR(dob) - (RIGHT(CURDATE(), 5) < RIGHT(dob, 5))))" +
                " from Student JOIN Class ON Student.class_ID = Class.ID" +
                " where class.class_name = '" +className+ "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if(resultSet.next()) {
            double average = resultSet.getDouble(1);
            return average;
        }
        return null;
    }
}
