package com.example.firstproject.api;


import com.example.firstproject.dto.DTO;
import com.example.firstproject.entity.Entitybasic;
import com.example.firstproject.repository.DBbasic;
import com.example.firstproject.service.controlSERVICE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j

public class conrtolAPI {

    @Autowired
    private DBbasic dbbasic;
    @Autowired
    private controlSERVICE controlsevice;


    @GetMapping("/api/control")
    public ArrayList<Entitybasic> getALL(){
               return controlsevice.getALL();
    };

    @GetMapping("/api/control/{id}")
    public Entitybasic getBYID(@PathVariable Long id){
        return controlsevice.getBYID(id);
        };

    @PostMapping("/api/control")
    public ResponseEntity<Entitybasic> POST(@RequestBody DTO form){
        Entitybasic POST1 = controlsevice.POST(form);
        return (POST1!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(POST1) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @PatchMapping("/api/control/{id}")
    public ResponseEntity<Entitybasic> PATCH(@PathVariable Long id,@RequestBody DTO form){
        Entitybasic PATCH0 = controlsevice.PATCH(id,form);
        return (PATCH0!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(PATCH0):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    @DeleteMapping("/api/control/{id}")
    public ResponseEntity<Entitybasic> DELETE(@PathVariable Long id){
        Entitybasic DELETE0 = controlsevice.DELETE(id);
        return (DELETE0!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(null):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }




    };



