package com.fedorov.hibernate.hb_02_one_to_one_bi;

import javax.persistence.*;

@Entity
@Table(name = "instructor", schema = "hb_02_one_to_one_bi")
public class Instructor_02 {

    //annotate the class an entities and map to db tables
    //define the fields
    //annotate the fields with db column names
    // *** setup relationship between instructor and  intructor detail
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
    private InstructorDetail_02 instructorDetail;



    public Instructor_02() {
    }

    public Instructor_02(String firstName, String lastName, String email) {
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

    public InstructorDetail_02 getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail_02 instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor_02{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
