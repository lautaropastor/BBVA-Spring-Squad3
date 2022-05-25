package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, imgUrl;

    @OneToMany(mappedBy="genre",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name="FILM_ID", nullable=true)
    protected Set<Film> films;

    protected Genre() {}

    protected Genre(long id, String name, String imgUrl){
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Genre(Long id, String name, String imgUrl, Set<Film> films) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.films = films;
    }
}