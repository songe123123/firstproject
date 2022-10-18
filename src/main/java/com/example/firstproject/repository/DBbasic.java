package com.example.firstproject.repository;

import com.example.firstproject.entity.Entitybasic;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DBbasic extends CrudRepository<Entitybasic, Long> {
    @Override
    ArrayList<Entitybasic> findAll();
}
