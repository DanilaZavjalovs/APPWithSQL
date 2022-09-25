import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
    List<String> usersList;
    List<String> passwordList;
    Connection connection;
    String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    String dbLogin = "postgres";
    String dbPassword = "password";
    public void connect() {

        try {
            connection = DriverManager.getConnection(jdbcURL,dbLogin, dbPassword);
            System.out.println("Connected");

            String sql = "SELECT * FROM userdata";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            usersList = new ArrayList<>();
            passwordList = new ArrayList<>();

            while (result.next()) {
                usersList.add(result.getString("login"));
                passwordList.add(result.getString("password"));
            }

            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error in connection to DB");
            throw new RuntimeException(e);
        }
    }

    public void insertData(String login, String password) {
        try {
            connection = DriverManager.getConnection(jdbcURL,dbLogin, dbPassword);
            Statement stmt = connection.createStatement();

            String drop = "INSERT INTO userdata VALUES ('"+ login +"', '"+ password +"')";

            stmt.execute(drop);
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error in inserting data to database");
        }
    }
}
