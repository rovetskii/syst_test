package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataBaseObjects.student;
import DataBaseObjects.test;
import Services.DataBaseService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class FileServices {
    
   
    
    public String testfile(String[] res, String user, HttpServletRequest request, String[] answers1)
    {
           File[] stattext=null;  
               String uploadFilePath0=null;
               String uploadFilePath=null;
               
        try {
            
   String applicationPath = request.getServletContext().getRealPath("");
   uploadFilePath0=applicationPath + File.separator + "uploads"+ File.separator + user;
 //  del_directory(new File(uploadFilePath0));   
   uploadFilePath = applicationPath + File.separator + "uploads"+ File.separator + user+ File.separator+"src";
     String uploadFilePath1 = applicationPath + File.separator + "uploads"+ File.separator + user+ File.separator+"bin";
   
     File file = new File(uploadFilePath);
     File file1 = new File(uploadFilePath1);
                         if (!file.exists()) 
                        file.mkdirs();
                         if (!file1.exists()) 
                        file1.mkdirs();
                         
     
                stattext=new File[res.length];
            for (int i=0; i<res.length; i++)
           {
              stattext[i] = new File(uploadFilePath + File.separator + answers1[i]);
           FileOutputStream  fos = new FileOutputStream(stattext[i]);
        
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            //FileWriter w=new FileWriter(stattext);
            Writer w=new BufferedWriter(osw);
             w.write(res[i]);
           // w.flush();
            w.close();
            
            
           }
           
        } 
       catch (FileNotFoundException ex) {
            Logger.getLogger(FileServices.class.getName()).log(Level.SEVERE, null, ex);
        }
      catch (IOException ex) {
            Logger.getLogger(FileServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       return uploadFilePath0;
     //return uploadFilePath;
    }
    
    
    
    public void readfile(String s, String[]answer1) 
    {
        System.out.println("s="+s);
List<String> list=new ArrayList<String>();
String  answer1_sub=null;
int k=0;
 ProcessBuilder pb = new ProcessBuilder();
  Process pr=null;
for (int i=0; i<answer1.length;i++)
{
            try {
                list.clear();
//list1.clear();
System.out.println("length="+answer1[i].length());
System.out.println("answer1[0]"+answer1[i]);

 
list.add("cmd");
list.add("/c");
list.add("javac -d bin src/"+answer1[i]);


// create the process builder
pb.command(list);
pb.directory(new File(s));
// ProcessBuilder pb1 = new ProcessBuilder(list1);
 
//  pb1.directory(new File(s));

//  System.out.println(pb.command());
// System.out.println( pb1.command());
pr=pb.start();
pr.destroy();

            }
            catch (IOException ex) {
                Logger.getLogger(FileServices.class.getName()).log(Level.SEVERE, null, ex);
            }

    } 

    }
    
    
    public int java_run(String s, String[]answer1)
    {
   List<String> list=new ArrayList<String>();
    LinkedList<String> res=new LinkedList<String>();

   String  answer1_sub=null;
   
int k=0;
ProcessBuilder pb = new ProcessBuilder();    
Process pr=null;
InputStream is=null;
InputStreamReader isr=null;
BufferedReader br=null;
 for (int i=0; i<answer1.length;i++)
 {
 try {
     list.clear();


     char[] symbols=answer1[i].toCharArray();
for (int j=0; j<symbols.length; j++)
    if (symbols[j]=='.')
    {
        answer1_sub=answer1[i].substring(0, j);
       break;
    }
System.out.println("answer1_sub="+answer1_sub); 
    
list.add("cmd");
list.add("/c");
//list1.add("java " + answer1_sub);
list.add("java -classpath ./bin "+ answer1_sub+"."+answer1_sub);

pb.command(list);
     pb.directory(new File(s));
       
           pr=pb.start();
           is = pr.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        String line=new String();
        while ((line = br.readLine()) != null) 
        {
            res.add(line);
        if (line.equals("true")) k++;
        }          
    for (String st:res)  
       System.out.println("st="+i+st);
     System.out.println("");
    res.clear();    
   
       } catch (IOException ex) {
           Logger.getLogger(FileServices.class.getName()).log(Level.SEVERE, null, ex);
       }
//      Process pr1=pb1.start();   
        
 }
  pr.destroy();
 System.out.println("k="+k);
   
        return k;

    }
    
    public void del_directory(File f)
    {
    //del_directory(new File(path));
    
    if (!f.exists()) 
        return;
    
    if (f.isDirectory())
        for (File f1:f.listFiles())
    del_directory(f1);
     
    f.delete();
        System.out.println("файл видалено");
    
    }
   
    
    
}
    
    
    

    
 