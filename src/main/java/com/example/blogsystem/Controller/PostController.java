package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getPosts()
    {
        return ResponseEntity.status(200).body(postService.getPosts());
    }
    @PostMapping("/add")
    public ResponseEntity addPost(@Valid@RequestBody Post post, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body("Post added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@Valid@RequestBody Post post, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("Post updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id)
    {
        postService.deletePost(id);
        return ResponseEntity.status(200).body("Post deleted");
    }
    @GetMapping("/get-by-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title)
    {
        return ResponseEntity.status(200).body(postService.getByTitle(title));
    }
    @GetMapping("/get-count-by-userid-and-categoryid/{userid}/{categoryid}")
    public ResponseEntity getCountByUserIDAndCategoryID(@PathVariable Integer userid,@PathVariable Integer categoryid)
    {
        return ResponseEntity.status(200).body(new ApiResponse(postService.countByUserIDAndCategoryID(userid, categoryid)));
    }
}
