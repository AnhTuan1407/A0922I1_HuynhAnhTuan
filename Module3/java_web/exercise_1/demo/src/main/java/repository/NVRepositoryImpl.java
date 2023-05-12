package repository;

import model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NVRepositoryImpl implements INVRepository {

    public static final String SELECT_FROM_NHAN_VIEN = "SELECT nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi, vt.ten_vi_tri from nhan_vien nv JOIN vi_tri vt ON nv.ma_vi_tri = vt.ma_vi_tri";
    public static final String INSERT_INTO_NHAN_VIEN = "INSERT INTO nhan_vien(ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_NHAN_VIEN = "UPDATE nhan_vien set ho_ten = ?, ngay_sinh = ?, so_cmnd = ?, luong = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, ma_vi_tri = ? WHERE ma_nhan_vien = ?;";
    public static final String DELETE_NHAN_VIEN = "DELETE FROM nhan_vien WHERE ma_nhan_vien = ?;";
    public static final String FIND_BY_ID = "SELECT * FROM nhan_vien WHERE ma_nhan_vien = ?;";
    private String jdbcURL = "jdbc:mysql://localhost:3306/exercise_1?user=root";
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
    public List<NhanVien> findAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_NHAN_VIEN)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maNhanVien = resultSet.getInt("ma_nhan_vien");
                String hoTen = resultSet.getString("ho_ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                String soCMND = resultSet.getString("so_cmnd");
                double luong = resultSet.getDouble("luong");
                String sdt = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");
                String viTri = resultSet.getString("ten_vi_tri");
                nhanVienList.add(new NhanVien(maNhanVien, hoTen, ngaySinh, soCMND, luong, sdt, email, diaChi, viTri));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    @Override
    public void save(NhanVien nhanVien) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_NHAN_VIEN)) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setString(2, nhanVien.getNgaySinh());
            preparedStatement.setString(3, nhanVien.getSoCMND());
            preparedStatement.setDouble(4, nhanVien.getLuong());
            preparedStatement.setString(5, nhanVien.getSdt());
            preparedStatement.setString(6, nhanVien.getEmail());
            preparedStatement.setString(7, nhanVien.getDiaChi());
            int maViTri = -1;
            switch (nhanVien.getViTri()){
                case "Nhan Vien": {
                    maViTri = 2;
                    break;
                }
                case "Quan Ly": {
                    maViTri = 1;
                    break;
                }
            }
            preparedStatement.setInt(8, maViTri);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(NhanVien nhanVien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NHAN_VIEN)) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setString(2, nhanVien.getNgaySinh());
            preparedStatement.setString(3, nhanVien.getSoCMND());
            preparedStatement.setDouble(4, nhanVien.getLuong());
            preparedStatement.setString(5, nhanVien.getSdt());
            preparedStatement.setString(6, nhanVien.getEmail());
            preparedStatement.setString(7, nhanVien.getDiaChi());
            int maViTri = -1;
            switch (nhanVien.getViTri()){
                case "Quan Ly": {
                    maViTri = 1;
                    break;
                }
                case "Nhan Vien": {
                    maViTri = 2;
                    break;
                }
            }
            preparedStatement.setInt(8, maViTri);
            preparedStatement.setInt(9, nhanVien.getMaNhanVien());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_NHAN_VIEN)){
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public NhanVien findById(int id) {
        NhanVien nhanVien = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String hoTen = resultSet.getString("ho_ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                String soCMND = resultSet.getString("so_cmnd");
                double luong = resultSet.getDouble("luong");
                String sdt = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");
                int maViTri = resultSet.getInt("ma_vi_tri");
                String viTri = "";
                switch (maViTri){
                    case 1: {
                        viTri = "Quan Ly";
                        break;
                    }

                    case 2: {
                        viTri = "Nhan Vien";
                        break;
                    }
                }
                nhanVien = new NhanVien(hoTen, ngaySinh, soCMND, luong, sdt, email, diaChi, viTri);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanVien;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
