package jdbc;

import java.sql.*;

public class JdbcInsert {
    public static void main(String[] argv) throws Exception {

        String DB_CONNECTION = "jdbc:mysql://localhost:3300/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_USER = "admin";
        String DB_PASSWORD = "admin";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            String insertTableSQL = "INSERT INTO person"
                    + "(idperson, name, surname, age) VALUES"
                    + "(?,?,?,?)";

            preparedStatement = connection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "fifty");
            preparedStatement.setString(3, "fifstysurname");
            preparedStatement.setInt(4, 50);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());

        } finally
        {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}