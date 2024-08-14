package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findCommentById(Integer id);

    List<Comment> findCommentByUserIDAndPostID(Integer userID, Integer postID);

    @Query("SELECT COUNT(c.id) FROM Comment c")
    Integer findCountComment();
}
