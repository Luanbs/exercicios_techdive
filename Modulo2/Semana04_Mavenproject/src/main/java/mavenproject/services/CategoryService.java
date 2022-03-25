package mavenproject.services;


import mavenproject.model.dao.CategoryDAO;
import mavenproject.model.persistence.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CategoryService {

    private final Logger LOG = LogManager.getLogger(CategoryService.class);

    private CategoryDAO categoryDAO;

    public CategoryService(EntityManager entityManager) {

        this.categoryDAO = new CategoryDAO(entityManager);
    }

    public Category findByName(String name) {
        if (name == null || name.isEmpty()) {
            this.LOG.error("O nome não pode ser nulo!");
            throw new RuntimeException("Category name is null.");
        }
        try {
            return this.categoryDAO.findByName(name.toLowerCase());
        } catch (NoResultException e) {
            this.LOG.info("Não foi encontrada a categoria. Será criada.");
            return null;
        }
    }

    public Category getById(Long id) {
        if (id == null || id < 0) {
            this.LOG.error("O ID é inválido.");
            throw new RuntimeException("The parameter is null.");
        }

        Category category = this.categoryDAO.getById(id);

        if (category == null) {
            this.LOG.error("Não foi encontrado a categoria de id " + id);
            throw new RuntimeException("Category not found!");
        }
        return category;

    }


}
