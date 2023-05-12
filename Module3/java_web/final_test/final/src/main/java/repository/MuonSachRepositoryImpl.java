package repository;

import model.MuonSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MuonSachRepositoryImpl implements IMuonSachRepository{

    public static final String SELECT_ALL = "select t.mamuonsach, s.tensach, s.tacgia, h.hoten, h.lop, t.ngaymuon, t.ngaytra, t.trangthai from themuonsach t join sach s on t.masach = s.masach join hocsinh h on t.mahocsinh = h.mahocsinh";
    public static final String SELECT_ALL_BOOK = "select s.masach, s.tensach, s.tacgia, s.soluong, s.mota from sach s";
    public static final String FIND_BY_ID = "select s.masach, s.tensach, s.tacgia, s.soluong, s.mota from sach s where id = ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/final_test?user=root";
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
    public List<MuonSach> findAll() {
        List<MuonSach> muonSachList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maMuonSach = resultSet.getInt("mamuonsach");
                String tenSach = resultSet.getString("tensach");
                String tacGia = resultSet.getString("tacgia");
                String hoTen = resultSet.getString("hoTen");
                String lop = resultSet.getString("lop");
                String ngayMuon = resultSet.getString("ngaymuon");
                String ngayTra = resultSet.getString("ngaytra");
                int idTrangThai = resultSet.getInt("trangthai");
                String trangThai = "";
                switch (idTrangThai){
                    case 1:{
                        trangThai = "Dang Muon";
                        break;
                    }

                    case 0:{
                        trangThai = "Da Tra";
                        break;
                    }
                }

                muonSachList.add(new MuonSach(maMuonSach, tenSach, tacGia , hoTen, lop , ngayMuon, ngayTra, trangThai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return muonSachList;
    }

    @Override
    public List<MuonSach> findAllBook() {
        List<MuonSach> muonSachList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maSach = resultSet.getInt("maSach");
                String tenSach = resultSet.getString("tensach");
                String tacGia = resultSet.getString("tacgia");
                int soLuong = resultSet.getInt("soLuong");
                String moTa = resultSet.getString("moTa");

                muonSachList.add(new MuonSach(maSach, tenSach, tacGia , soLuong, moTa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return muonSachList;
    }

    @Override
    public void save(MuonSach muonSach) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("")) {

        }
    }

    @Override
    public boolean update(MuonSach muonSach) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public MuonSach findById(int id) {
        MuonSach muonSach = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maSach = resultSet.getInt("masach");
                String tenSach = resultSet.getString("tensach");
                String tacGia = resultSet.getString("tacgia");
                int soLuong = resultSet.getInt("soluong");
                String moTa = resultSet.getString("mota");

                muonSach = new MuonSach(maSach, tenSach, tacGia, soLuong, moTa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return muonSach;
    }

    @Override
    public List<MuonSach> searchByNameStudent(String name) {
        return null;
    }

    @Override
    public List<MuonSach> searchByNameBook(String name) {
        List<MuonSach> muonSachList = new ArrayList();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select t.mamuonsach, s.tensach, s.tacgia, h.hoten, h.lop, t.ngaymuon, t.ngaytra, t.trangthai from themuonsach t join sach s on t.masach = s.masach join hocsinh h on t.mahocsinh = h.mahocsinh  where tensach like '%' ? '%'")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maMuonSach = resultSet.getInt("mamuonsach");
                String tenSach = resultSet.getString("tensach");
                String tacGia = resultSet.getString("tacgia");
                String hoTen = resultSet.getString("hoten");
                String lop = resultSet.getString("lop");
                String ngayMuon = resultSet.getString("ngaymuon");
                String ngayTra = resultSet.getString("ngaytra");

                muonSachList.add(new MuonSach(maMuonSach, tenSach, tacGia, hoTen, lop, ngayMuon, ngayTra));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return muonSachList;
    }
}
