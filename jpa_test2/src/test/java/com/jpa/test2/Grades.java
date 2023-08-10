package com.jpa.test2;

import javax.persistence.*;

@Entity(name = "grades")
@Table(name = "study_grades")
public class Grades {

    @EmbeddedId // gradesPK 매핑
    private GradesMapping gradesMapping;

    @JoinColumn(name = "course_num")
    @ManyToOne
    private Course courseNum; // 과목번호

    @JoinColumn(name = "student_num")
    @ManyToOne
    private Student studentNum; // 학생번호

    @Column(name = "semester", nullable = false)
    private String semester; // 학기

    @Column(name = "score", nullable = false)
    private int score; // 과목점수

    public Grades() {
    }

    public Grades(GradesMapping gradesMapping, Course courseNum, Student studentNum, String semester, int score) {
        this.gradesMapping = gradesMapping;
        this.courseNum = courseNum;
        this.studentNum = studentNum;
        this.semester = semester;
        this.score = score;
    }

    /* 빌더패턴 사용*/
    public Grades semester(String semester) {
        this.semester = semester;
        return this;
    }

    public Grades score(int score) {
        this.score = score;
        return this;
    }

    public Grades builder() {
        return new Grades(gradesMapping, courseNum, studentNum, semester, score);
    }

    /* getter, setter */
    public GradesMapping getGradesMapping() {
        return gradesMapping;
    }

    public void setGradesMapping(GradesMapping gradesMapping) {
        this.gradesMapping = gradesMapping;
    }

    public Course getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Course courseNum) {
        this.courseNum = courseNum;
    }

    public Student getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Student studentNum) {
        this.studentNum = studentNum;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "gradesMapping=" + gradesMapping +
                ", courseNum=" + courseNum +
                ", studentNum=" + studentNum +
                ", semester='" + semester + '\'' +
                ", score=" + score +
                '}';
    }
}
