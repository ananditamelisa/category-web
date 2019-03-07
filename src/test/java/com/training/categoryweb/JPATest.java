package com.training.categoryweb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {
    @Autowired
    EntityManagerFactory factory;

    @Test
    public void testInsertProduct(){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Category category = new Category();
        category.setName("Fashion");
        //Insert Category
        entityManager.persist(category);
        Assert.assertNotNull("category tdk boleh null", category.getCategoryID());

        //Update Category
        Category temp = entityManager.find(Category.class, category.getCategoryID());
        temp.setName("Electronic");
        entityManager.merge(temp);

        //Remove Category
        entityManager.remove(temp);

        //Search Data
        List<Category> list = entityManager.createQuery("select c from Category c where c.name = :name",
                Category.class).setParameter("name", "Blibli").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
