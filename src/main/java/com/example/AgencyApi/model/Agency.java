package com.example.AgencyApi.model;


import jakarta.validation.constraints.NotBlank;

public class Agency {

    @NotBlank(message = "ID can not be blank")
    private String id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Code can not be blank")
    private String code;

    private String description;

    private String descriptionBdd;

    public String getDescriptionBdd() {
        return descriptionBdd;
    }

    public void setDescriptionBdd(String descriptionBdd) {
        this.descriptionBdd = descriptionBdd;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}