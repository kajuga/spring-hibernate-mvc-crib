package com.fedorov.hibernate.demo.entities.one_to_many_uni;

import com.fedorov.hibernate.demo.entities.one_to_many.Instructor_03;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "hb_04_one_to_many_uni")
public class Course_04 {

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
    private Instructor_04 instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> rewiews;

    public Course_04() {
    }

    public Course_04(String title) {
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

    public Instructor_04 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_04 instructor) {
        this.instructor = instructor;
    }

    public List<Review> getRewiews() {
        return rewiews;
    }

    public void setRewiews(List<Review> rewiews) {
        this.rewiews = rewiews;
    }

    public void addReview(Review tempReview) {
        if (rewiews == null) {
            rewiews = new ArrayList<Review>();
        }
        rewiews.add(tempReview);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '}';
    }
}
