package com.soighiri.libraryAp.category;

import java.util.List;

public interface CategoryService {
    CategoryEntity saveCategory(CategoryEntity category);
    CategoryEntity updateCategory(CategoryEntity category);
    void deleteCategory(CategoryEntity category);
    void deleteCategoryById(Long categoryId);
    CategoryEntity getCategoryById(Long categoryId);
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoryByCategoryLabel(String categoryLabel);
}
