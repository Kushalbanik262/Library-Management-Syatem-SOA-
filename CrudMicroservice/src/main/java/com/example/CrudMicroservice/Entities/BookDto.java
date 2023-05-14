package com.example.CrudMicroservice.Entities;

public class BookDto {
    private Book book;
    private int adminId;

    public BookDto() {
    }

    public BookDto(Book book, int adminId) {
        this.book = book;
        this.adminId = adminId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "book=" + book +
                ", adminId=" + adminId +
                '}';
    }
}
