package com.qapitol.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qapitol.module.Books;
import com.qapitol.module.Student;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ServiceImpliment implements Services {
    Scanner sc=new Scanner(System.in);

    Books b=new Books();
    List<Student > st=new ArrayList<>();
    List<Books> bt=new ArrayList<>();
    List<Books> borrowBook=new ArrayList<>();
    Student s;
    @Override
    public void addStudent() {
        s=new Student();
        System.out.println("enter a student id");
        int id = sc.nextInt();
        System.out.println("enter a student name");
        String name = sc.next();
        System.out.println("enter a student age");
        int age = sc.nextInt();
        System.out.println("enter a student address");
        String address = sc.next();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        st.add(s);

        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");
        ObjectMapper om=new ObjectMapper();
        List<Student> lst;
        try {
            lst=om.readValue(file, new TypeReference<List<Student>>() {

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lst.add(s);
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file,lst);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteStudent() {
        System.out.println("enter id to delete");
        int studentId = sc.nextInt();
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");
        boolean found=false;
        ObjectMapper omdel=new ObjectMapper();
        try {
            st = omdel.readValue(file, omdel.getTypeFactory().constructCollectionType(List.class, Student.class));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Iterator<Student> it = st.iterator();

        while(it.hasNext()){
            Student studentDetails = it.next();
            if(studentDetails.getId()==studentId) {
                it.remove();
                found=true;
                System.out.println("removed successfully");
                break;

            }


        }


     if(!found){
         System.out.println("id not found");
     }

        try {

            omdel.writerWithDefaultPrettyPrinter().writeValue(file,st);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateStudent() {

       // boolean found=false;
        System.out.println("enter id to update");
        int studentId = sc.nextInt();
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");
        boolean found=false;
        ObjectMapper omdel=new ObjectMapper();
        try {
            st = omdel.readValue(file, omdel.getTypeFactory().constructCollectionType(List.class, Student.class));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }


        for(Student student:st){
            if(student.getId()==studentId){
                System.out.println("Which field do you want to update?");
                System.out.println("1: Name");
                System.out.println("2: Age");
                System.out.println("3: Address");
                int editChoice=sc.nextInt();
                switch (editChoice){
                    case 1:
                        student.setName(sc.next());
                        break;

                    case 2:
                        student.setAge(sc.nextInt());
                    break;
                    case 3:
                        student.setAddress(sc.next());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;


                }

                System.out.println("student updated successfully");
                found=true;
                break;


            }
        }

     if(!found){
         System.out.println("id not found");
     }
     else{
         try {

             omdel.writerWithDefaultPrettyPrinter().writeValue(file,st);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

    }

    @Override
    public void displayStudent() {
    // s.toString(); //  System.out.println("id"+s.getId()+"name"+s.getName()+"age"+s.getAge()+"Address"+s.getAddress());
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");
        System.out.println("student details are");
        ObjectMapper displaystu=new ObjectMapper();
        List<Student> studentlst;
        try {
            studentlst = displaystu.readValue(file, displaystu.getTypeFactory().constructCollectionType(List.class, Student.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Student student : studentlst) {
            System.out.println(student);
        }

    }


    @Override
    public void borrowBook() throws IOException {
      //  b=new Books();
        ObjectMapper om=new ObjectMapper();
        File file1=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");
        List<Student> slist=om.readValue(file1, new TypeReference<List<Student>>(){});
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\book.json");

        List<Books> blst;
        try {
            blst=om.readValue(file, new TypeReference<List<Books>>() {

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("enter the student id");
        int studentid=sc.nextInt();
        Student studentDetails = getStudentId(studentid);
        System.out.println(studentDetails);
        System.out.println("books available are");
        displayBook();
        System.out.println("enter the book title");
        String bookName=sc.next();

        Books bookDetails = getBookName(bookName);
        System.out.println(bookDetails);
        System.out.println("if you want to buy: yes/no-- press 1 for yes and 2 for no");
        int userch = sc.nextInt();
        /*List<Student> list = new ArrayList<>();
        list.add(studentDetails);*/
        //System.out.println(list);
        if(userch==1){
            b.setStudentDetails(slist);
            System.out.println(b.getStudentDetails());
            blst.add(b);
            System.out.println("borrowed successfully");


        }
       else if(userch==2){
            displayBook();
        }
       else{
           System.out.println("enter correct choice");
        }

        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file,blst);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




















    }


public Student getStudentId(int studentid){

    List<Student> stuDetails ;
    ObjectMapper studetails=new ObjectMapper();
    File files=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\student.json");

    try {
        stuDetails=studetails.readValue(files, studetails.getTypeFactory().constructCollectionType(List.class, Student.class));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    for (Student student : stuDetails) {
        if (student.getId() == studentid) {
            return student;
        }
    }
    return null;  // Return null if student not found
}


    public Books getBookName(String bookname){


        List<Books> bookdetails;
        ObjectMapper bookstu=new ObjectMapper();
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\Book.json");

        try {
            bookdetails=bookstu.readValue(file, bookstu.getTypeFactory().constructCollectionType(List.class, Books.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        for (Books books:bookdetails) {
            if (Objects.equals(books.getName(), bookname)) {
                System.out.println(books.getName());
                return books;
            }
        }
        return null;
    }












    @Override
    public void addBook() {
        b=new Books();
        System.out.println("enter a book id");
        int id = sc.nextInt();
        System.out.println("enter a book name");
        String name = sc.next();
        System.out.println("enter a book author");
        String  author= sc.next();
        b.setId(id);
        b.setName(name);
        b.setAuthor(author);
       // b.setStudentDetails(st);
        bt.add(b);
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\book.json");
        ObjectMapper om=new ObjectMapper();
        List<Books> blst;
        try {
            blst=om.readValue(file, new TypeReference<List<Books>>() {

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        blst.add(b);
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file,blst);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void deleteBook() {
        System.out.println("enter id to delete");
        int bookid = sc.nextInt();
        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\book.json");
        boolean found=false;
        ObjectMapper omdel=new ObjectMapper();
        try {
            bt  = omdel.readValue(file, omdel.getTypeFactory().constructCollectionType(List.class, Books.class));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Iterator<Books> it = bt.iterator();

        while(it.hasNext()){
            Books bookDetails = it.next();
            if(bookDetails.getId()==bookid) {
                it.remove();
                found=true;
                System.out.println("removed successfully");
                break;

            }


        }


        if(!found){
            System.out.println("id not found");
        }

        try {

            omdel.writerWithDefaultPrettyPrinter().writeValue(file,bt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void updateBook() {


    }

    @Override
    public void displayBook() {

        File file=new File("C:\\Users\\Qapitol QA\\IdeaProjects\\LibraryManagement\\src\\test\\java\\com\\qapitol\\util\\book.json");
        System.out.println("book details are");
        ObjectMapper displayBook=new ObjectMapper();
        List<Books> bookdetails;
        try {
            bookdetails = displayBook.readValue(file, displayBook.getTypeFactory().constructCollectionType(List.class, Books.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Books book : bookdetails) {
            System.out.println(book);
        }





    }

    @Override
    public void getStudentDetails() {

    }
}
