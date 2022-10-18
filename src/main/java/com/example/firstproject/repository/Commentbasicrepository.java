package com.example.firstproject.repository;

import com.example.firstproject.entity.Commentbasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Commentbasicrepository extends JpaRepository<Commentbasic,Long> {

    @Query(value = "SELECT * FROM Commentbasic WHERE MAIN_ARTICLE =:main_article", nativeQuery = true)
    List<Commentbasic> commentbymainarticle(Long main_article);

    @Query(value="SELECT * FROM Commentbasic WHERE nickname =:nickname",nativeQuery = true)
    List<Commentbasic> commentbynickname(Long nickname);





}
