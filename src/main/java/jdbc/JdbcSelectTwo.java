package jdbc;

import java.sql.*;

public class JdbcSelectTwo {

    public static void main(String[] argv) throws Exception {

        String DB_CONNECTION = "jdbc:mysql://localhost:3306/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "admin";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "SELECT * FROM person WHERE name = ?";

            preparedStatement = connection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1,"bob");


            rs = preparedStatement.executeQuery();

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
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());

        } finally
        {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}