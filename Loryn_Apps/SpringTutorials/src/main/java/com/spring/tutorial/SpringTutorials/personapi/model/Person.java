package com.spring.tutorial.SpringTutorials.personapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

    @Id
    private long id;

    @Column
    private String personName;

    @Column
    private String occupation;

    @Column
    private long age;

    @Column
    private Boolean siblings;

    @Column
    private String sign;


    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Boolean getSiblings() {
        return siblings;
    }

    public void setSiblings(Boolean siblings) {
        this.siblings = siblings;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", age=" + age +
                ", siblings=" + siblings +
                ", sign='" + sign + '\'' +
                '}';
    }
}
