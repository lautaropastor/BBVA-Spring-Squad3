package com.alkemy.disney.entity;

import javax.persistence.*;
import java.util.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "movies")
@Getter @Setter
@NoArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String title;
    @Column
    private String image;
    @Column (nullable = false, name = "realesed_date")
    private Date realasedDate;
    @Column (nullable = false)
    private Integer calification;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinTable(
            name="movies_characters",
            joinColumns = {@JoinColumn(name="movie_id")},
            inverseJoinColumns = {@JoinColumn(name="character_id")}
    )
    private Set<CharacterEntity> characters = new HashSet<>();

    public MovieEntity(String title, String image, Date realasedDate, Integer calification, GenreEntity genre, Set<CharacterEntity> characters) {
        this.title = title;
        this.image = image;
        this.realasedDate = realasedDate;
        this.calification = calification;
        this.genre = genre;
        this.characters = characters;
    }
    
    public void addCharacter (CharacterEntity character) {
        characters.add(character);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", realasedDate=" + realasedDate +
                ", calification=" + calification +
                ", genre=" + genre +
                ", characters=" + characters +
                '}';
    }
}
