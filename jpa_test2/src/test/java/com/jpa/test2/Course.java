package com.jpa.test2;

import javax.persistence.*;
import java.util.List;

@Entity(name = "course")
@Table(name = "study_course")
public class Course {

    @Id
    @Column(name = "course_num", nullable = false)
    private int courseNum; // 과목번호

    @Column(name = "course_name", nullable = false)
    private String courseName; // 과목명

    @OneToMany(mappedBy = "courseNum")
    private List<Grades> gradesList;

    public Course() {
    }

    public Course(int courseNum, String courseName, List<Grades> gradesList) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.gradesList = gradesList;
    }

    /* 빌터패턴 사용*/
    public Course courseNum(int courseNum) {
        this.courseNum = courseNum;
        return this;
    }

    public Course courseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public Course gradesList(List<Grades> gradesList) {
        this.gradesList = gradesList;
        return this;
    }

    public Course builder() {
        return new Course(courseNum, courseName, gradesList); // course 생성자 호출
    }

    /* getter, setter */
    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Grades> getGradesList() {
        return gradesList;
    }

    public void setGradesList(List<Grades> gradesList) {
        this.gradesList = gradesList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNum=" + courseNum +
                ", courseName='" + courseName + '\'' +
                ", gradesList=" + gradesList +
                '}';
    }
}
