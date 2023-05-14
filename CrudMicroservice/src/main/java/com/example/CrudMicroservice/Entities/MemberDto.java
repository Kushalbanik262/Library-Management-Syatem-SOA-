package com.example.CrudMicroservice.Entities;

public class MemberDto {
    private Member member;
    private int adminId;

    public MemberDto() {
    }

    public MemberDto(Member member, int adminId) {
        this.member = member;
        this.adminId = adminId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "member=" + member +
                ", adminId=" + adminId +
                '}';
    }
}
