package com.fedorov.hibernate.hb_05_many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "hb_05_many_to_many")
public class Course_05 {

    //1. define our fields

    //2. define constructors

    //3. define getters setters

    //4. define toString

    //annotate  fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor_05 instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review_05> rewiews;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "hb_05_many_to_many.course_student",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student_05> students;


    public Course_05() {
    }

    public Course_05(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor_05 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_05 instructor) {
        this.instructor = instructor;
    }

    public List<Review_05> getRewiews() {
        return rewiews;
    }

    public void setRewiews(List<Review_05> rewiews) {
        this.rewiews = rewiews;
    }

    public void addReview(Review_05 tempReview) {
        if (rewiews == null) {
            rewiews = new ArrayList<Review_05>();
        }
        rewiews.add(tempReview);
    }

    public List<Student_05> getStudents() {
        return students;
    }

    public void setStudents(List<Student_05> students) {
        this.students = students;
    }


    public void addStudent (Student_05 theStudent) {
        if (students == null) {
            students = new ArrayList<Student_05>();
        }
        students.add(theStudent);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '}';
    }
}
