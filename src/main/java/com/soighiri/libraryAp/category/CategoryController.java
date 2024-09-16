package com.soighiri.libraryAp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(value = "/customers")
    public ResponseEntity<List<CategoryEntity>> getCategories() {
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryEntities);
    }
    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        CategoryEntity categoryEntity = categoryService.getCategoryById(categoryId);
        if(categoryEntity != null) {
            return ResponseEntity.ok(categoryEntity);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping(value = "/addCategory")
    public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }
}
