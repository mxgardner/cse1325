package mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import java.util.Scanner;

public class Main{

    private Moes moes = new Moes;
    Scanner scanner = new Scanner(System.in);

    private void addStudent(){
        System.out.printf("\nStudent name? ");
        String studentName = scanner.nextLine();

        System.out.printf("\nStudent ID? ");
        long studentID = scanner.nextLine();

        System.out.printf("\nStudent email? ");
        String studentEmail = scanner.nextLine();

        System.out.printf("\n(a)lacarte or (u)nlimited ");
        String studentAccountType = scanner.nextLine();

        boolean studentUnlimited = false;
        if(studentAccountType.equals("u")){
            studentUnlimited = true;
        }
        else if(studentAccountType.equals("a")){
            studentUnlimited = false;
        }
        else{
            System.err.println("Invalid Account Type");
        }

        Student student = new Student(studentName, studentID, studentEmail, studentAccountType);

        Moes.addStudent(Student student);

    }

    private void listStudents(){
        System.out.println(Moes.getStudentList);
    }

    private void addMedia(){
        System.out.printf("\nTitle? ");
        String mediaTitle = scanner.nextLine();

        System.out.printf("\nURL? ");
        String mediaURL = scanner.nextLine();

        System.out.printf("\nPoints? ");
        int mediaPoints = scanner.nextLine();

        Media media = new Media(mediaTitle, output, mediaPoints);

        Moes.addMedia(Media media);

    }

    private void playMedia(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextLine();

        listMedia();
        System.out.printf("\nMedia Number? ");
        int mediaIndex = scanner.nextLine();

        Moes.playMedia(studentIndex, mediaIndex);
    }

    private void listMedia(){
        System.out.println(Moes.getMediaList);
    }

    private void listAvailablePoints(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextLine();

        int availablePoints = Moes.getPoints(studentIndex);
        System.out.println("Available points: " + availablePoints);
    }

    private void buyPoints(){
        listStudents();

        System.out.printf("\nStudent Index? ");
        int studentIndex = scanner.nextLine();

        System.out.printf("\nPoints? ");
        int points = scanner.nextLine();

        Moes.buyPoints(studentIndex, points);
    }

    public void endapp(boolean running){
        running = false;
    }

    public void mdi(){
        private Menu menu = new Menu();

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
            scanner.nextLine();
    
            menu.run(choice);
        }

    }

    public static void main(String args[]){
        Main app = new Main();
        app.mdi();

    }
    
}