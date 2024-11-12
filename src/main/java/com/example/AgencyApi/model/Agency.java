package com.example.AgencyApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Agency {

    @NotBlank(message = "ID can not be blank")
    @ToString.Exclude
    private String id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Code can not be blank")
    private String code;

    private String description;

    private String descriptionBdd;

}