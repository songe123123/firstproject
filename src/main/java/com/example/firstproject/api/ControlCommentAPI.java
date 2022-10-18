package com.example.firstproject.api;


import com.example.firstproject.dto.commentbasicdto;
import com.example.firstproject.service.CommentbasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlCommentAPI {


    @Autowired
    public CommentbasicService commentbasicService;
    //댓글 보기

    @GetMapping("/api/basic/{main_article}")
    public ResponseEntity<List<commentbasicdto>> SeeAllcomments(@PathVariable Long main_article){
        List<commentbasicdto> SeeAllcomments = commentbasicService.SeeAllcomments(main_article);

                return ResponseEntity.status(HttpStatus.OK).body(SeeAllcomments);
    }

    @PostMapping("/api/basic/{main_article}")
    public ResponseEntity<commentbasicdto> postComment(@PathVariable Long main_article, @RequestBody commentbasicdto dto){
        commentbasicdto postComment = commentbasicService.postComment(main_article,dto);

        return ResponseEntity.status(HttpStatus.OK).body(postComment);
    }

    @PatchMapping  ("/api/basic/article/{id}")
    public ResponseEntity<commentbasicdto> patchComment(@PathVariable Long id,@RequestBody commentbasicdto dto){
        commentbasicdto patchComment = commentbasicService.patchComment(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(patchComment);
    }

    @DeleteMapping ("api/basic/article/{id}")
    public ResponseEntity<commentbasicdto> deleteComment(@PathVariable Long id){
        commentbasicdto delete = commentbasicService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(delete);


    }

}
