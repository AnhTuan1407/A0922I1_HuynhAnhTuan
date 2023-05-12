package controller;

import model.NhanVien;
import repository.INVRepository;
import repository.NVRepositoryImpl;
import service.INVService;
import service.NVServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {"/nhanvien", ""})

public class NhanVienServlet extends HttpServlet {

    INVService invService = new NVServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
        {
            action ="";
        }
        switch (action){
            case "create":{
                showCreate(request, response);
                break;
            }

            case "update":{
                showUpdate(request, response);
                break;
            }

            case "delete":{
                showDelete(request, response);
                break;
            }

            default:{
                showList(request, response);
                break;
            }
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("maNhanVien"));
        request.setAttribute("nhanVien", invService.findById(id));
        request.getRequestDispatcher("/nhan_vien/delete.jsp").forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("maNhanVien"));
        request.setAttribute("nhanVien", invService.findById(id));
        request.getRequestDispatcher("/nhan_vien/update.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/nhan_vien/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<NhanVien> nhanVienList = invService.findAll();
        request.setAttribute("nhanvien", nhanVienList);
        request.getRequestDispatcher("/nhan_vien/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
        {
            action ="";
        }
        switch (action){
            case "create":{
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            case "update":{
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            case "delete":{
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            default:{
                showList(request, response);
                break;
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("maNhanVien"));
        invService.delete(id);
        response.sendRedirect("/nhanvien");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("maNhanVien"));
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        String soCMND = request.getParameter("soCMND");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        String viTri = request.getParameter("viTri");
        NhanVien nhanVien = new NhanVien(id, hoTen, ngaySinh, soCMND, luong, sdt, email, diaChi, viTri);
        invService.update(nhanVien);
        response.sendRedirect("/nhanvien");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        String soCMND = request.getParameter("soCMND");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        String viTri = request.getParameter("viTri");
        NhanVien nhanVien = new NhanVien(hoTen, ngaySinh, soCMND, luong, sdt, email, diaChi, viTri);
        invService.save(nhanVien);
        response.sendRedirect("/nhanvien");
    }
}
