package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    public static final String SELECT_ALL_PRODUCTS = "select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory";
    public static final String INSERT_INTO_PRODUCT = "INSERT INTO product(name, price, amount, color, description, idcategory) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_PRODUCT = "UPDATE product set name = ?, price = ?, amount = ?, color = ?, description = ?, idcategory = ? WHERE id = ?";
    public static final String FIND_BY_ID = "select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory Where id = ?";
    public static final String DELETE_PRODDUCT = "DELETE FROM product WHERE id = ?";
    public static final String SEARCH_BY_NAME = "select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory  where name like '%' ? '%'";
    private String jdbcURL = "jdbc:mysql://localhost:3306/products?user=root";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static Connection connection;

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("namecategory");

                productList.add(new Product(id, name, price, amount, color, description, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void save(Product product) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            int idCategory = -1;
            switch (product.getCategory()) {
                case "Phone": {
                    idCategory = 1;
                    break;
                }
                case "Television": {
                    idCategory = 2;
                    break;
                }
                case "Laptop": {
                    idCategory = 3;
                    break;
                }
            }
            preparedStatement.setInt(6, idCategory);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            int idCategory = -1;
            switch (product.getCategory()) {
                case "Phone": {
                    idCategory = 1;
                    break;
                }
                case "Television": {
                    idCategory = 2;
                    break;
                }
                case "Laptop": {
                    idCategory = 3;
                    break;
                }
            }
            preparedStatement.setInt(6, idCategory);
            preparedStatement.setInt(7, product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODDUCT)){
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String nameCategory = resultSet.getString("namecategory");

                product = new Product(idProduct, name, price, amount, color, description, nameCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("id");
                String nameProduct = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String nameCategory = resultSet.getString("namecategory");

                productList.add(new Product(idProduct, nameProduct, price, amount, color, description, nameCategory));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
