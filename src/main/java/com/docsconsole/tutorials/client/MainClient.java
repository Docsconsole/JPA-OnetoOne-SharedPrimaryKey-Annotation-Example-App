package com.docsconsole.tutorials.client;

import com.docsconsole.tutorials.entity.Product;
import com.docsconsole.tutorials.entity.ProductDetails;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("the main method");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();
            transaction.begin();

            // creates a new product
            Product product = new Product();
            // product.setProductId(new Long(101));
            product.setProdName("Angular");
            product.setProdVendor("Google Inc");

            // creates product detail
            ProductDetails details = new ProductDetails();
            // details.setProductId(new Long(101));
            details.setProdName("Angular");
            details.setProdDesc("UI framework");
            details.setProdPrice(new Float(1000));

            // sets the bi-directional association
            product.setProdDetails(details);
            // details.setProduct(product);

            // Save employee
            entityManager.persist(product);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
