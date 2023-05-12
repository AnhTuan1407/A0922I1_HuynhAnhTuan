package controller;

import model.BenhAn;
import repository.IBenhAnRepository;
import repository.IBenhNhanRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", value = {"/benhAn", ""})
public class BenhAnServlet extends HttpServlet {

    IBenhAnRepository iBenhAnRepository = new IBenhNhanRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update": {
                showUpdate(request, response);
                break;
            }
            case "delete": {
                showDelete(request, response);
                break;
            }
            default: {
                showList(request, response);
                break;
            }
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("maBenhAn");
        BenhAn benhAn = iBenhAnRepository.findById(id);
        request.setAttribute("benhAn", benhAn);
        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("maBenhAn");
        BenhAn benhAn = iBenhAnRepository.findById(id);
        request.setAttribute("benhAn", benhAn);
        request.getRequestDispatcher("/view/delete.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhAn> benhAnList = iBenhAnRepository.findAll();
        request.setAttribute("benhAn", benhAnList);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update": {
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "delete": {
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            default: {
                showList(request, response);
                break;
            }
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("maBenhAn");
        iBenhAnRepository.delete(id);
        response.sendRedirect("/benhAn");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDo = request.getParameter("lyDo");
        String maBenhAn = request.getParameter("maBenhAn");
        BenhAn benhAn = new BenhAn(tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo, maBenhAn);
        iBenhAnRepository.update(benhAn);
        response.sendRedirect("/benhAn");
    }
}
