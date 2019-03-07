package com.training.categoryweb.controller;

import com.training.categoryweb.Category;
import com.training.categoryweb.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class categoryController {
    private CategoryService categoryService;

    public categoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @RequestMapping(
            value = "/categories/{idCategory}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public Category findById(@PathVariable("idCategory") Long id){
        return categoryService.findById(id);
    }

    @RequestMapping(
            value = "/categories",
            method =  RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @RequestMapping(
            value = "/categories/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category update(@RequestBody  Category category){
        return categoryService.update(category);
    }

    @RequestMapping(
            value = "/categories/delete/{idCategory}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category delete (@PathVariable("idCategory") Long id){
        return categoryService.delete(id);
    }
}