package ires.corso.parttwo.todo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

// GRUPPO 1:
public class ToDoList
{
    public static void ToDoListMenu() throws IOException, ParseException {

        String choice = null;
        do {
            System.out.println( "---------------------------------------------------\n" +
                    "|                ToDo List/Show menu               |\n" +
                    "---------------------------------------------------\n");

            Scanner scan = new Scanner(System.in);

            System.out.printf(  "[1] Show all data\n" +
                    "[2] Show by...\n" +
                    "[3] Back\n");

            choice = scan.nextLine();

            if (choice.equals("3"))
                return;
            else if (choice.equals("1")) {
                viewAllToDo();
            } else if (choice.equals("2")) {
                showBySubMenu();
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("3")));

        return;
    }

    public static void viewAllToDo() {
        for (Map.Entry<Integer, ToDo> entry : ToDoRepository.get_data().entrySet())
            entry.getValue().prettyPrint();
    }

    static void showBySubMenu() throws ParseException {
        String choice = null;
        do {
            System.out.println("Show by...");

            Scanner scan = new Scanner(System.in);

            System.out.printf(  "[1] Priority\n"  +
                    "[2] Status\n" +
                    "[3] Due date\n"    +
                    "[4] Back\n");

            choice = scan.nextLine();

            if (choice.equals("4"))
                return;
            else if (choice.equals("1")) {
                // show by priority
                System.out.printf("Specify priority:");
                try {
                    viewByPriority(ToDo.Priority.valueOf(scan.nextLine()));
                } catch (Exception e) {
                    System.out.println("Invalid input: cannot recognize valid priority (S, A, B, C, D)");
                }
            } else if (choice.equals("2")) {
                // show by status
                System.out.printf("Specify status:");
                try {
                    viewByStatus(ToDo.Status.valueOf(scan.nextLine()));
                } catch (Exception e) {
                    System.out.println( "Invalid input: cannot recognize valid status (DA_FARE, IN_ESECUZIONE, " +
                            "COMPLETATO, ANNULLATO)");
                }

            } else if (choice.equals("3")) {
                // show by due date
                System.out.printf("Specify date:");
                String sData = scan.nextLine();
                try {
                    Date data =new SimpleDateFormat("dd/MM/yyyy").parse(sData);
                    viewByEndDate(data);
                } catch (Exception e) {
                    System.out.println("Invalid input: cannot recognize date in dd/mm/yyyy format.");
                }
            } else
                System.out.println("Invalid input. Please insert valid input.");

        } while(!(choice.equals("4")));
    }

    public static void viewByEndDate(Date d) {
        // Questa funzione è chiamata qunado l'utente vuole visualizzare tutti i To-Do aventi la data consegna fornita
        System.out.printf("ToDo aventi data di consegna %s:\n", d);
        for (Map.Entry<Integer, ToDo> m : ToDoRepository.get_data().entrySet()){
            if(m.getValue().getEndDate().equals(d)) {
                m.getValue().prettyPrint();
            }
        }
    }

    public static void viewByStatus(ToDo.Status s) {
        // Questa funzione è chiamata qunado l'utente vuole visualizzare tutti i To-Do aventi data priorità
        System.out.printf("ToDo aventi status %s:\n", s);
        for (Map.Entry<Integer, ToDo> m : ToDoRepository.get_data().entrySet()){
            if(m.getValue().getToDoStatus() == s) {
                m.getValue().prettyPrint();
            }
        }
    }

    public static void viewByPriority(ToDo.Priority p) {
        // Questa funzione è chiamata qunado l'utente vuole visualizzare tutti i To-Do aventi data priorità
        System.out.printf("ToDo aventi priorità %s:\n", p);
        for (Map.Entry<Integer, ToDo> m : ToDoRepository.get_data().entrySet()){
            if(m.getValue().getToDoPriority() == p) {
                m.getValue().prettyPrint();
            }
        }
    }
}
