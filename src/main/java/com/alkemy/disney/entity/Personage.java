package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, history;
    @Column(name = "img_url")
    protected String imgUrl;
    protected Short age, weight;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "film_personage",
            inverseJoinColumns = {@JoinColumn(name="personage_id")},
            joinColumns = {@JoinColumn(name = "film_id")}
    )
    protected Set<Film> films;
    protected Personage() {}

    public Personage(Long id, String name, String history, String imgUrl, Short age, Short weight, Set<Film> films) {
        this.id = id;
        this.name = name;
        this.history = history;
        this.imgUrl = imgUrl;
        this.age = age;
        this.weight = weight;
        this.films = films;
    }

    public Personage(String name, String history, String imgUrl, Short age, Short weight, Set<Film> films) {
        this.name = name;
        this.history = history;
        this.imgUrl = imgUrl;
        this.age = age;
        this.weight = weight;
        this.films = films;
    }
}