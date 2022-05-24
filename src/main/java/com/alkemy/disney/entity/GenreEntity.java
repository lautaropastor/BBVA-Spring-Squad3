package com.alkemy.disney.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="genres")
@Getter @Setter
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<MovieEntity> movies;

    public GenreEntity() {
    }

    public GenreEntity(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", movies=" + movies +
                '}';
    }
}
