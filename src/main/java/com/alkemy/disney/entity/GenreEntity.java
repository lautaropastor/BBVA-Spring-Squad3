package com.alkemy.disney.entity;

import javax.persistence.*;

@Entity
@Table(name="genders")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String image;

    //@OneToMany(mappedBy = "gener_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private List<MovieEntity> movies;

}
