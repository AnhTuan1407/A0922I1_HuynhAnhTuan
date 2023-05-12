package controller;

import model.MuonSach;
import service.IMuonSachService;
import service.MuonSachServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MuonSachServlet", value = {"/muonSach", ""})
public class MuonSachServlet extends HttpServlet {
    IMuonSachService iMuonSachService = new MuonSachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreate(request, response);
                break;
            }
            case "update": {
                showUpdate(request, response);
                break;
            }
            case "delete": {
                showDelete(request, response);
                break;
            }
            case "searchNameStudent": {
                showSearchStudent(request, response);
                break;
            }
            case "searchNameBook": {
                showSearchBook(request, response);
                break;
            }
            case "list": {
                showList(request, response);
                break;
            }
            default: {
                showListBook(request, response);
                break;
            }
        }
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MuonSach> muonSachList = iMuonSachService.findAllBook();
        request.setAttribute("muonSach", muonSachList);
        request.getRequestDispatcher("/muonSach/listBook.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("maSach"));
//        MuonSach muonSach = iMuonSachService.findById(id);
//        request.setAttribute("muonSach", muonSach);
        request.getRequestDispatcher("/muonSach/create.jsp").forward(request, response);
    }

    private void showSearchBook(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showSearchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/muonSach/searchBook.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MuonSach> muonSachList = iMuonSachService.findAll();
        request.setAttribute("muonSach", muonSachList);
        request.getRequestDispatcher("/muonSach/list.jsp").forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "searchNameStudent": {
                searchStudent(request, response);
                break;
            }
            case "searchNameBook": {
                searchBook(request, response);
                break;
            }
            default: {
                showListBook(request, response);
                break;
            }
        }
    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) {

    }
}
