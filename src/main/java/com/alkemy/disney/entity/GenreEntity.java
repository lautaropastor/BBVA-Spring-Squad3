package com.alkemy.disney.entity;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieEntity> movies;



}
