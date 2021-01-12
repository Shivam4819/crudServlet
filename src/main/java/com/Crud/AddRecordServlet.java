package com.Crud;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddRecordServlet", urlPatterns = {"/addrecord"})
public class AddRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        Database database=new Database();
        int id= Integer.parseInt(request.getParameter("idbox"));
        String name= request.getParameter("namebox");
        String email=request.getParameter("emailbox");
        String address= request.getParameter("addressbox");

        try {
            database.makeConnection();
            try{
                database.st.executeUpdate("insert into dataaddition(id, name ,email, address) values('" + id + "','" + name + "','" + email + "','"+address+"')");

                RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect("Update.jsp");
            }catch(SQLException sq){
                out.println("connection made but not inserted");
                System.out.println("connection made but not inserted");
            }
        } catch (Exception e) {
            out.println("connection not made");
            System.out.println("connection not made");
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
