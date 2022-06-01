package com.alkemy.disney.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public final class MovieSimpleDTO {
    private Long id;
    private String title;
    private String image;
    private Date realasedDate;    
}
