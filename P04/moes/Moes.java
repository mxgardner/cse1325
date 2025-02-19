package moes;

import java.util.ArrayList;
import product.Media;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import customer.Account;

public class Moes{
    private ArrayList<Media> library = new ArrayList<>(); 
    private ArrayList<Student> customers = new ArrayList<>();

    public void addMedia(Media media) {
        library.add(media);
    }

    public void addStudent(Student student) {
        customers.add(student);
    }
    
    public ArrayList<Media> getMediaList() {
        return library;
    }

    public ArrayList<Student> getStudentList() {
        return customers;
    }  

    public int getPoints(int studentIndex) {
        Student student = customers.get(studentIndex); 
        Account account = student.getAccount(); 

        if (account instanceof Alacarte) {
            Alacarte alacarteAccount = (Alacarte) account;  // Cast to Alacarte
            return alacarteAccount.getPointsRemaining();
        }
        
        if (account instanceof Unlimited) {
            return Integer.MAX_VALUE;  // Unlimited points
        }

        throw new UnsupportedOperationException("Unknown subclass of Account");
    }

    // Buy points for the selected student's account
    public String buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex); 
        Account account = student.getAccount(); 
        
        // Check if the account is an instance of Alacarte
        if (account instanceof Alacarte) {
            Alacarte alacarteAccount = (Alacarte) account;  // Cast to Alacarte
            alacarteAccount.buyPoints(points);
            return "Student now has " + alacarteAccount.getPointsRemaining() + " points.";
        }

        // Check if the account is an instance of Unlimited
        else if (account instanceof Unlimited) {
            return "Student has an unlimited account and needs no additional points.";
        }

        // Throw exception for any other subclass
        else {
        throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

     // Play media for the selected student
    public void playMedia(int studentIndex, int mediaIndex) {
        Student student = customers.get(studentIndex); 
        Account account = student.getAccount(); 
        Media media = library.get(mediaIndex);

        if (account instanceof Alacarte) {
            Alacarte alacarteAccount = (Alacarte) account;
            System.out.println(alacarteAccount.play(media));  // Calls Alacarte's play method
        } else if (account instanceof Unlimited) {
            Unlimited unlimitedAccount = (Unlimited) account;
            System.out.println(unlimitedAccount.play(media));  // Calls Unlimited's play method
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account.");
        }
    }

}