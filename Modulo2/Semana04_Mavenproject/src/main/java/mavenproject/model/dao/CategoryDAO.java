package mavenproject.model.dao;

import mavenproject.model.persistence.Category;

import javax.persistence.EntityManager;

public class CategoryDAO {

    EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Category findByName(String name) {
        String sql = "SELECT * FROM category WHERE name =:name";
        return (Category) entityManager.createNativeQuery(sql, Category.class)
                .setParameter("name", name).getSingleResult();
    }

    public void delete(Category category) {
        this.entityManager.remove(category);
    }

    public Category getById(long id) {
        return this.entityManager.find(Category.class, id);
    }
}
