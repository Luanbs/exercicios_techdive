package model.dao;


import model.entities.Category;
import model.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection conn;

    public ProductDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Product product) throws SQLException{
        String sql = "INSERT INTO produto(name, descricao) VALUES (?, ?)";
        try (PreparedStatement prepareStatement = conn.prepareStatement(sql)){
        prepareStatement.setString(1, product.getName());
        prepareStatement.setString(2, product.getDescription());
        prepareStatement.execute();

        }catch (SQLException e){
            System.out.println("Erro ao inserir produto.");
            e.printStackTrace();
        }

        System.out.println("Produto inserido com sucesso!");
        return true;
    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, descricao FROM produto";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getString("name"), resultSet.getString("descricao"));
                    product.setId(resultSet.getLong("id"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao capturar o produto, causado por:" + e.getMessage());
        }
        System.out.println("Produto localizado com sucesso.");

        return products;
    }

    public List<Product> listProductsAndCategory() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.id as product_id, p.name as product_name, " +
                "p.descricao as product_descricao," +
                " c.id as category_id, c.name as category_name from produto as p INNER JOIN categoria as c on p.categoria_id = c.id";

        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Product product = new Product(resultSet.getString("name"),resultSet.getString("descricao") );
                    product.setId(resultSet.getLong("id"));
                    product.setCategory(new Category(resultSet.getLong("id"), resultSet.getString("name")));
                }
            }
        }catch (SQLException e){

        }
        return products;
    }

    public boolean update(Product product, int id) throws SQLException {
        String sql = "UPDATE produto SET name = ?, descricao = ? where id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setLong(3, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar o produto, causado por:" + e.getMessage());
            return false;
        }
        System.out.println("Produto atualizado com sucesso.");
        return true;
    }

    public Product getById(int id) throws SQLException {
        Product product = new Product();
        String sql = "SELECT id, name, descricao FROM produto WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    product = new Product(resultSet.getString("name"), resultSet.getString("descricao"));
                    product.setId(resultSet.getLong("id"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao capturar o produto, causado por:" + e.getMessage());
        }
        System.out.println("Produto localizado com sucesso.");
        return product;
    }
}
