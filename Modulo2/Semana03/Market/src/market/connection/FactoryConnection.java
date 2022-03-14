package market.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FactoryConnection {

    FactoryConnection(){}

    public Connection openConnection() throws SQLException{
        System.out.println("Preparando para abrir comunicação com banco de dados...");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost/market?useTimezone=true&serverTimezone=UTC",
                "postgres",
                "admin"
        );
    }

    public void closeConnection (Connection conn) throws SQLException{
        conn.close();
        System.out.println("Conexão fechada!");
    }
}
