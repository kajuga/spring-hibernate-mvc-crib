package com.fedorov.hibernate.demo.entities.one_to_one_bi;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail", schema = "hb_01_one_to_one_bi")
public class InstructorDetail_02 {

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
    private Instructor_02 instructor02;




    public InstructorDetail_02() {
    }

    public InstructorDetail_02(String youtubeChannel, String hobby) {
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

    public Instructor_02 getInstructor02() {
        return instructor02;
    }

    public void setInstructor02(Instructor_02 instructor02) {
        this.instructor02 = instructor02;
    }

    @Override
    public String toString() {
        return "InstructorDetail_02{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
