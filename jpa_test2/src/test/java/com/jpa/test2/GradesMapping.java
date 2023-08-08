package com.jpa.test2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradesMapping implements Serializable {

    @Column(name = "course_num")
    private int courseNum; // 과목번호

    @Column(name = "student_num")
    private int studentNum; // 학생번호

    public GradesMapping() {
    }

    public GradesMapping(int courseNum, int studentNum) {
        this.courseNum = courseNum;
        this.studentNum = studentNum;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "GradesMapping{" +
                "courseNum=" + courseNum +
                ", studentNum=" + studentNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradesMapping that = (GradesMapping) o;
        return courseNum == that.courseNum && studentNum == that.studentNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNum, studentNum);
    }
}
