/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseObjects;

/**
 *
 * @author Administrator
 */
public class student {
    int id;
 String login;
 String password;
 String family;
 String name;
 String grup;
 String res_test;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public student(int id, String login, String password,String family, String name, String grup) {
      this.id=id;
        this.family = family;
        this.name = name;
        this.grup = grup;
         this.login = login;
        this.password = password;
    }

    public student(String res_test) {
        this.res_test = res_test;
    }

 

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getRes_test() {
        return res_test;
    }

    public void setRes_test(String res_test) {
        this.res_test = res_test;
    }
 
    
}
