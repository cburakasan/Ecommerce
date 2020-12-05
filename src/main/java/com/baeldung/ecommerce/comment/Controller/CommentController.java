package com.baeldung.ecommerce.comment.Controller;

import com.baeldung.ecommerce.comment.Dto.CommentRequestDto;
import com.baeldung.ecommerce.comment.Dto.CommentResponseDto;
import com.baeldung.ecommerce.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/ekle")
    public CommentResponseDto commentEkle(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.yorumEkle(commentRequestDto);
    }
}
