package com.teikaiz.example;

import com.teikaiz.mapping.FieldMapping;

public class CatDTO {
    @FieldMapping(name = "name")
    private String nameDto;
    @FieldMapping(ignore = true)
    private String color;
    private String bell;

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBell() {
        return bell;
    }

    public void setBell(String bell) {
        this.bell = bell;
    }

    @Override
    public String toString() {
        return "CatDTO{" +
                "nameDto='" + nameDto + '\'' +
                ", color='" + color + '\'' +
                ", bell='" + bell + '\'' +
                '}';
    }
}
