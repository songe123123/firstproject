package com.example.firstproject.dto;

import com.example.firstproject.entity.Commentbasic;
import com.example.firstproject.entity.Entitybasic;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Slf4j
@ToString

public class commentbasicdto {

    private Long id;

    @JsonProperty("main_article")
    private Long main_article;

    private String nickname;

    private String body;


    public static commentbasicdto EntitytoDtoComment(Commentbasic entity_comment) {

        return new commentbasicdto(
                entity_comment.getId(),
                entity_comment.getMain_article().getId(),
                entity_comment.getBody(),
                entity_comment.getNickname());

    }

    public Commentbasic toEntity(commentbasicdto dto, Entitybasic mainarticle) {

        if(id != null){
            throw new IllegalArgumentException("ID를 적지 마세요.");}

        if(mainarticle.getId() != main_article){
            throw new IllegalArgumentException("댓글의 게시글 ID가 잘못됐음");}

        if(nickname==null){throw new IllegalArgumentException("닉네임 혹은 내용이 없습니다");}




        return new Commentbasic(
        id,mainarticle,nickname,body
                                );
            }
    }

