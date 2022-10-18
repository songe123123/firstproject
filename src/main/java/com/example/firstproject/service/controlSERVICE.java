package com.example.firstproject.service;

import com.example.firstproject.dto.DTO;
import com.example.firstproject.entity.Entitybasic;
import com.example.firstproject.repository.DBbasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service

public class controlSERVICE {
    @Autowired
    private DBbasic dbbasic;

    public ArrayList<Entitybasic> getALL(){return dbbasic.findAll();}

    public Entitybasic getBYID(@PathVariable Long id){return dbbasic.findById(id).orElse(null);}

    public Entitybasic POST(@RequestBody DTO dto) {
        Entitybasic P1 = dto.toEntity();
        if(P1==null){return null;};
        return dbbasic.save(P1);
    };



    public Entitybasic PATCH(@PathVariable Long id, @RequestBody DTO dto){
    Entitybasic PATCH0 = dto.toEntity();

    Entitybasic PATCH1 = dbbasic.findById(id).orElse(null);
        if(PATCH1==null){return null;}

        PATCH1.patch(PATCH0);
        return dbbasic.save(PATCH0);}


    public Entitybasic DELETE(@PathVariable Long id){
        Entitybasic DELETE0 = dbbasic.findById(id).orElse(null);
        if(DELETE0==null){return null;}
        dbbasic.delete(DELETE0);
        return DELETE0;}




}
