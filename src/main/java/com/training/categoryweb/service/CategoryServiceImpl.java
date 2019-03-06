package com.training.categoryweb.service;

import com.training.categoryweb.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    private ArrayList<Category> list = new ArrayList<>();
    @Override
    public Category create(Category category) {
        list.add(category);
        return category;
    }

    @Override
    public Category findById(String id) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getCategoryID().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return list;
    }

    @Override
    public Category update(Category category) {
        Category temp = findById(category.getCategoryID());
        if(temp==null) return null;
        list.set(list.indexOf(temp), category);
        return category;
    }

    @Override
    public Category delete(String id) {
        Category ct = findById(id);
        if(ct==null) return null;

        list.remove(findById(id));
        return ct;
    }
}
