package ires.corso.parttwo.todo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class TestToDo {

    public static void main(String[] args) throws IOException, ParseException {

        //System.out.println(ToDoRepository.repoSize());
        Scanner scan = new Scanner(System.in);
        String choice = null;

        System.out.printf(  "===================================================\n" +
                "||                  TODO MANAGER                 ||\n" +
                "===================================================\n\n");
        do {
            System.out.println( "---------------------------------------------------\n" +
                    "|                    main menu                    |\n" +
                    "---------------------------------------------------\n");

            System.out.printf(  "[1] Import from / Export to file\n"    +
                    "[2] Show Data\n"   +
                    "[3] Add/Modify/Delete Data\n"  +
                    "[4] Exit\n");

            choice = scan.nextLine();

            if (choice.equals("4")) {
                System.out.println("Closing program...");
                continue;
            }
            if(choice.equals("1")) {
                // call to Import/Export menu method
                ToDoImportExport.ToDoImportExportMenu();
            } else if(choice.equals("2")) {
                // call to Show Data menu method
                ToDoList.ToDoListMenu();
            } else if(choice.equals("3")) {
                // call to Add/Modify/Delete menu method
                ToDoManager.toDoManagerMenu();
            } else {
                System.out.println("Invalid input. Please insert valid input.");
            }
        } while(!(choice.equals("4")));
    }
}