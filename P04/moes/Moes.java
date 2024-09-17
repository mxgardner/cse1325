package moes;

import java.util.ArrayList;
import product.Media;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;

public class Moes{
    private ArrayList<Media> library = new ArrayList<>(); 
    private ArrayList<Student> customers = new ArrayList<>();

    public void addMedia(Media media) {
        library.add(media);
    }
    
    public void getMediaList() {
        StringBuilder mediaList = new StringBuilder();  
        for (int i = 0; i < library.size(); i++) {
            mediaList.append(i)
                    .append(": ")
                    .append(library.get(i).toString())
                    .append("\n");
        }
    }

    public void addStudent(Student student) {
        customers.add(Student);
    }

    public void getStudentList() {
        StringBuilder studentList = new StringBuilder();  
        for (int i = 0; i < student.size(); i++) {
            studentList.append(i)
                    .append(": ")
                    .append(student.get(i).toString())
                    .append("\n");
        }
    }    

    public int getPoints(int studentIndex) {
        Account account = customers.get(studentIndex);
        
        if (account instanceof Alacarte) {
            Alacarte alacarteAccount = (Alacarte) account;  // Cast to Alacarte
            return alacarteAccount.getPointsRemaining();
        }
        
        if (account instanceof Unlimited) {
            return Integer.MAX_VALUE;  // Unlimited points
        }

        throw new UnsupportedOperationException("Unknown subclass of Account");
    }
}