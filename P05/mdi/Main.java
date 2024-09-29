package mdi;

import moes;
import customer;
import product;
import java.util.Scanner;

public class Main{
    private moes = new Moes;
    private String output;
    private menu = new Menu;
    private boolean running;
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

    }

    private void listMedia(){

    }

    private void listAvailablePoints(){

    }

    private void buyPoints(){

    }

    public Main {
        public static void main(String args[]){

        }

        public void mdi(){

        }

        public void endapp(){

        }
    }
}