package com.jpa.test;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "test_member")
@Table(name = "study_test")
public class Member {

    @Id
    @Column(name = "member_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo; // 회원번호

    @Column(name = "member_name", nullable = false)
    private String memberName; // 회원이름

    @Column(name = "nickname", length = 10, unique = true, nullable = false)
    private String nickName; // 회원 닉네임

    @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-0000;", nullable = false)
    private String phone; // 전화번호

    @Column(name = "zip_code", nullable = false)
    private int zipCode; // 우편번호

    @Column(name = "general_address", nullable = false)
    private String generalAddress; // 일반주소

    @Column(name = "detail_address", nullable = false)
    private String detailAddress; // 상세주소

    @Column(name = "member_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType memberRole; // 권한명

    @Column(name = "member_status", nullable = false)
    private String memberStatus; // 상태

    @Column(name = "enroll_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollDate; // 등록일

    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate; // 수정일

    @Column(name = "delete_date")
    @Temporal(TemporalType.DATE)
    private Date deleteDate; // 삭제일

    public Member() {
    }

    public Member(int memberNo, String memberName, String nickName, String phone, int zipCode, String generalAddress, String detailAddress, RoleType memberRole, String memberStatus, Date enrollDate, Date modifyDate, Date deleteDate) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.nickName = nickName;
        this.phone = phone;
        this.zipCode = zipCode;
        this.generalAddress = generalAddress;
        this.detailAddress = detailAddress;
        this.memberRole = memberRole;
        this.memberStatus = memberStatus;
        this.enrollDate = enrollDate;
        this.modifyDate = modifyDate;
        this.deleteDate = deleteDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getGeneralAddress() {
        return generalAddress;
    }

    public void setGeneralAddress(String generalAddress) {
        this.generalAddress = generalAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public RoleType getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(RoleType memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode=" + zipCode +
                ", generalAddress='" + generalAddress + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", memberRole=" + memberRole +
                ", memberStatus='" + memberStatus + '\'' +
                ", enrollDate=" + enrollDate +
                ", modifyDate=" + modifyDate +
                ", deleteDate=" + deleteDate +
                '}';
    }
}
