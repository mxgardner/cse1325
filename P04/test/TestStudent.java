package test;

import customer.Student;
import customer.Alacarte;
import customer.Account;
import product.Media;
import customer.Unlimited;

public class TestStudent {
    public static void main(String[] args) {
        int failures = 0;

        // Test Student constructor
        try {
            Student student = new Student("Prof Rice", 1001234567L, "george.rice@uta.edu", false);  // Not unlimited
            String expectedToString = "Prof Rice (1001234567, george.rice@uta.edu, Account #" + student.getAccount().getAccountNumber() + ")";
            String actualToString = student.toString();

            if (!actualToString.equals(expectedToString)) {
                System.err.println("FAIL: Expected toString '" + expectedToString + "', but got '" + actualToString + "'");
                failures |= 0b001;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 1: " + e.getMessage());
            failures |= 0b001;
        }

        // Test valid email
        try {
            Student invalidStudent = new Student("Jane Doe", 1009876543L, "jane.doe@gmail.com", false);
            System.err.println("FAIL: Expected IllegalArgumentException for non-UTA email, but none was thrown");
            failures |= 0b010;
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Non-UTA email address: jane.doe@gmail.com";
            if (!e.getMessage().equals(expectedMessage)) {
                System.err.println("FAIL: Expected message '" + expectedMessage + "', but got '" + e.getMessage() + "'");
                failures |= 0b010;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Expected IllegalArgumentException, but got a different exception: " + e.getMessage());
            failures |= 0b010;
        }

        // Test play function with insufficient points
        try {
            Media media = new Media("Sample Title", "https://example.com", 0);
            Student student = new Student("Prof Rice", 1001234567L, "george.rice@uta.edu", false);
            String expectedPlayResult = "Uh oh, You need more points! This media requires 100. You have 0.";
            String actualPlayResult = student.requestMedia(media);  // Using requestMedia method

            if (!actualPlayResult.equals(expectedPlayResult)) {
                System.err.println("FAIL: Expected play result '" + expectedPlayResult + "', but got '" + actualPlayResult + "'");
                failures |= 0b100;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 3: " + e.getMessage());
            failures |= 0b100;
        }

        // Test adding points and then playing the media
        try {
            Media media = new Media("Sample Title", "https://example.com", 0);
            Student student = new Student("Prof Rice", 1001234567L, "george.rice@uta.edu", false);

            // Adding points (you need to cast to Alacarte to add points)
            if (student.getAccount() instanceof Alacarte) {
                ((Alacarte) student.getAccount()).buyPoints(100);  // Add 100 points to Alacarte account
            }

            // Test play after points have been added
            String expectedPlayResult = "Playing Media [Title: Sample Title, URL: https://example.com, Customer Points: 0]";
            String actualPlayResult = student.requestMedia(media);  // Using requestMedia method

            if (!actualPlayResult.equals(expectedPlayResult)) {
                System.err.println("FAIL: Expected play result '" + expectedPlayResult + "', but got '" + actualPlayResult + "'");
                failures |= 0b100;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 4: " + e.getMessage());
            failures |= 0b100;
        }

        // Test Unlimited account playing without point restriction
        try {
            Media media = new Media("Unlimited Media", "https://example.com/unlimited", 0);
            Student studentWithUnlimited = new Student("Unlimited User", 314159265L, "unlimited@uta.edu", true);  // Unlimited account

            String expectedPlayResult = "Playing Media [Title: Unlimited Media, URL: https://example.com/unlimited, Customer Points: 0]";
            String actualPlayResult = studentWithUnlimited.requestMedia(media);  // Using requestMedia for Unlimited

            if (!actualPlayResult.equals(expectedPlayResult)) {
                System.err.println("FAIL: Expected play result for Unlimited account '" + expectedPlayResult + "', but got '" + actualPlayResult + "'");
                failures |= 0b1000;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 5: " + e.getMessage());
            failures |= 0b1000;
        }

        if (failures == 0) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("There were " + Integer.bitCount(failures) + " test failure(s).");
        }
    }
}



