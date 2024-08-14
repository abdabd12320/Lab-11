package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategories()
    {
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid@RequestBody Category category, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@Valid@RequestBody Category category, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body("Category updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body("Category deleted");
    }
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity getByName(@PathVariable String name)
    {
        return ResponseEntity.status(200).body(categoryService.getByName(name));
    }
    @GetMapping("/get-name-asc")
    public ResponseEntity getNameAsc()
    {
        return ResponseEntity.status(200).body(categoryService.getNamesAsc());
    }
}
