package com.fedorov.hibernate.hb_04_one_to_many_uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor", schema = "hb_04_one_to_many_uni")
public class Instructor_04 {

    //annotate the class an entities and map to db tables
    //define the fields
    //annotate the fields with db column names
    // *** setup relationship between instructor and  intsructor detail
    //create constructors
    //generate getter/setter methods
    //generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail_04 instructorDetail;

    @OneToMany (fetch = FetchType.LAZY,
                mappedBy = "instructor",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course_04> courses;



    public Instructor_04() {
    }

    public Instructor_04(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail_04 getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail_04 instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course_04> getCourses() {
        return courses;
    }

    public void setCourses(List<Course_04> courses) {
        this.courses = courses;
    }

    //add convenience method for bi-directional relationship
    public void add (Course_04 tempCourse) {
        if(courses == null) {
            courses = new ArrayList<Course_04>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}


















