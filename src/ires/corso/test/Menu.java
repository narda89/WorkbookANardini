package ires.corso.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String menuTitle = "";
    private ArrayList<MenuElement> menuElements = new ArrayList<>();

    //// COSTRUTTORE ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Menu(String menuTitle, ArrayList<MenuElement> menuElements) {
        this.menuTitle = menuTitle;
        this.menuElements = menuElements;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public ArrayList<MenuElement> getMenuElements() {
        return menuElements;
    }

    //// DISPLAY MENU //////////////////////////////////////////////////////////////////////////////////////////////////
    public void displayMenu() {
        System.out.println( "-----------------------------------------\n" + getMenuTitle() + " [< to go BACK | X to QUIT]" +
                            "\n_________________________________________\n");

        for (MenuElement me : getMenuElements())
            me.DisplayMenuElement();
    }

    //// RUN MENU //////////////////////////////////////////////////////////////////////////////////////////////////////
    public void runMenu() {
        while(true) {
            boolean noValid = true;
            displayMenu();
            Scanner scan = new Scanner(System.in);
            String selection = scan.nextLine();

            if (selection.equals("<")) {
                return;
            }
            if (selection.equals("X")) {
                System.exit(0);
            }

            for(MenuElement me : getMenuElements()) {
                if (selection.equals(me.getMenuElementKey())) {
                    me.run();
                    noValid = false;
                    break;
                }
            }

            if (noValid)
                System.out.println("Input non riconosciuto!");
        }
    }
}
