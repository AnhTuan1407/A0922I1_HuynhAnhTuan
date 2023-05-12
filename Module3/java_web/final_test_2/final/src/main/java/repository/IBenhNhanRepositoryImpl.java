package repository;

import model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IBenhNhanRepositoryImpl implements IBenhAnRepository{

    public static final String SELECT_ALL = "select ba.maBenhAn, ba.maBenhNhan, bn.tenBenhNhan, ba.ngayNhapVien, ba.ngayRaVien, ba.lyDo from benhan ba join benhnhan bn on ba.maBenhNhan = bn.maBenhNhan;";
    public static final String DELETE_BENH_AN = "DELETE FROM benhan WHERE maBenhAn = ?";
    public static final String FIND_ID = "select ba.maBenhAn, ba.maBenhNhan, bn.tenBenhNhan, ba.ngayNhapVien, ba.ngayRaVien, ba.lyDo from benhan ba join benhnhan bn on ba.maBenhNhan = bn.maBenhNhan where maBenhAn = ?;";
    public static final String UPDATE = "UPDATE benhan join benhnhan on benhan.maBenhNhan = benhnhan.maBenhNhan set tenBenhNhan = ?, ngayNhapVien = ?, ngayRaVien = ?, lyDo = ? WHERE maBenhAn = ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/final_test_2?user=root";
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
    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhAn = resultSet.getString("maBenhAn");
                String maBenhNhan = resultSet.getString("maBenhNhan");
                String tenBenhNhan = resultSet.getString("tenBenhNhan");
                String ngayNhapVien = resultSet.getString("ngayNhapVien");
                String ngayRaVien = resultSet.getString("ngayRaVien");
                String lyDo = resultSet.getString("lyDo");
                benhAnList.add(new BenhAn(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAnList;
    }

    @Override
    public void save(BenhAn benhAn) throws SQLException {

    }

    @Override
    public boolean update(BenhAn benhAn) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, benhAn.getTenBenhNhan());
            preparedStatement.setString(2, benhAn.getNgayNhapVien());
            preparedStatement.setString(3, benhAn.getNgayRaVien());
            preparedStatement.setString(4, benhAn.getLyDo());
            preparedStatement.setString(5, benhAn.getMaBenhAn());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BENH_AN)){
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public BenhAn findById(String id) {
        BenhAn benhAn = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID)) {
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String maBenhAn = resultSet.getString("maBenhAn");
                String maBenhNhan = resultSet.getString("maBenhNhan");
                String tenBenhNhan = resultSet.getString("tenBenhNhan");
                String ngayNhapVien = resultSet.getString("ngayNhapVien");
                String ngayRaVien = resultSet.getString("ngayRaVien");
                String lyDo = resultSet.getString("lyDo");

                benhAn = new BenhAn(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }
}
