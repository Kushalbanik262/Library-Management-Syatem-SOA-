package com.example.CrudMicroservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String publisher;
    private String writer;

    private boolean isEngaged;

    public Book() {
    }

    public Book(int id, String name, String publisher, String writer, boolean isEngaged) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.writer = writer;
        this.isEngaged = isEngaged;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public boolean isEngaged() {
        return isEngaged;
    }

    public void setEngaged(boolean engaged) {
        isEngaged = engaged;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", writer='" + writer + '\'' +
                ", isEngaged=" + isEngaged +
                '}';
    }
}
