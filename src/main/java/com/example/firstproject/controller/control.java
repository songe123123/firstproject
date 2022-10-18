package com.example.firstproject.controller;

import com.example.firstproject.dto.DTO;
import com.example.firstproject.dto.commentbasicdto;
import com.example.firstproject.entity.Commentbasic;
import com.example.firstproject.entity.Entitybasic;
import com.example.firstproject.repository.Commentbasicrepository;
import com.example.firstproject.repository.DBbasic;
import com.example.firstproject.service.CommentbasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j


public class control {

    @Autowired
    public DBbasic dbbasic;

    @Autowired
    public CommentbasicService commentbasicService;

    @GetMapping("/basicpage")
    public String basic() {
        return "articles/basic";

    }

    ;

    @PostMapping("basic/toDTO")
    public String DTOtoDB(DTO form) {


        Entitybasic DTOtoENTITY = form.toEntity();

        Entitybasic ENTITYtoDB = dbbasic.save(DTOtoENTITY);


        return "redirect:/basic/" + ENTITYtoDB.getId();
    }

    ;

    @GetMapping("basic/{id}")
    public String findbyID(@PathVariable Long id, Model model) {
        Entitybasic fromDB = dbbasic.findById(id).orElse(null);
        List<commentbasicdto> fromCommentDB = commentbasicService.SeeAllcomments(id);

        model.addAttribute("model", fromDB);
        model.addAttribute("comment",fromCommentDB);

        return "articles/findbyid";
    }

    ;


    @GetMapping("basic/findall")
    public String findall(Model model) {
        ArrayList<Entitybasic> formDB1 = dbbasic.findAll();

        model.addAttribute("model", formDB1);

        return "articles/findall";
    }

    ;

    @GetMapping("basic/{id}/edit")
    public String editpage(@PathVariable Long id, Model model) {
        Entitybasic fromDB = dbbasic.findById(id).orElse(null);

        model.addAttribute("model", fromDB);

        return "articles/edit2";
    }

    ;

    @PostMapping("/basic/editsend")
    public String editsend(DTO form, Long id) {
        Entitybasic NEWdtoTOentity = form.toEntity();

        Entitybasic DBexist = dbbasic.findById(NEWdtoTOentity.getId()).orElse(null);

        if (DBexist != null) {
            Entitybasic saveENTITY = dbbasic.save(NEWdtoTOentity);
        }

        return "redirect:/basic/" + NEWdtoTOentity.getId();
    }

    ;

    @GetMapping("/basic/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Entitybasic target = dbbasic.findById(id).orElse(null);

        if (target != null) {
            dbbasic.delete(target);
            rttr.addFlashAttribute("msg", "article delete success");

        }
        return "redirect:/basic/findall";
    }
}


