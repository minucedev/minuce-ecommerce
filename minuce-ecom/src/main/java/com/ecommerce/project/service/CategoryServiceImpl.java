package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryID(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
        .filter(c -> c.getCategoryID().equals(categoryId))
                .findFirst().orElse(null);
        categories.remove(category);
        if(category == null) return "Not found category";
        return "Remove success categoryId " + categoryId;
    }
}
