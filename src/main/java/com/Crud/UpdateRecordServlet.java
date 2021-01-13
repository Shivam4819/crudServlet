package com.Crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdateRecordServlet", urlPatterns = {"/updaterecord"})
public class UpdateRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Database database=new Database();
        PrintWriter out=response.getWriter();
        int id= Integer.parseInt(request.getParameter("idbox"));
        String names= request.getParameter("namebox");
        String email=request.getParameter("emailbox");
        String address= request.getParameter("addressbox");

        try{
            database.makeConnection();
            try {
                database.st.executeUpdate("UPDATE dataaddition SET email = '"+email+"' ,address='"+address+"',name='"+names+"' where id ='"+id+"'");
                out.println("updated ");
            }catch (SQLException s){
                System.out.println(s);
                System.out.println("sql exception");
            }
        }catch (Exception e){
            System.out.println("not conected");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
