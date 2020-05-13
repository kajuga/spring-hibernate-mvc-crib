package com.fedorov.hibernate.hb_eager_vs_lazy_demo;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail", schema = "hb_eager_vs_lazy_demo")
public class InstructorDetail_EL {

    //annotate the class an entities and map to db tables

    //define the fields

    //annotate the fields with db column names

    //create constructors

    //generate getter/setter methods

    //generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    //add @OneToOne annotation
    //this delete all entities (Instructor and linked instructro Detail)
    //@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    //this - only instructorDetail
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor_EL instructor;




    public InstructorDetail_EL() {
    }

    public InstructorDetail_EL(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor_EL getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_EL instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
