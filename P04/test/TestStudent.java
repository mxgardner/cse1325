package test;

public class TestStudent {
    public static void main(String[] args) {
        int failures = 0; 
        
        try {
            Student student = new Student("Prof Rice", 1001234567L, "george.rice@uta.edu");
            String expectedToString = "Prof Rice (1001234567, george.rice@uta.edu, Account #" + student.getAccountNumber() + ")";
            String actualToString = student.toString();

            if (!actualToString.equals(expectedToString)) {
                System.err.println("FAIL: Expected toString '" + expectedToString + "', but got '" + actualToString + "'");
                failures |= 0b001; 
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 1: " + e.getMessage());
            failures |= 0b001; 
        }

        try {
            Student invalidStudent = new Student("Jane Doe", 1009876543L, "jane.doe@gmail.com");
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

        try {
            Media media = new Media("Sample Title", "https://example.com");
            Student student = new Student("Prof Rice", 1001234567L, "george.rice@uta.edu");
            String expectedPlayResult = "Playing Media [Title: Sample Title, URL: https://example.com]";
            String actualPlayResult = student.requestMedia(media);

            if (!actualPlayResult.equals(expectedPlayResult)) {
                System.err.println("FAIL: Expected requestMedia result '" + expectedPlayResult + "', but got '" + actualPlayResult + "'");
                failures |= 0b100; 
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception in Test 3: " + e.getMessage());
            failures |= 0b100; 
        }

        if (failures == 0) {
            System.exit(0);
        } else {
            System.exit(failures);
        }
    }
}
