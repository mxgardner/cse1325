package test;

import moes.Moes;
import customer.Alacarte;
import customer.Unlimited;
import customer.Student;
import product.Media;
import java.util.Scanner;
import customer.Account;

public class CheckP04{
    public static void main(String[] args){
        Moes moes = new Moes();
        Scanner sc = new Scanner(System.in);

        // Add media to library
        Media media1 = new Media("More Than You Ever Wanted to Know About Tape", "https://youtu.be/W0sAR_jI4b8?si=AxYqop_C4eUoSSYg", 3);
        Media media2 = new Media("Y2K - Threat to Bank Accounts (1999)", "https://texasarchive.org/2020_00057", 5);
        moes.addMedia(media1);
        moes.addMedia(media2);

        // Add Students
        //Alacarte alacarteAccount = new Alacarte(0); 
        Student bigAl = new Student("Al Capone", 1234567891L, "cc7891@uta.edu", false);
        //Unlimited unlimitedAccount = new Unlimited(); 
        Student  iNewton = new Student("I. Newton", 314159265, "in7890@uta.edu", true);
        
        moes.addStudent(bigAl);
        moes.addStudent(iNewton);

        // Buy points
        System.err.printf("\nBuy how many points for Big Al? ");
        int points = sc.nextInt();
        moes.buyPoints(0, points);

        // List users
        System.out.printf("\nMOES Users:\n");
        for (int i = 0; i < moes.getStudentList().size(); i++) {
            Student student = moes.getStudentList().get(i);
            System.out.printf("%d: %s\n", i, student.toString());
        }


        // Choose user
        System.out.printf("\nWhich user? ");
        int userIndex = sc.nextInt();
        System.out.println("Available points: " + moes.getPoints(userIndex));

        // List media
        System.out.printf("\nMOES Media:\n");
        for (int i = 0; i < moes.getMediaList().size(); i++) {
            System.out.println(i + ": " + moes.getMediaList().get(i).toString());
        }

        // Choose media
        System.out.printf("\nWhich media? ");
        int mediaIndex = sc.nextInt();
        moes.playMedia(userIndex, mediaIndex);

         // Check and print remaining points for the selected user
        Account account = moes.getStudentList().get(userIndex).getAccount();
        if (account instanceof Alacarte) {
            // Call getPointsRemaining directly on the Alacarte account
            System.out.println("Points remaining: " + ((Alacarte) account).getPointsRemaining());
        } else if (account instanceof Unlimited) {
            System.out.println("Points remaining: " + Integer.MAX_VALUE);
        }

        sc.close();
    }
}