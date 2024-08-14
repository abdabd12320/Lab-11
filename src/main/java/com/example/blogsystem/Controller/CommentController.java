package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getComments()
    {
        return ResponseEntity.status(200).body(commentService.getComments());
    }
    @PostMapping("/add")
    public ResponseEntity addComment(@Valid@RequestBody Comment comment, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body("Comment added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@Valid@RequestBody Comment comment, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body("Comment updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id)
    {
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("Comment deleted");
    }
    @GetMapping("/get-by-userid-and-postid/{userid}/{postid}")
    public ResponseEntity getByUserIDAndPostID(@PathVariable Integer userid,@PathVariable Integer postid)
    {
        return ResponseEntity.status(200).body(commentService.getByUserIDAndPostID(userid, postid));
    }
    @GetMapping("/get-count-comment")
    public ResponseEntity findCountComment()
    {
        return ResponseEntity.status(200).body(new ApiResponse(commentService.findCountComment()));
    }
}
