package model;

public class NhanVien {
    private int maNhanVien;
    private String hoTen;
    private String ngaySinh;
    private String soCMND;
    private double luong;
    private String sdt;
    private String email;
    private String diaChi;
    private String viTri;
    private String trinhDo;
    private String boPhan;

    public NhanVien(int maNhanVien, String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi, String viTri, String trinhDo, String boPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
        this.trinhDo = trinhDo;
        this.boPhan = boPhan;
    }

    public NhanVien(String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi, String viTri, String trinhDo, String boPhan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
        this.trinhDo = trinhDo;
        this.boPhan = boPhan;
    }

    public NhanVien(int maNhanVien, String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhanVien(String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhanVien(int maNhanVien, String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi, String viTri) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
    }

    public NhanVien(String hoTen, String ngaySinh, String soCMND, double luong, String sdt, String email, String diaChi, String viTri) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

}
