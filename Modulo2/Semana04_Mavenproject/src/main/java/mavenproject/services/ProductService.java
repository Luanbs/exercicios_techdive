package mavenproject.services;

import mavenproject.model.dao.ProductDAO;
import mavenproject.model.persistence.Category;
import mavenproject.model.persistence.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final Logger LOG = LogManager.getLogger(ProductService.class);

    private EntityManager entityManager;

    private ProductDAO productDAO;

    private CategoryService categoryService;

    public ProductService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.productDAO = new ProductDAO(entityManager);
        this.categoryService = new CategoryService(entityManager);
    }

    private void beginTransaction() {
        this.LOG.info("Abrindo transação com o banco de dados...");
        entityManager.getTransaction().begin();
    }

    private void commitAndCloseTransaction() {
        this.LOG.info("Commitando e fechando a transação com o banco de dados.");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void create(Product product) {
        this.LOG.info("Preparando para criação de um Produto");

        if (product == null) {
            this.LOG.error("Produto informado está nulo");
            throw new RuntimeException("Product is NULL!");
        }
        String categoryName = product.getCategory().getName();

        this.LOG.info("Buscando se já existe a categoria: " + categoryName);
        Category category = this.categoryService.findByName(categoryName);

        if (category != null) {
            this.LOG.info("Categoria '" + categoryName + "' encontrada no banco!");
            product.setCategory(category);
        }

        try {
            beginTransaction();
            this.productDAO.create(product);
            commitAndCloseTransaction();
        } catch (Exception e) {
            this.LOG.error("Erro ao criar o produto, causado por: " + e.getMessage());
            throw new RuntimeException(e);
        }
        this.LOG.info("Produto criado com sucesso!");
    }

    public void delete(Long id) {
        this.LOG.info("Preparando para encontrar o produto");
        if (id == null) {
            this.LOG.error("O ID do Produto informado está nulo!");
            throw new RuntimeException("The ID is Null");
        }

        Product product = this.productDAO.getById(id);
        validateProductIsNull(product);
        this.LOG.info("Produto encontrado com sucesso!");

        beginTransaction();
        this.productDAO.delete(product);
        commitAndCloseTransaction();
        this.LOG.info("Produto deletado com sucesso!");

    }

    public void update(Product newProduct, Long productId) {
        this.LOG.info("Preparando para atualizar o produto");
        if (newProduct == null || productId == null) {
            this.LOG.error("Um dos parametros está nulo!");
            throw new RuntimeException("Parameter is NULL");
        }

        Product product = this.productDAO.getById(productId);
        validateProductIsNull(product);

        this.LOG.info("Produto encontrado no banco!");

        beginTransaction();
        product.setName(newProduct.getName());
        product.setCategory(this.categoryService.findByName(newProduct.getCategory().getName()));
        product.setPrice(newProduct.getPrice());
        product.setDescription(newProduct.getDescription());
        commitAndCloseTransaction();
        this.LOG.info("Produto atualizado com sucesso!");
    }

    public List<Product> listAll() {
        this.LOG.info("Preparando para listar os produtos");
        List<Product> products = this.productDAO.listAll();

        if (products==null){
            this.LOG.info("Não foram encontrados produtos");
            return new ArrayList<Product>();
        }
        this.LOG.info("Foram encontrados "+ products.size() +" produtos.");
        return products;
    }

    public List<Product> listByName(String name) {
        if (name == null || name.isEmpty()) {
            this.LOG.info("O parametro nome está vazio");
            throw new RuntimeException("The parameter name is null");
        }

        this.LOG.info("Preparando para buscar os produtos com o nome: " + name);
        List<Product> products = this.productDAO.listByName(name.toLowerCase());

        if (products == null) {
            this.LOG.info("Não foram encontrados Produtos");
            return new ArrayList<Product>();
        }

        this.LOG.info("Foram encontrados " + products.size() + " produtos.");
        return products;
    }

    private void validateProductIsNull(Product product) {
        if (product == null) {
            this.LOG.error("O Produto não Existe!");
            throw new EntityNotFoundException("Product not Found!");
        }
    }

}
