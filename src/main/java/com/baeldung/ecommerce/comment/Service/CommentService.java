package com.baeldung.ecommerce.comment.Service;

import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Repository.ProductsRepository;
import com.baeldung.ecommerce.User.Model.User;
import com.baeldung.ecommerce.User.Repository.UserRepositroy;
import com.baeldung.ecommerce.comment.Dto.*;
import com.baeldung.ecommerce.comment.Model.Comment;
import com.baeldung.ecommerce.comment.Repository.CommentRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j
public class CommentService {

    @Autowired
    ProductsRepository productRepository;

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    CommentRepository commentRepository;

    public CommentResponseDto yorumEkle(CommentRequestDto commentRequestDto) {
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        try {
            Long productId = commentRequestDto.getProductId();
            Long userId = commentRequestDto.getUserId();
            String yorum = commentRequestDto.getYorum();

            Optional<Product> productOptional = productRepository.findById(productId);
            Product product = productOptional.get();

            Optional<User> userOptional = userRepositroy.findById(userId);
            User user = userOptional.get();

            Comment comment = new Comment();
            comment.setProduct(product);
            comment.setUser(user);
            comment.setYorum(yorum);
            commentRepository.save(comment);

        }catch (Exception e){
            String message = e.getMessage();
            log.error(message+"Yorum ekleme isleminde bir hata olustu");
            commentResponseDto.setHataMesaji(message);
            return commentResponseDto;
        }

        commentResponseDto.setSuccsessMessage("Yorum ekleme islemi basarili");


        return commentResponseDto;
    }

}
