package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title, type;
    protected short rate;
    @OneToMany(mappedBy = "film",
        cascade = CascadeType.DETACH)
    protected List<Genre> genres;

    @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(
            name = "film_personage",
            joinColumns = {@JoinColumn(name="personage_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )
    protected Set<Personage> personages;
    protected Film() {}

    public Film(Long id, String title, String type, short rate, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.rate = rate;
        this.genres = genres;
    }

    public Film(String title, String type, short rate, List<Genre> genres) {
        this.title = title;
        this.type = type;
        this.rate = rate;
        this.genres = genres;
    }
}