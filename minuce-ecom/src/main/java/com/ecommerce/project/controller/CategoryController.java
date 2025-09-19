package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
// Sử dụng cái này giúp đường dẫn trong các giá trị gọn hơn
//Thay vì
//@RequestMapping(value = "/api/public/categories" , method = RequestMethod.GET)
//thì
//@RequestMapping(value = "/public/categories" , method = RequestMethod.GET)

public class CategoryController {
    //    private CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
//    @RequestMapping(value = "/public/categories" , method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) { // message friendly when error
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId) {
        try {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with category id: " + categoryId , HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());

        }
    }
}

