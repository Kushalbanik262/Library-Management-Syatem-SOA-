package com.example.BorrowMicroservice.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Borrow {
    @Id
    private int id;
    private String dateTime;

    private List<Integer> bookIds;

    private Integer memberId;

    private String Status;

    private String startDate;

    private String endDate;

    public Borrow() {
    }

    public Borrow(int id, String dateTime, List<Integer> bookIds, Integer memberId, String status) {
        this.id = id;
        this.dateTime = dateTime;
        this.bookIds = bookIds;
        this.memberId = memberId;
        Status = status;
    }


    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", bookIds=" + bookIds +
                ", memberId=" + memberId +
                ", Status='" + Status + '\'' +
                '}';
    }
}