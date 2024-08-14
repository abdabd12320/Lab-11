package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostById(Integer id);

    List<Post> findPostByTitle(String title);

    @Query("select COUNT(p.id) FROM Post p WHERE p.userID = ?1 AND p.categoryID = ?2")
    Integer findCountPostsByUserIDAndCategoryID(Integer userID, Integer categoryID);
}
