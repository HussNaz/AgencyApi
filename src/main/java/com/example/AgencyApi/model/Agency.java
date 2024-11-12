package com.example.AgencyApi.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Agency {

    @NotBlank(message = "ID can not be blank")
    private String id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Code can not be blank")
    private String code;

    private String description;

    private String descriptionBdd;


}