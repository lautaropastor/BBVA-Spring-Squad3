package com.alkemy.disney.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterFullDTO implements Serializable {
    private Long id;
    private String image;
    private String name;
    private String history;
    private Integer age;
    private Double weight;
    private Set<MovieEntity> movies;

    public CharacterFullDTO(){
        movies = new HashSet<>();
    }

    @Override
    public String toString() {
        return "CharacterFullDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", history='" + history + '\'' +
                ", movies=" + movies +
                '}';
    }
}
