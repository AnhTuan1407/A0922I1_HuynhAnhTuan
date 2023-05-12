package model;

public class MuonSach {
    private int maMuonSach;
    private  int maSach;
    private String tenSach;
    private String tacGia;
    private String hoTen;
    private String lop;
    private String ngayMuon;
    private String ngayTra;
    private String trangThai;

    private int soLuong;

    private String moTa;

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public MuonSach(int maMuonSach, String tenSach, String tacGia, String hoTen, String lop, String ngayMuon, String ngayTra, String trangThai) {
        this.maMuonSach = maMuonSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public MuonSach(String tenSach, String tacGia, String hoTen, String lop, String ngayMuon, String ngayTra, String trangThai) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public MuonSach(int maSach, String tenSach, String tacGia, int soLuong, String moTa) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public MuonSach(int maMuonSach, String tenSach, String tacGia, String hoTen, String lop, String ngayMuon, String ngayTra) {
        this.maMuonSach = maMuonSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }
}
