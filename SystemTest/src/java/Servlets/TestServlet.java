/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataBaseObjects.student;
import DataBaseObjects.test;
//import FileService.Test;
import Services.FileServices;

import Services.DataBaseService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

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
  
  // TestService  testdb=new TestService();
    String admin_test=request.getParameter("admin_test");
        String test_student=request.getParameter("test_student");
String answer_test=request.getParameter("answer_test");
     //  System.out.println("answer_test="+test_student);
 
       String value=request.getParameter("test");
       
       String quest=null;
       String answer=null;
       String answer1=null;
       LinkedList<test> list=null;
      String sql=null; 
      
   //request.getSession().setAttribute("flag", true);
     if (admin_test!=null)
         //зчитати дані та записати їх
     {
    quest=request.getParameter("quest");
   answer=request.getParameter("answer");
      answer1=request.getParameter("answer1");
        // System.out.println("quest="+quest);
          //     System.out.println(answer1);
      sql="Insert Into test (quest, level, answer, answer1) values (?,?,?,?)";
       db.insertdbtest(sql, quest, Integer.parseInt(value), answer, answer1);
      request.getRequestDispatcher("Admin.jsp").forward(request, response);
     //очистити поля
     
     
     }
     
     else if (test_student!=null)
     { 
    //  String flag=(String)request.getSession().getAttribute("flag");
       //  if (request.getSession().getAttribute("list")==null)
      //{   
    list=new LinkedList<test>(); 
       // if (flag.isEmpty())    
          sql="Select * from test where level=?";
             list=db.readtest(sql, Integer.parseInt(value) );
          
          //       String[] q=new String[list.size()];
           // String[] q1=new String[list.size()];
            
//            for (int i=0; i<list.size(); i++) 
//            for(test t:list)
//            {
//                q[i]=t.getQuest();
//            q1[i]=q[i].split("\n");
//            }
     
    
       //request.getSession().setAttribute("q", q1);     
            
       request.getSession().setAttribute("value", value);     
              request.getSession().setAttribute("list", list);
             // for(test t:list)
                  
              request.getSession().setAttribute("listsize", list.size());
              
           // request.getSession().setAttribute("list", list);  
          //  for (test t:list)
           // System.out.println(t.getAnswer1());
            
            if (value.equals("3"))
        request.getRequestDispatcher("test_code.jsp").forward(request, response);  
            else if (value.equals("2"))
    request.getRequestDispatcher("test_read.jsp").forward(request, response);              
          else
    request.getRequestDispatcher("test.jsp").forward(request, response);  
       
    // else
      //     request.getRequestDispatcher("Account.jsp").forward(request, response);
          
        }
  
    
     
     else if (answer_test!=null)
     {
        // list=new LinkedList<test>();
        String res_test=new String();        
        student st=(student)request.getSession().getAttribute("student");      
        String login=st.getLogin();
        String user =st.getFamily();
        // System.out.println("id="+id_student);
String v=(String)request.getSession().getAttribute("value");  
 list=(LinkedList<test>)request.getSession().getAttribute("list");
    //int [] id_test=new int[list.size()];    
    //for (int i=0; i< list.size();i++)
   //          System.out.println("res_test="+res_test);

// System.out.println("login="+login);
    if (v.equals("1")|(v.equals("2")))
    {
  
 for (test t:list)
     {   
     res_test+=request.getParameter(Integer.toString(t.getId()))+" ";
     }
         
        
        sql="Update student set res_test=? where login=?"; 
            db.insert_res_text(sql,  res_test, login); 
     sql="Select res_test from student where login=?";
           
     student s=db.readstudent_res(sql, login);
           String res=s.getRes_test();
         //char[]res1=res.toCharArray();
           String [] res1=res.split(" ");
                      System.out.println("res1_length="+res1.length);
                      for(int i=0; i<res1.length; i++)
                      System.out.println("res1[i]="+res1[i]);
                      
          sql="Select * from test where level=?";
           
              System.out.println("v="+v);
           list=db.readtest(sql,Integer.parseInt(v));
          String[]res2=new String[list.size()];
          System.out.println("res2_length="+res2.length);  
                       int k=0;
           
           for (int i=0; i<list.size();i++)
           {
          res2[i]=list.get(i).getAnswer();
            System.out.println("answer="+res2[i]);
        if (res2[i].equals(res1[i])) k++;
          }
            
            
                 String res3=null;   
           if (k!=res2.length) 
                  res3="Тест не пройдено";    
           else    
             res3="Тест пройдено";
            
          // System.out.println(res3);
           request.setAttribute("res_test", res3);
           //System.out.println("Кількість правильних відповідей=" + k);
           request.setAttribute("k", k);
          // request.getSession().setAttribute("flag", "false");
    }
     
    else
    {
         
 // Test test=new Test();
 // sql="Select * from test where level=?";
 // t.testjava(sql, Integer.parseInt(v),login);
      
        for (test t:list)
     {   
        res_test+=request.getParameter(Integer.toString(t.getId()))+"flag";
     }
 
        String[] res=res_test.split("flag");
        //for(int i=0; i<res.length; i++)
        //System.out.println("res="+res[i]);
        //зчитати правильні відповіді з бази даних оновити масив res
        sql="Select *from test where level=?";
        list=db.readtest(sql, Integer.parseInt(v));
        String[]res1=new String[list.size()];
         String[]answers=new String[list.size()];
        String[]answers1=new String[list.size()];
        
       for (int i=0; i<list.size();i++)
       {
      
            answers[i]=list.get(i).getAnswer();
            answers1[i]=list.get(i).getAnswer1();
                    
       // System.out.println("answer="+answers[i]);
        System.out.println("answers1="+answers1[i]); 
       }
       FileServices test=new FileServices();
       for (int i=0; i<list.size();i++)
       {
           res1[i]=res[i]+answers[i];
        System.out.println("res1="+res1[i]); 
      
       }
      String s=test.testfile(res1, user, request,answers1);
    test.readfile(s,answers1);
    int k=test.java_run(s, answers1);
//String res=null;
    if(k!=res.length) 
        
         request.setAttribute("res_test","Тест не пройдено" );
    else
         request.setAttribute("res_test","Тест  пройдено");
           //System.out.println("Кількість правильних відповідей=" + k);
           request.setAttribute("k", k);
      
      
       //sql="Insert into result (id_student, id_test, result) values (?,?,?)";
   // for (int i=0; i<list.size(); i++)
   // db.insert_result_test(sql, id_student, id_test[i], res[i]);
    }
     //перевірка коду
          
           request.getRequestDispatcher("ResultTest.jsp").forward(request, response);
     
     
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
            
     //   processRequest(request, response);
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
