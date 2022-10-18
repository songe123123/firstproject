package com.example.firstproject.dto;

import com.example.firstproject.entity.Entitybasic;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString


public class DTO {


    private Long id;
    private String title;
    private String contents;


    public Entitybasic toEntity() {

        return new Entitybasic(id,title,contents);
    }
}
