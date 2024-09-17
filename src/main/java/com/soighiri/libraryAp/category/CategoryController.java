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

    @GetMapping(value = "/categories")
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
    @PostMapping(value = "/createCategory")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity categoryEntity) {
        CategoryEntity savedCategory = categoryService.saveCategory(categoryEntity);
        return ResponseEntity.ok(savedCategory);
    }
    @PutMapping(value = "/updateCategorie/{categoryId}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long categoryId,  @RequestBody CategoryEntity categoryEntity){
       categoryEntity.setIdCategory(categoryId);
        CategoryEntity updatedCategory = categoryService.updateCategory(categoryEntity);
        if (updatedCategory == null) {
         return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(updatedCategory);
    }
    @DeleteMapping(value = "/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategoryById( @PathVariable Long categoryId){
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> deleteCategory(@RequestBody CategoryEntity categoryEntity){
        categoryService.deleteCategory(categoryEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search/{categoryLabel}")
    public ResponseEntity<CategoryEntity> getCategoryByLabel(@PathVariable("categoryLabel") String categoryLabel){
        CategoryEntity categoryEntity = categoryService.getCategoryByCategoryLabel(categoryLabel);
        if(categoryEntity != null) {
            return ResponseEntity.ok(categoryEntity);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

}
