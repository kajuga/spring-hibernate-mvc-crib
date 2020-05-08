package com.fedorov.hibernate.demo.hb_eager_vs_lazy_demo;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "hb_eager_vs_lazy_demo")
public class Course_EL {

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
    private Instructor_EL instructor;

    public Course_EL() {
    }

    public Course_EL(String title) {
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

    public Instructor_EL getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_EL instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '}';
    }
}
