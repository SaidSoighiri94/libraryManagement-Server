package com.soighiri.libraryAp.category;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CategoryEntity> getCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping(value = "/{categoryId}")
    public CategoryEntity getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
    @PostMapping(value = "/addCategory")
    public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }
}
