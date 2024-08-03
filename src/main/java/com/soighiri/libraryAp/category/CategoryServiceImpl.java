package com.soighiri.libraryAp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(CategoryEntity category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryEntity getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
