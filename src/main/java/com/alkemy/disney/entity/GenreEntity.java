package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="genres")
@Getter @Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE genres SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private String image;
    @Column
    private boolean deleted;

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
