package com.social.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long ID;

    @Column(unique = true, nullable = false)
    private String title;

    @Column( nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;

}
