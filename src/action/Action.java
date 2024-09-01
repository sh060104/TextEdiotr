package action;

import java.time.LocalDateTime;

public class Action {
    private int actionId;
    private LocalDateTime dateTime;
    int lineNo;
    String text;
    boolean isAddition;
    
    public Action(int actionId,LocalDateTime dateTime,int lineNo,boolean isAddition,String text){
        this.actionId=actionId;
        this.dateTime=dateTime;
        this.isAddition=isAddition;
        this.text=text;
        this.lineNo=lineNo;
    }
     

    public void setactionId(int actionId){
        this.actionId=actionId;
    }
    public int   getActionId(){
        return actionId;
    }

    public void  setdateTime(LocalDateTime dateTime){
        this.dateTime=dateTime;
    }
    public LocalDateTime  getdateTime(){
        return dateTime;
    }

    public void setlineNo(int lineNo){
        this.lineNo=lineNo;
    }
    public int   getlineNo(){
        return lineNo;
    }

    public void setText(String text){
        this.text=text;
    }
    public String getText(){
         return text;
    }

    public void  setisAddition(boolean isAddition){
        this.isAddition=isAddition;
    }
    public  boolean getisAddition(){
        return false;
    }

}
