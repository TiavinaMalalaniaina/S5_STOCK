package mg.tiavina.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/stock_store";
    private static final String USER = "postgres";
    private static final String PASSWORD = "malalaniaina";

    public static Connection getConnection() {
        try {
            // Chargez le pilote JDBC
            Class.forName("org.postgresql.Driver");

            // Établissez la connexion avec la base de données
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                return connection;
            } else {
                System.out.println("La connexion à la base de données a échoué");
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données PostgreSQL");
            e.printStackTrace();
            return null;
        }
    }
}
