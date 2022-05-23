package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title, type;
    protected short rate;
    @OneToMany(mappedBy = "content")
    protected List<Genre> genres;

    protected Content() {}

    public Content(Long id, String title, String type, short rate, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.rate = rate;
        this.genres = genres;
    }

    public Content(String title, String type, short rate, List<Genre> genres) {
        this.title = title;
        this.type = type;
        this.rate = rate;
        this.genres = genres;
    }
}