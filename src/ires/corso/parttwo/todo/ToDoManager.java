package ires.corso.parttwo.todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ToDoManager
{

    public static void createNewToDo() throws ParseException {
        String myTitle;
        String myDescription;
        ToDo.Priority myPriority;
        ToDo.Status myStatus;
        Date myStartDate;
        Date myEndDate;

        Scanner scan = new Scanner(System.in);
        int idNew = 0;
        if (ToDoRepository.repoSize() == 0) {
            idNew = 1;
        } else {
            Integer[] idIndex = new Integer[ToDoRepository.repoSize()];
            int j = 0;
            for(Integer i : ToDoRepository.get_data().keySet()) {
                idIndex[j] = i;
                j++;
            }
            Arrays.sort(idIndex);
            idNew = idIndex[idIndex.length - 1] + 1;
        }

        System.out.printf("Insert title: ");
        myTitle = scan.nextLine();
        System.out.println("Insert description: ");
        myDescription = scan.nextLine();
        System.out.println("Insert priority: ");
        myPriority = ToDo.Priority.valueOf(scan.nextLine());
        System.out.println("Insert status: ");
        myStatus = ToDo.Status.valueOf(scan.nextLine());
        System.out.println("Insert starting date: ");
        myStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
        System.out.println("Insert due date: ");
        myEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());

        ToDo myTd = new ToDo(idNew, myTitle, myDescription, myPriority, myStatus, myStartDate, myEndDate);
        ToDoRepository.add(myTd);
    }

    public static void deleteToDo() {
        String choice = null;
        do {
            System.out.printf(  " [1] Delete\n"   +
                    " [2] Back\n");

            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            if (choice.equals("2"))
                return;
            else if (choice.equals("1")) {
                System.out.printf("Insert ID of the ToDo you want to erase:");
                String sIDtoBeDeleted = scan.nextLine();
                Integer IDtoBeDeleted = null;
                try {
                    IDtoBeDeleted = Integer.parseInt(sIDtoBeDeleted);
                } catch (Exception e) {
                    System.out.println("Invalid input: please insert a number");
                    continue;
                }

                if (!(ToDoRepository.get_data().containsKey(IDtoBeDeleted)))
                    System.out.println("ID not found, cannot proceed.");
                else {
                    ToDoRepository.delete(IDtoBeDeleted);
                    System.out.println("Corresponding ToDo deleted.");
                    return;
                }
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("2")));
    }

    public static void updateToDo() {
        String choice = null;
        do {
            System.out.printf(  " [1] Update\n"   +
                                " [2] Back\n");

            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            if (choice.equals("2"))
                return;
            else if (choice.equals("1")) {
                System.out.printf("Insert ID of the ToDo you want to update:");
                String sIDtoBeDeleted = scan.nextLine();
                Integer IDtoBeUpdated = null;
                try {IDtoBeUpdated = Integer.parseInt(sIDtoBeDeleted);
                } catch (Exception e) {
                    System.out.println("Invalid input: insert a number");
                }

                if (!(ToDoRepository.get_data().containsKey(IDtoBeUpdated)))
                    System.out.println("ID not found, cannot proceed.");
                else {
                    ToDo tdOriginal = ToDoRepository.getToDoFromID(IDtoBeUpdated);
                    ToDo tdCopy = new ToDo(tdOriginal);
                    System.out.println("ToDo requested:");
                    tdCopy.prettyPrint();
                    System.out.println("How do you whish to proceed?");
                    // submenu su quali campi modificare
                    toDoManagerSubMenu(tdCopy);
                    return;
                }
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("2")));
    }

    public static void toDoManagerMenu() throws ParseException {
        String choice = null;
        do {
            System.out.println( "---------------------------------------------------\n" +
                                "|             Add/Modify/Delete menu              |\n" +
                                "---------------------------------------------------\n");

            Scanner scan = new Scanner(System.in);

            System.out.printf(  "[1] Add ToDo\n"    +
                                "[2] Delete ToDo\n" +
                                "[3] Modify ToDo\n" +
                                "[4] Back\n");

            choice = scan.nextLine();

            if (choice.equals("4"))
                return;
            else if (choice.equals("1")) {
                // Add To-Do Method
                createNewToDo();
            } else if (choice.equals("2")) {
                // Delete To-Do Method
                deleteToDo();
            } else if (choice.equals("3")) {
                // Modify To-Do method
                //System.out.println("Coming soon");
                updateToDo();
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("4")));

        return;
    }

    public static void toDoManagerSubMenu(ToDo td) {
        String choice = null;

        do {
            System.out.printf(  "[1] Edit title\n" +
                                "[2] Edit description\n" +
                                "[3] Edit priority\n" +
                                "[4] Edit status\n" +
                                "[5] Edit start date\n" +
                                "[6] Edit due date\n" +
                                "[7] Back\n");

            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            if (choice.equals("7"))
                return;
            else if (choice.equals("1")) {
                System.out.printf("Enter new title (old title -> %s):\n", td.getToDoTitle());

            } else if (choice.equals("2")) {
                System.out.printf("Enter new description (old description -> %s):\n", td.getToDoDescription());

            } else if (choice.equals("3")) {
                System.out.printf("Enter new priority (old priority -> %s):\n", td.getToDoPriority());

            } else if (choice.equals("4")) {
                System.out.printf("Enter new priority (old priority -> %s):\n", td.getToDoStatus());

            } else if (choice.equals("5")) {
                System.out.printf("Enter new priority (old priority -> %s):\n", td.getStartDate());

            } else if (choice.equals("6")) {
                System.out.printf("Enter new priority (old priority -> %s):\n", td.getEndDate());

            } else
                System.out.println("Invalid input. Please insert valid input.");

        }while(!(choice.equals("7")));

    }
}

