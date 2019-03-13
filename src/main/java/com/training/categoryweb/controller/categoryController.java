package com.training.categoryweb.controller;

import com.training.categoryweb.Category;
import com.training.categoryweb.service.CategoryService;
import com.training.categoryweb.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
public class categoryController {
    private CategoryService categoryService;
    private ValidationHelper validationHelper;

    @Autowired
    public categoryController(CategoryService categoryService, ValidationHelper validationHelper) {
        this.categoryService = categoryService;
        this.validationHelper = validationHelper;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> create(@RequestBody Category category){
        return validationHelper.validate(category)
                .flatMap(data->categoryService.create(data))
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/{idCategory}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> findById(@PathVariable("idCategory") Long id){

        return categoryService.findById(id).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories",
            method =  RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Category> findAll(){
        return categoryService.findAll().subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/update/{idCategory}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> update(@RequestBody  Category category, @PathVariable("idProduct") Long id){

        return categoryService.update(category, id).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/delete/{idCategory}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> delete (@PathVariable("idCategory") Long id){

        return categoryService.delete(id).subscribeOn(Schedulers.elastic());
    }
}