package com.example.BorrowMicroservice.Entities;

import java.util.List;

public class BorrowDto {
    private Borrow borrow;
    private List<Book> bookIds;
    private Member memberId;

    public BorrowDto() {
    }

    public BorrowDto(Borrow borrow, List<Book> bookIds, Member memberId) {
        this.borrow = borrow;
        this.bookIds = bookIds;
        this.memberId = memberId;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public List<Book> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Book> bookIds) {
        this.bookIds = bookIds;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "BorrowDto{" +
                "borrow=" + borrow +
                ", bookIds=" + bookIds +
                ", memberId=" + memberId +
                '}';
    }
}
