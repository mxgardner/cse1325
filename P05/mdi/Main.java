package mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import java.util.Scanner;

public class Main{

    private Moes moes = new Moes();
    private Menu menu = new Menu();
    private String output = "";
    private Scanner scanner = new Scanner(System.in);

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

    }

    private void listStudents(){
        output += moes.getStudentList() + "\n";
    }

    private void addMedia(){
        String mediaTitle = Menu.getString(scanner, "\nTitle? ");
        String mediaURL = Menu.getString(scanner, "\nURL? ");
        int mediaPoints = Menu.getInt(scanner, "\nPoints? ");

        Media media = new Media(mediaTitle, mediaURL, mediaPoints);
        moes.addMedia(media);
        output += "Media added: " + mediaTitle + "\n";
    }

    private void playMedia(){
        listStudents();
        int studentIndex = Menu.getInt(scanner, "\nStudent Index? ");
        listMedia();
        int mediaIndex = Menu.getInt(scanner, "\nMedia Number? ");
        moes.playMedia(studentIndex, mediaIndex);
        output += "Media played for student " + studentIndex + "\n";
    }

    private void listMedia(){
        output += moes.getMediaList() + "\n";
    }

    private void listAvailablePoints(){
        listStudents();
        int studentIndex = Menu.getInt(scanner, "\nStudent Index? ");
        int availablePoints = moes.getPoints(studentIndex);
        output += "Available points for student " + studentIndex + ": " + availablePoints + "\n";
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
    }

    public void endapp(boolean running){
        running = false;
    }

    public void mdi(){
        Menu menu = new Menu();

        menu.addMenuItem("Exit", this::endapp);

        menu.addMenuItem("Play Media", this::playMedia);
        menu.addMenuItem("List Media", this::listMedia);
        menu.addMenuItem("List Available Points", this::listAvailablePoints);
        menu.addMenuItem("Buy Points", this::buyPoints);
        menu.addMenuItem("Add Media", this::addMedia);


        menu.addMenuItem("Add Student", this::addStudent);
        menu.addMenuItem("List Students", this::listStudents);

        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu =====");
            System.out.print(menu);
    
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextInt();
    
            menu.run(choice);
        }

    }

    public static void main(String args[]){
        Main app = new Main();
        app.mdi();
    }
    
}