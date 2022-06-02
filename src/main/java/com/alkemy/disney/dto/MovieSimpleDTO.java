package com.alkemy.disney.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public final class MovieSimpleDTO {
    private Long id;
    private String title;
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date realasedDate;    
}
