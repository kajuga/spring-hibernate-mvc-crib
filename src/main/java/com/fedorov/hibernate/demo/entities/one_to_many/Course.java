package com.fedorov.hibernate.demo.entities.one_to_many;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    //1. define our fields

    //2. define constructors

    //3. define getters setters

    //4. define toString

    //annotate  fields

    private int id;

    private String title;

    private Instructor_03 instructor;



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
