package com.example.firstproject.service;

import com.example.firstproject.dto.DTO;
import com.example.firstproject.entity.Entitybasic;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

class controlSERVICETest {
    @Autowired
    private controlSERVICE controlservice;



    @Test
    void POST() {
        //예상
        String title="aaaaa";
        String contents="111111";
        DTO dto = new DTO(null,title,contents);
        Entitybasic expected = new Entitybasic(1L,"aaaaa","111111");

        //실제
        Entitybasic real = controlservice.POST(dto);

        //비교
        assertEquals(expected.toString(),real.toString());

    }




    @Test
    void DELETE() {
        //예상
        Long id=1L;
        Entitybasic expected = new Entitybasic(1L,"aaaaa","111111");


        //실제
        Entitybasic real = controlservice.DELETE(id);

        //비교
        assertEquals(expected.toString(),real.toString());

    }
}