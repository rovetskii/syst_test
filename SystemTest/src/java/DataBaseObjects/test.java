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
public class test {
    int id;
  String quest;
  int level;
String answer;
String answer1;


   public test(int id, String quest, int level, String answer, String answer1) {
       this.id=id;
       this.quest = quest;
        this.level = level;
        this.answer = answer;
        this.answer1 = answer1;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

  public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
 
    
}
