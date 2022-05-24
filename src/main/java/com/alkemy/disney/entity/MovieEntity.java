package com.alkemy.disney.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @Column (nullable = false)
    private String title;
    @Column
    private String image;
    @Column (nullable = false, name = "realesed_date")
    private Date realasedDate;
    @Column (nullable = false)
    private Integer calification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CharacterEntity> characters;

    public MovieEntity (){}

    public MovieEntity(Long movieId, String title, String image, Date realasedDate, Integer calification, GenreEntity genre, List<CharacterEntity> characters) {
        this.movieId = movieId;
        this.title = title;
        this.image = image;
        this.realasedDate = realasedDate;
        this.calification = calification;
        this.genre = genre;
        this.characters = characters;
    }

    public MovieEntity(String title, String image, Date realasedDate, Integer calification, GenreEntity genre, List<CharacterEntity> characters) {
        this.title = title;
        this.image = image;
        this.realasedDate = realasedDate;
        this.calification = calification;
        this.genre = genre;
        this.characters = characters;
    }

    public Long getMovieId() {
        return movieId;
    }
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Date getRealasedDate() {
        return realasedDate;
    }
    public void setRealasedDate(Date realasedDate) {
        this.realasedDate = realasedDate;
    }
    public Integer getCalification() {
        return calification;
    }
    public void setCalification(Integer calification) {
        this.calification = calification;
    }
    public GenreEntity getGenre() {
        return genre;
    }
    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
    public List<CharacterEntity> getCharacters() {
        return characters;
    }
    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }
    public void addCharacter (CharacterEntity character) {
        characters.add(character);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", realasedDate=" + realasedDate +
                ", calification=" + calification +
                ", genre=" + genre +
                ", characters=" + characters +
                '}';
    }
}
