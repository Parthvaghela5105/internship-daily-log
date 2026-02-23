package com.intern.jpqlquery.dto;

import lombok.Data;

@Data
public class StdDTO {
    private String name;
    private String address;

    public StdDTO(String name , String address){
        this.name = name;
        this.address = address;
    }
}
