package com.alkemy.disney.configs;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.repository.specifications.CharacterRepository;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.repository.specifications.MovieRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class config {

    @Bean
    CommandLineRunner commandLineRunner(MovieRespository movieR, GenreRepository genreR, CharacterRepository characterR) {
        return args -> {

            GenreEntity g1 = new GenreEntity(1L, "Accion", "imagen1");
            GenreEntity g2 = new GenreEntity(2L, "Terror", "imagen 2");
            GenreEntity g3 = new GenreEntity(3L, "Cartoon", "imagen 3");

            genreR.saveAll(List.of(g1,g2,g3));

            CharacterEntity c1 = new CharacterEntity("Superman",  "imagen superman", 40, 70.9, "history 1");
            CharacterEntity c2 = new CharacterEntity("Batman",  "imagen Batman", 10, 79.9, "history 2");
            CharacterEntity c3 = new CharacterEntity( "Joker","imagen Joker", 12, 60.0, "history 3");
            CharacterEntity c4 = new CharacterEntity("Reportero","imagen Reportero",  10, 67.1, "history 4");
            CharacterEntity c5 = new CharacterEntity( "cars","imagen cars", 20, 100.9, "history 5");
            CharacterEntity c6 = new CharacterEntity("Mate", "imagen Mate", 50, 150.10, "history 6");
            CharacterEntity c7 = new CharacterEntity("Woody", "imagen Woody",  110, 5.9, "history 7");
            CharacterEntity c8 = new CharacterEntity( "Buzz", "imagen Buzz", 130, 7.1, "history 8");
            CharacterEntity c9 = new CharacterEntity("Rex","imagen Rex",  90, 9.0, "history 9");

            characterR.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9));

            MovieEntity m1 = new MovieEntity(1001L, "Toy story", "imagen toy story",new Date(1999-07-10), 5, g3);
            MovieEntity m2 = new MovieEntity(1002L, "Batman", "imagen Batman", new Date(1980-10-20), 3, g2);
            MovieEntity m3 = new MovieEntity(1003L, "Cars", "imagen Cars", new Date(2001-02-23), 4, g3);
            MovieEntity m4 = new MovieEntity(1004L, "Superman", "imagen Superman", new Date(1950-01-05), 2, g1);

            movieR.saveAll(List.of(m1,m2,m3,m4));

            c1.addMovie(m4);
            c2.addMovie(m2);
            c2.addMovie(m4);
            c3.addMovie(m2);

            c1.setMovies(Arrays.asList(m4));
            c2.setMovies(Arrays.asList(m2,m4));
            c3.setMovies(Arrays.asList(m2));
            c4.setMovies(Arrays.asList(m2));
            c5.setMovies(Arrays.asList(m3));
            c6.setMovies(Arrays.asList(m3));
            c7.setMovies(Arrays.asList(m1));
            c8.setMovies(Arrays.asList(m1));
            c9.setMovies(Arrays.asList(m1));

            g1.setMovies(Arrays.asList(m4));
            g2.setMovies(Arrays.asList(m2));
            g3.setMovies(Arrays.asList(m1,m3));


        };
    }
}
