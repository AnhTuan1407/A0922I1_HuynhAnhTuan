package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerServiceImp;
import com.example.customer.service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers", ""})
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerServiceImp();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
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
            }

            default: {
                showList(request, response);
                break;
            }
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect("/delete.jsp");
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = iCustomerService.findAll();
        request.setAttribute("customer", customerList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "create": {
                create(request, response);
                break;
            }

            case "update": {
                update(request, response);
                break;
            }

            case "delete": {
                delete(request, response);
                break;
            }

            default: {
                showList(request, response);
                break;
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findById(id);
        iCustomerService.delete(customer);
        response.sendRedirect("/customers");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, name, email, address);
        iCustomerService.save(customer);
        response.sendRedirect("/customers");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = iCustomerService.findById(id);
        if (customer != null) {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            iCustomerService.update(customer);
            response.sendRedirect("/customers");
        }else {
            response.sendRedirect("/customers");
        }
    }

    public void destroy() {
    }
}