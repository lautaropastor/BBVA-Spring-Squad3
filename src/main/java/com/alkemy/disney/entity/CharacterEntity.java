package com.alkemy.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="characters")
public class CharacterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    private String image;
    
    @Column(length=50, nullable=false, unique=true)
    private String name;
    
    @Column
    private Integer age;
    
    @Column(scale=3)
    private Double weight;
    
    @Column
    private String history;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<MovieEntity> movies;
    
    public CharacterEntity() {
        movies = new ArrayList<>();
    }
    
    public CharacterEntity(String name) {
        super();
        this.name = name;
    }
    
    public CharacterEntity(String name, String image, Integer age, Double weight, String history, List<MovieEntity> movies) {
        super();
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return this.history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<MovieEntity> getMovies() {
        return this.movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }  
    
    public void addMovie(MovieEntity newMovie) {   
        movies.add(newMovie);
    }
    
}
