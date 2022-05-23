package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, imgUrl;

    @ManyToOne
    @JoinColumn(name="CONTENT_TYPE_ID", nullable=true)
    protected Content content;

    protected Genre() {}

}