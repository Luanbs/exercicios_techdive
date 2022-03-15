package market.connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnectionApp {

    public static void main(String[] args) {
        try {
            FactoryConnection factoryConnection = new FactoryConnection();
            Connection connection = factoryConnection.openConnection();
            System.out.println("Abriu conexão!");
        } catch (SQLException e) {
            System.out.println("[ERROR]: Erro ao se conectar ao banco de dados!");
            e.printStackTrace();
        }

    }


}

