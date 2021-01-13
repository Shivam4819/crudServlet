package com.Crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "DisplayServlet" , urlPatterns = {"/display"})
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Database database=new Database();
        int id=Integer.parseInt(request.getParameter("idbox"));
        String name=null;
        String email=null;
        String address=null;
        try {
            database.makeConnection();
            try {
                database.rs=(ResultSet) database.st.executeQuery("SELECT * from dataaddition where id='"+id+"'");
                while (database.rs.next()){
                    System.out.println("in while loop");
                    name=database.rs.getString("name");
                    email= database.rs.getString("email");
                    address=database.rs.getString("address");
                    out.println("name is-"+name);
                    out.println("email is-"+email);
                    out.println("address is- "+address);
                }



            }catch (SQLException s){
                System.out.println(s);
                System.out.println("error");
            }
        }catch (Exception e){
            System.out.println("not connected");
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
