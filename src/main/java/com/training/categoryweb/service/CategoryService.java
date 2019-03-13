package com.training.categoryweb.service;

import com.training.categoryweb.Category;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public interface CategoryService {
    Mono<Category> create (Category category);
    Mono<Category> findById(Long id);
    Flux<Category> findAll();
    Mono<Category> update (Category category, Long Id);
    Mono<Category> delete (Long id);
}
