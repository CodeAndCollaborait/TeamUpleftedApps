package com.user.api.model;

import javax.persistence.*;

@Entity
//@Table(name="personList")
public class personList {


    @Id
    private long id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column (unique = true, nullable = false)
    private String username;
    @Column (unique = true, nullable = false)
    private String email;
    @Column
    private String phone;
    @Column
    private String website;
    @Column (length = 5)
    private long  zipCode;

    public personList() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public long getZipCode() {
        return zipCode;
    }
    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
