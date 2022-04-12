package com.studentmanagement.entity;

import com.studentmanagement.dao.ClassDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student {
    //ID int primary key,
    //last_name varchar(50) not null,
    //first_name varchar(50)  not null,
    //city varchar(50) not null,
    //average_score double,
    //gender char(1) not null,
    //dob date not null
    private int ID;
    private String lastName;
    private String firstName;
    private String city;
    private double averageScore;
    private char gender;
    private LocalDate Dob;
    private Class classId;

    public Student( String lastName, String firstName, String city, double averageScore, char gender, LocalDate date, Class classId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.averageScore = averageScore;
        this.gender = gender;
        this.Dob = date;
    }

    public Student() {
    }
    public Student(ResultSet resultSet) throws SQLException {
        this.ID = resultSet.getInt("ID");
        this.lastName = resultSet.getString("last_name");
        this.firstName = resultSet.getString("first_name");
        this.city = resultSet.getString("city");
        this.averageScore = resultSet.getDouble("average_score");
        this.gender = resultSet.getString("gender").charAt(0);
        String dobString = resultSet.getString("dob");
        LocalDate dob = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);
        this.Dob = dob;
        int classId = resultSet.getInt("class_id");
        ClassDao classDao = new ClassDao();
        Class classes = classDao.findById(classId);
        this.setClassId(classes);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        this.Dob = dob;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID && Double.compare(student.averageScore, averageScore) == 0 && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(city, student.city) && Objects.equals(gender, student.gender) && Objects.equals(Dob, student.Dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, lastName, firstName, city, averageScore, gender, Dob);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", averageScore=" + averageScore +
                ", gender=" + gender +
                ", Dob=" + Dob +
                ", className=" + classId.getClassName()+
                ", major=" + classId.getMajor()+
                '}';
    }
}

