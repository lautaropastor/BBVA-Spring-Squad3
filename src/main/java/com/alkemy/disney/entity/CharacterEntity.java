package com.alkemy.disney.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="characters")
@Getter @Setter
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
    private Set<MovieEntity> movies;
    
    public CharacterEntity() {}
    
    public CharacterEntity(String name) {
        super();
        this.name = name;
    }
    
    public CharacterEntity(String name, String image, Integer age, Double weight, String history, Set<MovieEntity> movies) {
        super();
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }
    
    public void addMovie(MovieEntity newMovie) {   
        movies.add(newMovie);
    }
    
}
