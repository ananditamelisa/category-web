package com.training.categoryweb.service;

import com.training.categoryweb.Category;
import com.training.categoryweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired (required = true)
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> idCategory = categoryRepository.findById(id);
        Category temp;
        if(idCategory.isPresent()){
            temp = idCategory.get();
            return temp;
        }else{
            return null;
        }
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        Optional<Category> byId = categoryRepository.findById(category.getCategoryID());
        if(byId.isPresent()){
            return categoryRepository.save(category);
        }else{
            return null;
        }
    }

    @Override
    public Category delete(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isPresent()){
            Category c = byId.get();
            categoryRepository.deleteById(id);
            return c;
        }else{
            return null;
        }
    }
}
