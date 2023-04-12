package com.example.calculator_basic;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        String operation = request.getParameter("operation");
        float add = firstOperand + secondOperand;
        float sub = firstOperand - secondOperand;
        float multi = firstOperand * secondOperand;
        float division = firstOperand / secondOperand;
        PrintWriter writer = response.getWriter();
        switch (operation) {
            case "addition": {
                writer.println("<html>");
                writer.println("<h1>Result: " + add + "</h1>");
                writer.println("</html>");
                break;
            }

            case "subtraction": {
                writer.println("<html>");
                writer.println("<h1>Result: " + sub + "</h1>");
                writer.println("</html>");
                break;
            }

            case "multiplication": {
                writer.println("<html>");
                writer.println("<h1>Result: " + multi + "</h1>");
                writer.println("</html>");
                break;
            }

            case "division": {
                writer.println("<html>");
                if (secondOperand != 0) {
                    writer.println("<h1>Result: " + division + "</h1>");
                }  else
                    writer.println("<h1>Can't divide by zero" + "</h1>");
                writer.println("</html>");
                break;
            }
        }
    }

    public void destroy() {
    }
}