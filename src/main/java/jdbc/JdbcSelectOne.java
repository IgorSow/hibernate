package jdbc;

import java.sql.*;

public class JdbcSelectOne {

    public static void main(String[] argv) throws Exception {

        String DB_CONNECTION = "jdbc:mysql://localhost:3300/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_USER = "admin";
        String DB_PASSWORD = "admin";

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();


            String selectTableSQL = "SELECT * from person";
// execute select SQL stetement
            rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                String personId = rs.getString("idperson");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                System.out.println("personId : " + personId);
                System.out.println("name : " + name);
                System.out.println("surname : " + surname);
                System.out.println("age : " + age);


            }
        } catch (
                SQLException e)

        {

            System.out.println(e.getMessage());

        } finally

        {
            if (rs != null) {
                rs.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}