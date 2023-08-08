package com.jpa.test2;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student")
@Table(name = "study_student")
public class Student {

    @Id
    @Column(name = "student_num", nullable = false)
    private int studentNum; // 학생번호

    @Column(name = "student_name", nullable = false)
    private String studentName; // 학생명

    @Column(name = "phone", nullable = false, columnDefinition = "default '010-0000-0000'")
    private int phone; // 전화번호

    @Column(name = "address", nullable = false)
    private String address; // 주소

    @OneToMany(mappedBy = "studentNum")
    private List<Student> studentList;

    public Student() {
    }

    public Student(int studentNum, String studentName, int phone, String address, List<Student> studentList) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.phone = phone;
        this.address = address;
        this.studentList = studentList;
    }
    /* 빌터패턴 사용*/
    public Student studentNum(int studentNum) {
        this.studentNum = studentNum;
        return this;
    }
    public Student studentName(String studentName){
        this.studentName = studentName;
        return this;
    }

    public Student phone(int phone) {
        this.phone = phone;
        return this;
    }

    public Student(String address) {
        this.address = address;
    }

    public Student builder(){
        return new Student(studentNum, studentName, phone, address, studentList);
    }

    /* getter, setter */
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", studentName='" + studentName + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
