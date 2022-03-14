package model.dao;


import model.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection conn;

    public ProductDAO(Connection conn){
        this.conn=conn;
    }

    public List<Product> list() throws SQLException{
        List<Product> products = new ArrayList<>();


        return products;
    }

    public List<Product> listProductsAndCategory() throws SQLException{
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.id as product_id, p.name as product_name, p.descricao as product_descricao," +
                " c.id as category_id, c.name as category_name from produto as p INNER JOIN categoria as c on p.categoria_id = c.id";

        //try(PreparedStatement preparedStatement = conn.create)

    }

}
