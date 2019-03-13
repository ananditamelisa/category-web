package com.training.categoryweb.service;

import com.training.categoryweb.Category;
import com.training.categoryweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Mono<Category> create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Mono<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Mono<Category> update(Category category, Long id) {
        return categoryRepository.findById(id)
                .map(value->new Category(value.getCategoryID(), category.getName()))
                .flatMap(value-> categoryRepository.save(value).thenReturn(value));
    }

    @Override
    public Mono<Category> delete(Long id) {
        return categoryRepository.findById(id)
                .flatMap(value-> categoryRepository.deleteById(id).thenReturn(value));
    }
}
