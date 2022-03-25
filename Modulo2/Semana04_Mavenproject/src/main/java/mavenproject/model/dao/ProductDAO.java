package mavenproject.model.dao;

import mavenproject.model.persistence.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {

    EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Product product) {
        this.entityManager.persist(product);
    }

    public Product getById(long id) {
        return this.entityManager.find(Product.class, id);
    }

    public Product update(Product product) {
        return this.entityManager.merge(product);
    }

    public void delete(Product product) {
        this.entityManager.remove(update(product));
    }

    public List<Product> listAll(){
        String sql="SELECT * FROM product";
        return this.entityManager.createNativeQuery(sql, Product.class).getResultList();
    }

    public List<Product> listByName(String name){
        String sql="SELECT * FROM product WHERE name=:name";
    return this.entityManager.createNativeQuery(sql, Product.class ).setParameter("name", name).getResultList();
    }

}
