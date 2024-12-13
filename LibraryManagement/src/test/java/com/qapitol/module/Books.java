package com.qapitol.module;

import java.util.List;

public class Books {
    private int id;
    private String name;
    private  String author;

    public List<Student> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<Student> studentDetails) {
        this.studentDetails = studentDetails;
    }

    private List<Student> studentDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
