package mavenproject.application;

import mavenproject.connection.JpaConnectionFactory;
import mavenproject.model.persistence.Category;
import mavenproject.model.persistence.Product;
import mavenproject.services.ProductService;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Program {

    public static void main(String[] args) {
        EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
        ProductService productService = new ProductService(entityManager);

        Product product = new Product("Cheetos", "Cheddar 90g", new BigDecimal(6.99),
                new Category("Alimento"));


//        Observações:
//        - Setor, Função e Ocupação poderiam ser classes.
//          - faltaram alguns getters e setters nas entidades
//        - Perfil deveria ser uma classe (ou enum).
//        - Usuário deveria ter uma lista de Perfil.

    }
}
