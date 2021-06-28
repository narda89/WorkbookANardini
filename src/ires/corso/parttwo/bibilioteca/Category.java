package ires.corso.parttwo.bibilioteca;

public class Category
{
    private final String title;
    private final String description;

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
}