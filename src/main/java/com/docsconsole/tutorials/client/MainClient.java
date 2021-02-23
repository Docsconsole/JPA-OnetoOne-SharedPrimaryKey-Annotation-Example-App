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

            // creates a new product
            Product product = new Product();
            ProductDetails details = new ProductDetails();

            transaction = entityManager.getTransaction();
            transaction.begin();

            product.setProdName("Angular");
            product.setProdVendor("Google Inc");

            entityManager.persist(product);

            // creates product detail
            //details.setProdDetId(product.getProdId());
            details.setProdName("Angular");
            details.setProdDesc("UI framework");
            details.setProdPrice(new Float(1000));

            details.setProduct(product);
            entityManager.persist(details);
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
