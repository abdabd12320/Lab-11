package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments()
    {
        return commentRepository.findAll();
    }
    public void addComment(Comment comment)
    {
        commentRepository.save(comment);
    }
    public void updateComment(Integer id,Comment comment)
    {
        Comment c = commentRepository.findCommentById(id);

        if(c == null)
        {
            throw new ApiException("It is null");
        }

        c.setContent(comment.getContent());
        c.setCommentDate(comment.getCommentDate());
        c.setUserID(comment.getUserID());
        c.setPostID(comment.getPostID());
    }
    public void deleteComment(Integer id)
    {
        Comment c = commentRepository.findCommentById(id);

        if(c == null)
        {
            throw new ApiException("It is null");
        }

        commentRepository.deleteById(id);
    }
    public List<Comment> getByUserIDAndPostID(Integer userID,Integer postID)
    {
        if(commentRepository.findCommentByUserIDAndPostID(userID, postID) == null)
        {
            throw new ApiException("It is null");
        }
        return commentRepository.findCommentByUserIDAndPostID(userID, postID);
    }
    public String findCountComment()
    {
        if(commentRepository.findCountComment() == 0)
        {
            throw new ApiException("Count = 0");
        }
        return "Count of comment = " + commentRepository.findCountComment();
    }
}
