package com.example.lab5_q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor

public class Event {


@NotEmpty(message = "ID should be not empty")
@Size(min = 2 , message = "ID should be more than 2")
    private String ID ;


@NotEmpty(message = "description should be not empty")
@Size(min = 15 , message = "description should be more than 15")
    private String description ;


@NotNull(message = "capacity should be not empty")
@Min(value = 25 , message = "too short")
    private Integer capacity;


//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private int startDate;
//
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    LocalDate endTime ;


}
