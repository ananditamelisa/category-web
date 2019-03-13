//package com.training.categoryweb;
//
//import com.training.categoryweb.repository.CategoryRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CategoryRepositoryTest {
//    @Autowired(required = true)
//    private CategoryRepository categoryRepository;
//
//    @Test
//    public void testCreate(){
//        Category category = new Category();
//        category.setName("Electronic");
//
//        Category created = categoryRepository.save(category);
//        Assert.assertTrue("Electronic harusnya sudah terbuat", category==created);
//    }
//    @Test
//    public void testFindById(){
//        Category category1 = new Category();
//        category1.setName("fashion");
//        Category temp = categoryRepository.save(category1);
//        Optional<Category> byId1 = categoryRepository.findById(temp.getCategoryID());
//        Assert.assertTrue("category dgn id 1 hrs ada", byId1.isPresent());
//        Optional<Category> byId = categoryRepository.findById(temp.getCategoryID()+1);
//        Assert.assertFalse("harusnya id 2 ga ada", byId.isPresent());
//    }
//
//    @Test
//    public void testUpdate(){
//        Category baking = new Category();
//        baking.setName("Baking");
//        categoryRepository.save(baking);
//        Long id = baking.getCategoryID();
//        Category cooking = new Category(baking.getCategoryID(), "cooking");
//        categoryRepository.save(cooking);
//        Assert.assertTrue("id cooking harusnya tetep 1", id == cooking.getCategoryID());
//    }
//
//    @Test
//    public void testFindAll(){
//        Category fashion = new Category();
//        fashion.setName("Fashion");
//        Category electronic = new Category();
//        electronic.setName("Electronic");
//        Category vehicle = new Category();
//        fashion.setName("Vehicle");
//        Category cooking = new Category();
//        electronic.setName("Cooking");
//        categoryRepository.save(fashion);
//        categoryRepository.save(electronic);
//        categoryRepository.save(vehicle);
//        categoryRepository.save(cooking);
//        Assert.assertTrue("total kategori harus 4", categoryRepository.findAll().size()==4);
//    }
//    @Test
//    public void testDelete(){
//        Category fashion = new Category();
//        fashion.setName("Fashion");
//        Category electronic = new Category();
//        electronic.setName("Electronic");
//        Category vehicle = new Category();
//        fashion.setName("Vehicle");
//        Category cooking = new Category();
//        electronic.setName("Cooking");
//        Category create =  categoryRepository.save(fashion);
//        Category create2 = categoryRepository.save(electronic);
//        Category create3 = categoryRepository.save(vehicle);
//        Category create4 = categoryRepository.save(cooking);
//
//        categoryRepository.deleteById(create2.getCategoryID());
//        Assert.assertFalse("harusnya skrg id dari creat2 udh gaada",
//                categoryRepository.existsById(create2.getCategoryID()));
//    }
//
//}
