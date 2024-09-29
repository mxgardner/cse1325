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
        System.out.printf("\nTitle? ");
        String mediaTitle = scanner.nextLine();

        System.out.printf("\nURL? ");
        String mediaURL = scanner.nextLine();

        System.out.printf("\nPoints? ");
        int mediaPoints = scanner.nextInt();

        Media media = new Media(mediaTitle, mediaURL, mediaPoints);

        moes.addMedia(media);

    }

    private void playMedia(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextInt();

        listMedia();
        System.out.printf("\nMedia Number? ");
        int mediaIndex = scanner.nextInt();

        moes.playMedia(studentIndex, mediaIndex);
    }

    private void listMedia(){
        System.out.println(moes.getMediaList);
    }

    private void listAvailablePoints(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextInt();

        int availablePoints = moes.getPoints(studentIndex);
        System.out.println("Available points: " + availablePoints);
    }

    private void buyPoints(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextInt();

        System.out.printf("\nPoints? ");
        int points = scanner.nextInt();

        moes.buyPoints(studentIndex, points);
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