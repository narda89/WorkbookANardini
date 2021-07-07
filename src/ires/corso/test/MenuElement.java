package ires.corso.test;

public class MenuElement implements Runnable {

    private String menuElementKey;
    private String menuElementTitle;
    private Runnable menuElementRunnable;

    public MenuElement(String menuElementKey, String menuElementTitle, Runnable menuElementRunnable) {
        this.menuElementKey = menuElementKey;
        this.menuElementTitle = menuElementTitle;
        this.menuElementRunnable = menuElementRunnable;
    }

    //// GETTER ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getMenuElementTitle() {
        return menuElementTitle;
    }

    public String getMenuElementKey() {
        return menuElementKey;
    }

    /// DISPLAY MENU ELEMENT ///////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayMenuElement() {
        System.out.println(menuElementKey + ": " + menuElementTitle);
    }

    @Override
    public void run() {
        menuElementRunnable.run();
    }
}
