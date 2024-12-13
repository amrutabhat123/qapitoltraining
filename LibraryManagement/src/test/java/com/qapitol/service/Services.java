package com.qapitol.service;

import com.qapitol.module.Books;

import java.io.IOException;

public interface Services {
    void addStudent();
    void deleteStudent();
    void updateStudent();
    void displayStudent();
    void borrowBook() throws IOException;

    void addBook();
    void deleteBook();
    void updateBook();
    void displayBook();
    void getStudentDetails();




}
