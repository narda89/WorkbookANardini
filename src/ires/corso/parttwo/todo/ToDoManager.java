package ires.corso.parttwo.todo;

import java.util.Scanner;

// GRUPPO 2:
public class ToDoManager
{

    // - ha al suo interno funzioni di controllo sull'input utente

    public static void createNewToDo() {

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
        //ToDo daModificare = new ToDo(ToDoRepository.get_data().get(ID));
        //System.out.println("Quale campo vuoi modificare?");
        //System.out.println("[Prova: modifico il campo STATUS in ANNULLATO]");
        //daModificare.setToDoStatus(ToDo.Status.valueOf("ANNULLATO"));
        //ToDoRepository.get_data().put(ID, daModificare);
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
                    return;
                }
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("2")));
    }

    public static void toDoManagerMenu() {
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
                System.out.println("Yet to be implemented");
            } else if (choice.equals("2")) {
                // Delete To-Do Method
                deleteToDo();
            } else if (choice.equals("3")) {
                // Modify To-Do method
                System.out.println("Coming soon");
                updateToDo();

            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("4")));

        return;
    }

    public static void toDoManagerSubMenu(ToDo td) {
        System.out.printf(  "[1] Edit title\n" +
                "[2] Edit description\n" +
                "[3] Edit priority\n" +
                "[4] Edit status\n");

    }
}

