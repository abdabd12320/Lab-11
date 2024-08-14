package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findCategoryById(Integer id);

    List<Category> findCategoryByName(String name);

    @Query("SELECT c FROM Category c ORDER BY c.name ASC")
    List<Category> orderNameAsc();
}
