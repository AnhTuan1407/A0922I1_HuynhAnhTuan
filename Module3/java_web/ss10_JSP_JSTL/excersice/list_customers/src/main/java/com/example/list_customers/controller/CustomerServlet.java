package com.example.list_customers.controller;

import com.example.list_customers.model.Customers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", value = {"/customers", ""})
public class CustomerServlet extends HttpServlet {

    private static List<Customers> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customers("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "avatar.png"));
        customerList.add(new Customers("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "avatar.png"));
        customerList.add(new Customers("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "avatar.png"));
        customerList.add(new Customers("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "avatar.png"));
        customerList.add(new Customers("Nguyễn Đình Trì", "1983-08-19", "Hà Nội", "avatar.png"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}