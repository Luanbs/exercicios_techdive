package market.connection;

import org.postgresql.core.ConnectionFactory;

import java.sql.*;


public class JdbcConnectionApp {

    public static void main(String[] args) {

    try{
        FactoryConnection factoryConnection = new FactoryConnection();
        Connection connection = factoryConnection.openConnection();
        System.out.println("Abriu conexão!");

        createProduct(connection);

    } catch (SQLException e) {
        System.out.println("[ERROR]: Erro ao se conectar ao banco de dados!");
        e.printStackTrace();
    }

    }


    private static void listproducts(Connection connection) throws SQLException {
        String sql= "";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.execute();
    }

    private static void createProduct (Connection connection){

        String name="Fogão";
        String descricao="Brastemp";
        String sql= "INSERT INTO produto(name, descricao) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, descricao);

            preparedStatement.execute();

            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
