/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataBaseObjects.student;
import DataBaseObjects.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DataBaseService {
    
    static Connection con=null;
    
    public  void getConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root", "Fcbcntynkrf1234");
           System.out.println("Connection success");
                } 
        catch (ClassNotFoundException ex) {
               System.out.println("Class not found");
            }
        catch (SQLException ex) {
            System.out.println("Connection SQL false");
        }
    
   // return con;
    
    }
    
    public void insertdb(String sql, String login, String password, String family, String name, String grup) 
    {
    if (con==null) getConnection();
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, login);
            st.setString(2, password);
            st.setString(3, family);
            st.setString(4, name);
            st.setString(5, grup);
            st.executeUpdate();
            st.close();
            System.out.println("Insert success");
        } catch (SQLException ex) {
            System.out.println("Insert SQL false");
        }
    
    }
    
      public void insert_res_text(String sql, String res_text, String login) 
    {
    if (con==null) getConnection();
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, res_text);
            st.setString(2, login);
            st.executeUpdate();
            System.out.println("Update res_text success");
            st.close();
        } catch (SQLException ex) {
            System.out.println("Update res_text SQL false");
        }
    
    }
    
    public student search(String login, String password)
    {
      //  student st=new student(login, password);
    LinkedList<student> list=new LinkedList<student>();
       list=readall();
    for (student st:list)
       if (st.getLogin().equals(login)& st.getPassword().equals(password)) 
           return st;
       //if (list.contains(st)) return true;
     return null;
    }
    
    public boolean search_login(String login)
    {
      //  student st=new student(login, password);
    LinkedList<student> list=new LinkedList<student>();
       list=readall();
    for (student st:list)
       if (st.getLogin().equals(login)) 
           return true;
       //if (list.contains(st)) return true;
     return false;
    }
    
    
    public LinkedList<student> readall()
    {
    if (con==null) getConnection();
     LinkedList<student> list=null; 
    try {
            String sql="Select * from student";
            PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
      list=new LinkedList<student>();
        while (rs.next())
        {
        student s=new student(rs.getInt("id"),rs.getString("login"), rs.getString("password"), rs.getString("family"),rs.getString("name"), rs.getString("grup"));
        list.add(s);
                }
            System.out.println("red success");
st.close();
rs.close();
    } catch (SQLException ex) {
            System.out.println("Read SQL false");
        }
    
return list;  
    }
    
        public student readstudent_res(String sql, String login)
        {
        
         if (con==null) getConnection();
            student s=null;
    try {
                       PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, login);
        ResultSet rs=st.executeQuery();
          while (rs.next())
             s=new student(rs.getString("res_test"));
       
              
            System.out.println("red success");
st.close();
rs.close();
    } catch (SQLException ex) {
            System.out.println("Read SQL false");
        }
    
return s;  
        
        
        }
    
    
    
      public void insertdbtest(String sql, String quest, int level, String answer, String answer1) 
    {
  if (con==null) getConnection();
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, quest);
            st.setInt(2, level);
            st.setString(3, answer);
            st.setString(4, answer1);
            
             st.executeUpdate();
             st.close();
            System.out.println("Insert test success");
        } catch (SQLException ex) {
            System.out.println("Insert test SQL false");
        }
    
    }
     

     
          public LinkedList<test> readtest(String sql, int level)
    {
   if (con==null) getConnection();
     LinkedList<test> list=null; 
    try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, level);
        ResultSet rs=st.executeQuery();
      list=new LinkedList<test>();
        while (rs.next())
        {
        test s=new test(rs.getInt("id"),rs.getString("quest"), rs.getInt("level"), rs.getString("answer"),rs.getString("answer1"));
        list.add(s);
           }
        st.close();
        rs.close();
        System.out.println("red test success");    
        } catch (SQLException ex) {
            System.out.println("Read test SQL false");
        }
    
        return list;  
    }

    

           public LinkedList<test> readalltest()
    {
   if (con==null) getConnection();
     LinkedList<test> list=null; 
    try {
        String sql="Select * from test";    
        PreparedStatement st=con.prepareStatement(sql);
            
        ResultSet rs=st.executeQuery();
      list=new LinkedList<test>();
        while (rs.next())
        {
        test s=new test(rs.getInt("id"),rs.getString("quest"), rs.getInt("level"), rs.getString("answer"),rs.getString("answer1"));
        list.add(s);
           }
        st.close();
        rs.close();
        System.out.println("red test success");    
        } catch (SQLException ex) {
            System.out.println("Read test SQL false");
        }
    
        return list;  
    }
           
           public void insert_result_test(String sql,int id_student, int id_test, String result)
         {
           if (con==null) getConnection();
           try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id_student);
            st.setInt(2, id_test);
            st.setString(3, result);
              st.executeUpdate();
             st.close();
            System.out.println("Insert result test success");
        } catch (SQLException ex) {
            System.out.println("Insert result test SQL false");
        }}}
