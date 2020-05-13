package com.fedorov.hibernate.hb_03_one_to_many;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "hb_03_one_to_many")
public class Course {

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
    private Instructor_03 instructor;

    public Course() {
    }

    public Course(String title) {
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

    public Instructor_03 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_03 instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '}';
    }
}
