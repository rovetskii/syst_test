/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataBaseObjects.student;
import Services.DataBaseService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
 
DataBaseService db=new DataBaseService();

 
/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
String login=null;
String password=null;
String family=null;
String name=null;
String grup=null;
String sql=null;
student st=null;
LinkedList<student> list=null;
String buttonuser=request.getParameter("user");
  String buttonsave=request.getParameter("save");
//request.setAttribute("contextdb", contextdb);

//request.getSession().setAttribute("contextdb",db);
        if (buttonuser!=null)
        {
         login=request.getParameter("login");
     password=request.getParameter("password");
//знайти в бд і якщо він існує дати йому сторінку 
          if ((st=db.search(login, password))!=null)
          {
            
           request.getSession().setAttribute("student", st);
          if (st.getLogin().equals("admin"))
          request.getRequestDispatcher("Admin.jsp").forward(request, response); 
             
           request.getRequestDispatcher("Account.jsp").forward(request, response); 
          }
          else
            response.getWriter().println("<h1>Невірний логін. Зареєструйтесь будь-ласка </h1>");    
          
        }
                     
        if (buttonsave!=null)
        {
     login=request.getParameter("login");
     password=request.getParameter("password");
 family=request.getParameter("family");
 name=request.getParameter("name");
 grup=request.getParameter("grup");
  if (!db.search_login(login))
 {
 sql="Insert Into student(login, password, family, name, grup) values (?,?,?,?,?)";
 request.getRequestDispatcher("SuccessAccount.jsp").forward(request, response);
     db.insertdb(sql,login, password, family, name, grup);
 
 }       
 else  response.getWriter().println("<h1>Цей логін вже існує. Введіть інший</h1>");
 
        }
         
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
