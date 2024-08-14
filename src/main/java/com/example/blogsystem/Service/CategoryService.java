package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories()
    {
        return categoryRepository.findAll();
    }
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public void updateCategory(Integer id,Category category)
    {
        Category c = categoryRepository.findCategoryById(id);

        if(c == null)
        {
            throw new ApiException("It is null");
        }
        c.setName(category.getName());
        categoryRepository.save(c);
    }
    public void deleteCategory(Integer id)
    {
        Category c = categoryRepository.findCategoryById(id);

        if(c == null)
        {
            throw new ApiException("It is null");
        }
        categoryRepository.deleteById(id);
    }
    public List<Category> getByName(String name)
    {
        if(categoryRepository.findCategoryByName(name) == null)
        {
            throw new ApiException("Name is null");
        }
        return categoryRepository.findCategoryByName(name);
    }
    public List<Category> getNamesAsc()
    {
        return categoryRepository.orderNameAsc();
    }
}
