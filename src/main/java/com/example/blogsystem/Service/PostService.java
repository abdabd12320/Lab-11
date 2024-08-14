package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts()
    {
        return postRepository.findAll();
    }
    public void addPost(Post post)
    {
        postRepository.save(post);
    }
    public void updatePost(Integer id,Post post)
    {
        Post p = postRepository.findPostById(id);

        if(p == null)
        {
            throw new ApiException("It is null");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setPublish_date(post.getPublish_date());
        p.setUserID(post.getUserID());
        p.setCategoryID(post.getCategoryID());
        postRepository.save(p);
    }
    public void deletePost(Integer id)
    {
        Post p = postRepository.findPostById(id);

        if(p == null)
        {
            throw new ApiException("It is null");
        }
        postRepository.deleteById(id);
    }
    public List<Post> getByTitle(String title)
    {
        if(postRepository.findPostByTitle(title) == null)
        {
            throw new ApiException("Title is null");
        }
        return postRepository.findPostByTitle(title);
    }
    public String countByUserIDAndCategoryID(Integer userID, Integer categoryID)
    {
        if(postRepository.findCountPostsByUserIDAndCategoryID(userID, categoryID) == 0)
        {
            throw new ApiException("Count = 0");
        }
        return "Count posts by UserID and CategoryID = " + postRepository.findCountPostsByUserIDAndCategoryID(userID, categoryID);
    }
}
