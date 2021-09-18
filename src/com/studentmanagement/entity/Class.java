package com.studentmanagement.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Class {
    private int ID;
    private String className;
    private String major;

    public Class(String className, String major) {
        this.className = className;
        this.major = major;
    }

    public Class() {
    }

    public Class(ResultSet resultSet) throws SQLException {
        this.setID(resultSet.getInt("ID"));
        this.setClassName(resultSet.getString("class_name"));
        this.setMajor(resultSet.getString("major"));

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;
        Class aClass = (Class) o;
        return ID == aClass.ID && Objects.equals(className, aClass.className) && Objects.equals(major, aClass.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, className, major);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Class{" +
                "ID=" + ID +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}