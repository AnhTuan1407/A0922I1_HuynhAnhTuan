package repository;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements IUserRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/a0922i1_student?user=root";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static Connection connection;

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {

    }

    @Override
    public boolean update(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
