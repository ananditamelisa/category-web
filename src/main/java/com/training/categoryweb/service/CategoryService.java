package com.training.categoryweb.service;

import com.training.categoryweb.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    Category create (Category category);
    Category findById(Long id);
    List<Category> findAll();
    Category update (Category category);
    Category delete (Long id);
}
