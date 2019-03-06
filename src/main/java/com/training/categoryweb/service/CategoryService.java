package com.training.categoryweb.service;

import com.training.categoryweb.Category;

import java.util.List;

public interface CategoryService {
    Category create (Category category);
    Category findById(String id);
    List<Category> findAll();
    Category update (Category category);
    Category delete (String id);
}
