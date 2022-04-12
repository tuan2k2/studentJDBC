package com.studentmanagement.dao;

import com.studentmanagement.entity.Student;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StudentDao {

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

    public List<Student> findAll() throws SQLException {
        String query = "SELECT * FROM Student";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(resultSet);
            students.add(student);
        }
        return students;
    }


    public boolean addStudent(Student student) throws SQLException {
        String dob = student.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String query = "insert into student(first_name,last_name,city,average_score,gender,dob) values ("
                + "'" + student.getFirstName() + "', '" + student.getLastName() + "', '" +
                student.getCity() + "', " + student.getAverageScore() + ", '" + student.getGender() + "', '" +
                dob + "')";
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate(query);
        if (result != 0) {
            System.out.println("Add Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }



    public Student deleteById(int id) throws SQLException {
        String query = "delete from student where ID=" + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        while (resultSet != 0) {
            System.out.println("successfully deleted");
            break;
        }
        return null;
    }



    public Boolean updateStudentName(Student student, int id) throws SQLException {
        String query = "update student set last_name =   '" + student.getLastName() + "' , first_name = '" + student.getFirstName() + "' where id = " + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet != 0) {
            System.out.println("Update Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }





    public Student findById(int id) throws SQLException {

        String query = "SELECT * FROM Student WHERE id = " + id;
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            Student student = new Student(resultSet);
            return student;
        } else {
            return null;
        }

    }







    public Student findByName(String name) throws SQLException {
        String query = "select*from student where last_name like '" + name + "%'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Student student = new Student(resultSet);
            System.out.println(student);
        }
        return null;
    }




    public Float mediumScore() throws SQLException {
        String query = "select AVG(average_score) as mediumScore FROM student";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        return null;
    }



    public Student searchStudentMaxAverageScore() throws SQLException {
        String query = "SELECT * FROM Student WHERE average_score in (select max(average_score) from student )";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            Student student = new Student(resultSet);
            return student;
        } else {
            return null;
        }
    }



    public Boolean updateStudentScore(Student student, int id) throws SQLException {
        String query = "update student set average_score = '" + student.getAverageScore() + "' where id = " + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet != 0) {
            System.out.println("Update Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }



    public Boolean updateStudentDob(Student student, int id) throws SQLException {
        String dob = student.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String query = "update student set dob= '" + dob + "' where id=" + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet != 0) {
            System.out.println("Update Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }





    public Boolean updateAllScore(float d) throws SQLException {
        int k = findAll().size() ;
        String query = "update student set average_score = " + d + " where id between 0 and " + k;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet != 0) {
            System.out.println("Update StudentScore All successfully");
            return true;
        }
        return false;
    }



    public Float averageAge() throws SQLException {
        int k = findAll().size();
        String query = "select avg((YEAR(CURDATE()) - YEAR(dob)) - (RIGHT(CURDATE(), 5) < RIGHT(dob, 5))) from student where id  between 0 and " +k;
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        return null;
    }



    public List<Student> findByCity(String city1, String city2) throws SQLException {
        String query = "select *from student where city = '" + city1 + "' or city = '" + city2 + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(resultSet);
            students.add(student);
        }
        return students;
    }



    public Student sortByName() throws SQLException {
        String query = "select *from student  order by first_name asc;";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Student student = new Student(resultSet);
            System.out.println(student);
        }
        return null;
    }
}