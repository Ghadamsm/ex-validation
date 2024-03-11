package com.example.lab5_q2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {


    @NotEmpty(message = "ID should be not empty")
    @Size(min = 2 , message = "ID should be more than 2")
    private String ID ;

    @NotEmpty(message = "Title should be not empty")
    @Size(min = 8 , message = "Title should be more than 8")
    private String Title ;


    @NotEmpty(message = "description should be not empty")
    @Size(min = 15 , message = "description should be more than 15")
    private String description ;


    @NotEmpty(message = "status should be not empty")
    @Pattern(regexp = "^(Not Started|In Progress|Completed)$", message = "Not Started, In Progress, or Completed")
    private String status ;


    @NotEmpty(message = "Company Name should be not empty")
    @Size(min = 6 , message = "Company Name should be more than 6")
    private String companyName ;

}



