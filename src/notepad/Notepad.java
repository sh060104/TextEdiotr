package notepad;
import action.Action;
import java.util.*;
import java.time.LocalDateTime;

public class Notepad {
    private int id=1;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipboard;
    private int capacity;

    public  Notepad(int capacity){
        notepad=new String[capacity];

        for(int i=0;i<capacity;i++){
            notepad[i]="";
        }

        undoAction=new Stack<>();
        redoAction=new Stack<>();
        clipboard=new LinkedList<>();
        this.capacity=capacity;
    }

    public void display(){
        for(int i=0;i<capacity;i++){
            System.out.println(notepad[i]);
        }
    }

    public void display(int startingline,int endingline){
        if(startingline < 0 || startingline > endingline || endingline > capacity){
            System.out.println("Unable to display the text plz check input");
            return;
        }
        for(int i=startingline-1;i<endingline;i++){
            System.out.println(notepad[i]);
        }
    }

    public void insertLine(int lineNo,String text){
        if(lineNo>capacity){
            System.out.println("notepad limit crossed");
            return;
        }
        notepad[lineNo-1]=text;
        undoAction.push(new Action(id++,LocalDateTime.now(),lineNo,true,text));
    }

    public void delete(int lineNo){
        if(lineNo>capacity){
            System.out.println("No such row to delete");
            return;
        }
        if(notepad[lineNo-1].isEmpty()){
            System.out.println("Nothing to delete");
            return;
        }
        redoAction.push(new Action(id++, LocalDateTime.now(), lineNo, false, notepad[lineNo-1]));
        notepad[lineNo-1]="";
    }
    public void delete(int startingline,int endingline){
        if(startingline>endingline){
            System.out.println("unable to delete ,please chack the input");
            return;
        }
        for(int i=startingline;i<=endingline;i++){
            delete(i);
        }
    }

    public void copy(int startingline,int endingline){
        if(startingline>endingline || endingline>capacity){
            System.out.println("Unable to copy");
            return;
        }
        String copyText="";
        for(int i=startingline-1;i<endingline;i++){
            copyText+=(notepad[i]+"\n");
            if(copyText.isEmpty())clipboard.add(copyText);
        }
    }
    
    public void paste(int lineNo){
        if(clipboard.isEmpty()){
            System.out.println("nothing to paste");
            return;
        }
        String text=clipboard.peek();
        insertLine(lineNo, text);
    }

    public void undo(){
        if(undoAction.isEmpty()){
            System.out.println("nothing to undo");
            return;
        }
        Action action=this.undoAction.peek();
        this.undoAction.pop();
        delete(action.getlineNo());
    }

    public void redo(){
        if(redoAction.isEmpty()){
            System.out.println("nothing to redo");
            return;
        }   
        Action action=redoAction.peek();
        redoAction.pop();
        insertLine(action.getlineNo(), action.getText());
    }
}
