package com.alkemy.disney.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="genres")
@Getter @Setter
@NoArgsConstructor
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private String image;

    private boolean deleted = false;

// Comentado hasta que le demos un uso - evita recursividad
//    @OneToMany(mappedBy = "genre")
//    private List<MovieEntity> movies;

    public GenreEntity(String name, String image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
