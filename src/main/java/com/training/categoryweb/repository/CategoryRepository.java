package com.training.categoryweb.repository;

import com.training.categoryweb.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, Long> {

}
