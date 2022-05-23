package com.alkemy.disney.entity;

import javax.persistence.*;

@Entity
@Table(name="genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String image;


}
