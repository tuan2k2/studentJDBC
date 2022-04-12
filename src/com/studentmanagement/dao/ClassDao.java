package com.studentmanagement.dao;

import com.studentmanagement.entity.Class;
import com.studentmanagement.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {

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

    // CRUD

    public List<Class> findAll() throws SQLException {
        String query = "SELECT * FROM Class";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Class> classList = new ArrayList<>();
        while (resultSet.next()) {
            Class result = new Class(resultSet);
            classList.add(result);
        }
        return classList;
    }


    public  boolean addClass(Class classes) throws SQLException {
        String query = "insert into class(id,class_name,major) values ("
                + "'" + classes.getClassName() + "', '" + classes.getMajor() + "')";
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet != 0) {
            System.out.println("Add Student successfully");
            return true;
        }
        System.out.println("nhạp sai");
        return false;
    }

    public Class findById(int id) throws SQLException {
        String query = "SELECT * FROM Class WHERE id = " + id;
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            Class result = new Class(resultSet);
            return result;
        }
        return null;
    }



    public Class deleteClass(int id) throws SQLException{
        String query =  "delete from class where id =" + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if (resultSet!=0){
            System.out.println("successfully deleted");
        }
        return null;
    }



}