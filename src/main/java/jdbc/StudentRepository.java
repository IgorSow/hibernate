package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository extends AbstractRepository {

    String DB_CONNECTION = "jdbc:mysql://localhost:3300/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DB_USER = "admin";
    String DB_PASSWORD = "admin";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;

    public Object get(int id) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "SELECT * FROM student WHERE id=" + id;

            statement = connection.createStatement();

            resultSet = statement.executeQuery(selectTableSQL);


            Integer idStudent = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            String lastName = resultSet.getString("LASTNAME");
            int age = resultSet.getInt("age");

            Student student = new Student(idStudent, name, lastName);

            System.out.println("IdStudent : " + idStudent);
            System.out.println("Name : " + name);
            System.out.println("Last Name : " + lastName);


            return student;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List getAll() {
        try {
            List<Student> studentList = new ArrayList<Student>();
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "SELECT * FROM student";

            statement = connection.createStatement();

            resultSet = statement.executeQuery(selectTableSQL);

            while (resultSet.next()) {

                Integer idStudent = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String lastName = resultSet.getString("LASTNAME");
                int age = resultSet.getInt("age");

                Student student = new Student(idStudent, name, lastName);

                System.out.println("IdStudent : " + idStudent);
                System.out.println("Name : " + name);
                System.out.println("Last Name : " + lastName);
                studentList.add(student);

            }
            return studentList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean delete(int id) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = ("DELETE FROM student WHERE id=" + id);

            statement = connection.createStatement();

            statement.executeUpdate(selectTableSQL);

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addMark(int id, double mark) {

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "INSERT INTO marks VALUE(null,?,?)";

            preparedStatement = connection.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, mark);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean update(int id, Map map) {

        String nameFromMap = (String) map.get("NAME");
        String surnameFromMap = (String) map.get("LASTNAME");

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "UPDATE student SET NAME= ? , LASTNAME =? WHERE ID= ?";

            preparedStatement = connection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, nameFromMap);
            preparedStatement.setString(2, surnameFromMap);
            preparedStatement.setInt(3, id);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean insert(Map map) {
        String nameFromMap = (String) map.get("NAME");
        String surnameFromMap = (String) map.get("LASTNAME");

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            String selectTableSQL = "INSERT INTO student VALUE(null,?,?)";

            preparedStatement = connection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, nameFromMap);
            preparedStatement.setString(2, surnameFromMap);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
