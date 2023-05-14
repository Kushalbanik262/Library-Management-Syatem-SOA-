package com.example.CrudMicroservice.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admin {
    @Id
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Member> memebers;
    private String salary;
    private String contact;


    public Admin() {
    }

    public Admin(int id, String name, List<Book> books, List<Member> members, String salary, String contact) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.memebers = members;
        this.salary = salary;
        this.contact = contact;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getUsers() {
        return memebers;
    }

    public void setUsers(List<Member> users) {
        this.memebers = users;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
//                ", users=" + users +
                ", salary='" + salary + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
