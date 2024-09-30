package mdi;

import moes.Moes;
import customer.Student;
import mdi.PrettyPrintMenu;
import product.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private Moes moes = new Moes();
    private Menu menu = new Menu();
    private String output = "";
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    private void addStudent(){
        String studentName = Menu.getString(scanner, "\nStudent name? ");
        long studentID = Menu.getInt(scanner, "\nStudent ID? ");
        String studentEmail = Menu.getString(scanner, "\nStudent email? ");
        String accountType = Menu.getString(scanner, "\n(a)lacarte or (u)nlimited ");
        
        boolean studentUnlimited = false;
        if (accountType.equals("u")) {
            studentUnlimited = true;
        } else if (!accountType.equals("a")) {
            output += "Invalid account type.\n";
            return;
        }

        Student student = new Student(studentName, studentID, studentEmail, studentUnlimited);
        moes.addStudent(student);
        output += "Student added: " + studentName + "\n";

        System.out.println(output);
        output = "";
    }

    private void listStudents() {
    ArrayList<Student> students = moes.getStudentList();
    if (students.isEmpty()) {
        output += "No students available.\n";
    } else {
        output += "Student List:\n";
        for (int i = 0; i < students.size(); i++) {
            output += i + ": " + students.get(i).toString() + "\n";
        }
    }

    System.out.println(output);
    output = "";
}


    private void addMedia(){
        String mediaTitle = Menu.getString(scanner, "\nTitle? ");
        String mediaURL = Menu.getString(scanner, "\nURL? ");
        int mediaPoints = Menu.getInt(scanner, "\nPoints? ");

        Media media = new Media(mediaTitle, mediaURL, mediaPoints);
        moes.addMedia(media);
        output += "Media added: " + mediaTitle + "\n";

        System.out.println(output);
        output = "";
    }

    private void playMedia(){
        listStudents();
        int studentIndex = Menu.getInt(scanner, "\nStudent Index? ");
        listMedia();
        int mediaIndex = Menu.getInt(scanner, "\nMedia Number? ");
        moes.playMedia(studentIndex, mediaIndex);
        output += "Media played for student " + studentIndex + "\n";

        System.out.println(output);
        output = "";
    }

    private void listMedia() {
        ArrayList<Media> mediaList = moes.getMediaList();
        if (mediaList.isEmpty()) {
            output += "No media available.\n";
        } else {
            output += "Media List:\n";
            for (int i = 0; i < mediaList.size(); i++) {
                output += i + ": " + mediaList.get(i).toString() + "\n";
            }
        }

        System.out.println(output);
        output = "";
    }

    private void listAvailablePoints(){
        listStudents();
        int studentIndex = Menu.getInt(scanner, "\nStudent Index? ");
        int availablePoints = moes.getPoints(studentIndex);
        output += "Available points for student " + studentIndex + ": " + availablePoints + "\n";

        System.out.println(output);
        output = "";
    }

    private void buyPoints(){
        listStudents();
        int studentIndex = Menu.getInt(scanner, "\nStudent Index? ");
        int points = Menu.getInt(scanner, "\nPoints to buy? ");
        if (points > 0) {
            moes.buyPoints(studentIndex, points);
            output += "Bought " + points + " points for student " + studentIndex + "\n";
        } else {
            output += "Cannot buy negative or zero points.\n";
        }

        System.out.println(output);
        output = "";
    }

    private void endapp(){
        output += "Exiting the application...\n\n\n";
        System.out.println(output);
        output = "";

        output += " ,~~_\n";
        output += " |/\\ =_ _ ~\n";
        output += " _( )_( )\\~~\\\n";
        output += " \\,\\  _|\\ \\~~~\\\n";
        output += " \\`   \\\\\n";
        output += " `    ` \n";

        System.out.println(output);
        output = "";

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output += "\n    Mav out!\n";
        System.out.println(output);
        output = "";

        running = false;
    }

    public void mdi(){
        menu.addMenuItem("Exit", this::endapp);
        menu.addMenuItem("Play Media", this::playMedia);
        menu.addMenuItem("List Media", this::listMedia);
        menu.addMenuItem("List Available Points", this::listAvailablePoints);
        menu.addMenuItem("Buy Points", this::buyPoints);
        menu.addMenuItem("Add Media", this::addMedia);
        menu.addMenuItem("Add Student", this::addStudent);
        menu.addMenuItem("List Students", this::listStudents);

        new PrettyPrintMenu();
        System.out.print(menu);

        while (running) {
            int choice = Menu.getInt(scanner, "Choose an option: ");
            menu.run(choice);
        }

    }

    public static void main(String args[]){
        Main app = new Main();
        app.mdi();
    }
    
}