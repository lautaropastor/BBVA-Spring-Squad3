package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, imgUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="FILM_ID", nullable=true)
    protected Film film;

    protected Genre() {}

}