package com.training.categoryweb;

import com.training.categoryweb.service.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class categoryServiceImplTest {
    private CategoryServiceImpl service;
    @Before
    public void setUp() throws Exception{
        service = new CategoryServiceImpl();
    }

    @Test
    public void testCreate(){
        Category category = new Category("1", "baking");
        service.create(category);
        Assert.assertTrue("Total category nharus ada 1", service.findAll().size()==1 );
        Category temp = service.findById("1");
        Assert.assertTrue("Category harus ada", category==temp );
    }

    @Test
    public void testFindById(){
        Category category = service.findById("kosong");
        Assert.assertTrue("Category harus null", category==null);
        Category temp = service.create(new Category("1", "fashion"));
        category = service.findById("1");
        Assert.assertTrue("category dgn id 1 hrs ada", temp==category);
    }

    @Test
    public void testUpdate(){
        service.create(new Category("1", "baking"));
        service.update(new Category("1", "cooking"));
        Category category = service.findById("1");
        Assert.assertTrue("nama category harus berubah", category.getName().equals("cooking"));
    }

    @Test
    public void testDelete(){
        service.create(new Category("1", "fashion"));
        service.create(new Category("2", "snack"));
        service.create(new Category("3", "cooking"));
        service.create(new Category("4", "cleanser"));
        service.delete("3");
        Assert.assertTrue("total kategori harus 3", service.findAll().size()==3);
        Assert.assertTrue("kategori cooking harusnya gaada", service.findById("3")==null);
    }

}
