package com.example.firstproject.service;


import com.example.firstproject.dto.commentbasicdto;
import com.example.firstproject.entity.Commentbasic;
import com.example.firstproject.entity.Entitybasic;
import com.example.firstproject.repository.Commentbasicrepository;
import com.example.firstproject.repository.DBbasic;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ToString
@Service
public class CommentbasicService {


    @Autowired
    public  Commentbasicrepository commentbasicrepository;
    @Autowired
    public DBbasic dbbasic;



    //댓글 조회
    public List<commentbasicdto> SeeAllcomments(Long main_article) {
//        List<Commentbasic> entity_comments = commentbasicrepository.commentbymainarticle(main_article);
//
//        List<commentbasicdto> dto_commentslist = new ArrayList<commentbasicdto>();
//
//        for(int i=0; i<entity_comments.size(); i++){
//            Commentbasic entity_comment = entity_comments.get(i);
//            commentbasicdto dto_comment = commentbasicdto.EntitytoDtoComment(entity_comment);
//
//            dto_commentslist.add(dto_comment);
//        }
         //스트림 메소드 활용
                return commentbasicrepository.commentbymainarticle(main_article)
                        .stream()
                        .map(commentbasic->commentbasicdto.EntitytoDtoComment(commentbasic))
                        //가져온것은 List<Commentbasic>이나 개별단위인 Commentbasic의 commentbasic를 받아옴.
                        .collect(Collectors.toList());


    }


    @Transactional
    //댓글 생성
    public commentbasicdto postComment(Long main_article,commentbasicdto dto) {
        //게시글이 없는 경우
        //if(main_article == null){throw new IllegalArgumentException("대상 게시글이 없습니다.");}->main_article는 그냥 변수
        Entitybasic entitybasic = dbbasic.findById(main_article).orElseThrow(()->new IllegalArgumentException("대상 게시글이 없습니다."));

        //기본 생성 메소드
        Commentbasic post1 = dto.toEntity(dto,entitybasic);//dto(입력값_nickname,body*id는 자동생성)과 entitybasic(게시글)변수로 가져와야함

        Commentbasic post2 = commentbasicrepository.save(post1);
        log.info(post2.toString());

        //dto변환
        return commentbasicdto.EntitytoDtoComment(post2);

   }

   @Transactional
    //댓글 수정
    public commentbasicdto patchComment(Long id, commentbasicdto dto) {
       Commentbasic patch1 = commentbasicrepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 댓글이 없습니다."));
       patch1.patch(dto);
       Commentbasic patch3 = commentbasicrepository.save(patch1);
       log.info(patch3.toString());

       //dto 변환
       return commentbasicdto.EntitytoDtoComment(patch3);

    }


    @Transactional
    //댓글 삭제
    public commentbasicdto delete(Long id) {
        Commentbasic delete1 = commentbasicrepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다"));
        commentbasicrepository.delete(delete1);
        //dto변환 삭제된 댓글도 변환을 하네?!
        return commentbasicdto.EntitytoDtoComment(delete1);
    }
}

