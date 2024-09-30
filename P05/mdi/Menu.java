/*
Menu Manager Copyright (c) 2024 Professsor George F. Rice

Licensed under The MIT License (MIT)

Summary: Basically, you can do whatever you want as long as you include 
this copyright and license notice in any copy of the software/source.

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION 
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package mdi;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

// This class manages the entire menu and dispatch table
public class Menu {
    private List<MenuItem> items = new ArrayList<>();

    // Allow adding a menu item with text and action (Runnable)
    public void addMenuItem(String menuText, Runnable menuResponse) {
        MenuItem item = new MenuItem(menuText, menuResponse);  // Create MenuItem with text and action
        items.add(item);  // Add to the list of items
    }

    // Static utility methods for getting input from the user
    public static String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            System.out.print(prompt);
            scanner.next(); // Clear invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return value;
    }

    // Display the menu to the user
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Group 1: Media Management
        sb.append(
                    "~~~~~~~~~~~~~~~~~~\n" + 
                    "|| Manage Media ||\n" + //
                    "~~~~~~~~~~~~~~~~~~\n");
        sb.append("1] Play Media\n");
        sb.append("2] List Media\n");
        sb.append("5] Add Media\n\n");

        // Group 2: Student Management
        sb.append(
        "~~~~~~~~~~~~~~~~~~~~~\n" + 
        "|| Manage Students ||\n" + //
        "~~~~~~~~~~~~~~~~~~~~~\n");
        sb.append("3] List Available Points\n");
        sb.append("4] Buy Points\n");
        sb.append("6] Add Student\n");
        sb.append("7] List Students\n\n");

        // Group 3: Exit
        sb.append(
        "~~~~~~~~~~\n" + 
        "|| Exit ||\n" + //
        "~~~~~~~~~~\n");
        sb.append("0] Exit\n\n");

        return sb.toString();
    }

    // Run the selected menu item by number
    public void run(int itemNumber) {
        if (itemNumber >= 0 && itemNumber < items.size()) {
            items.get(itemNumber).run();
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}


