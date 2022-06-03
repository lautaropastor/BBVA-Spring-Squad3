package com.alkemy.disney.dto;

import com.alkemy.disney.entity.GenreEntity;
import java.util.Date;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Setter @Getter
public class MovieWithoutCharactersDTO {
    private Long id;
            
    @NotBlank(message = "is required")
    private String title;
            
    @NotBlank(message = "is required") @URL(message = "URL is not valid")
    @Pattern(regexp = ".*(png|jpg|jpeg|gif)$", message = "is not a valid format")
    private String image;
    
    @NotNull(message = "is required") @Past(message = "is future") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @JsonFormat(pattern = "yyyy-MM-dd")
    private Date realasedDate;
    
    @NotNull(message = "is required") @Min(value = 1, message = "the minimum is 1") @Max(value = 5, message = "the maximum is 5")
    private Integer calification;
            
    @NotNull(message = "is required")
    private GenreDTO genre; 
    
}
