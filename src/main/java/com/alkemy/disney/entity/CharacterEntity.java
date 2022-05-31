package com.alkemy.disney.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="characters")
@Getter @Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
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
    
    @Column
    private boolean deleted;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    private Set<MovieEntity> movies = new HashSet<>();
    
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
