package com.baeldung.ecommerce.comment.Repository;

import com.baeldung.ecommerce.User.Model.User;
import com.baeldung.ecommerce.comment.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
