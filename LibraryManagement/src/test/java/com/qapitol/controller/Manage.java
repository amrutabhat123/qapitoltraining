package com.qapitol.controller;

import com.qapitol.module.Books;
import com.qapitol.module.Student;
import com.qapitol.service.ServiceImpliment;

import java.awt.print.Book;
import java.io.IOException;
import java.util.Scanner;

public class Manage {
    public static void main(String[] args) throws IOException {


        int userChoice;
        do {
            System.out.println("enter the choice");
            System.out.println("student");
            System.out.println("Book");
            Scanner sc = new Scanner(System.in);
            userChoice = sc.nextInt();
            ServiceImpliment si = new ServiceImpliment();
            int choice;

            switch (userChoice) {
                case 1:
                    do {
                        System.out.println("enetr your choice");
                        System.out.println("1:adding student");
                        System.out.println("2:deleting student");
                        System.out.println("3:upadating student");
                        System.out.println("4:displaying student");
                        System.out.println("5:borrow book");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                si.addStudent();
                                break;
                            case 2:
                                si.deleteStudent();
                                break;
                            case 3:
                                si.updateStudent();
                                break;
                            case 4:
                                si.displayStudent();
                                break;
                            case 5:
                                si.borrowBook();
                                break;
                            default:
                                System.out.println("enter correct choice");

                        }
                    }while (choice!=5);
                    break;
                case 2:
                    do {
                        System.out.println("enetr choice");
                        System.out.println("adding book");
                        System.out.println("deleting book");
                        System.out.println("upadating book");
                        System.out.println("displaying book");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                si.addBook();
                                break;
                            case 2:
                                si.deleteBook();
                                break;
                            case 3:
                                si.updateBook();

                                break;
                            case 4:
                                si.displayBook();
                                break;
                            default:
                                System.out.println("enter correct choice");

                        }
                    }while (choice!=4);
                    break;

                default:
                    System.out.println("enter correct choice");


            }


        }while(userChoice!=2);


    }
}
