package com.alkemy.disney.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class GenreDTO {
    private Long id;
    @NotBlank(message = "must be completed")
    private String name;
    @NotBlank(message = "is required") @URL(message = "URL is not valid")
    @Pattern(regexp = ".*(png|jpg|jpeg|gif)$", message = "is not a valid format")
    private String image;

}
