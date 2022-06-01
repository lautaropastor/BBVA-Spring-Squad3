package com.alkemy.disney.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    private Long id;
    @NotBlank(message = "must be completed")
    private String name;
    private String image;

}
