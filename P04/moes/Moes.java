package moes;

import java.util.ArrayList;
import product.Media;
import customer.Student;

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
}