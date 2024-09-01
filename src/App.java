import notepad.Notepad;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s=new Scanner(System.in);
        Notepad notepad=new Notepad(100);
        do{
            System.out.println("Choose your option :-");
            System.out.println("1.Display the text");
            System.out.println("2.Display the text from given lines");
            System.out.println("3.Insert the text");
            System.out.println("4.Delete the text");
            System.out.println("5.Delete the given lines");
            System.out.println("6.copy the text");
            System.out.println("7.paste the text");
            System.out.println("8.undo the action");
            System.out.println("9.redo the action");
            System.out.println("10.Exit");

            System.out.println("Enter the choice:");
            int choice=s.nextInt();
            switch (choice) {
                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("enter the starting line and ending line value");
                    int startingline=s.nextInt();
                    int endingline=s.nextInt();
                    notepad.display(startingline, endingline);
                    break;
                case 3:
                    
                    System.out.println("enter the line number :");
                    int lineNo=s.nextInt();
                    System.out.println("enter the text:");
                    String text=s.next();

                    notepad.insertLine(lineNo,text);
                    break;
                case 4:
                    System.out.println("enter the line number:");
                    lineNo=s.nextInt();
                    notepad.delete(lineNo);
                    break;
                case 5:
                    System.out.println("enter the starting line and ending line value");
                    startingline=s.nextInt();
                    endingline=s.nextInt();
                    notepad.delete(startingline, endingline);
                    break;
                case 6:
                    System.out.println("enter the starting line and ending line value");
                    startingline=s.nextInt();
                    endingline=s.nextInt();
                    notepad.copy(startingline, endingline);
                    break;
                case 7:
                    System.out.println("enter the line number:");
                    lineNo=s.nextInt();
                    notepad.paste(lineNo);
                    break;
                case 8:
                    notepad.undo();
                    break;
                case 9:
                    notepad.redo();
                    break;
                case 10:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }while(true);
    }
}
