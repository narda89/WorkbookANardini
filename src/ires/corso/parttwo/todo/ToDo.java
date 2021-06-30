package ires.corso.parttwo.todo;

import java.io.Serializable;
import java.util.Date;

public class ToDo implements Serializable
{
    public enum Priority {
        D,
        C,
        B,
        A,
        S
    }
    public enum Status {
        ANNULLATO,
        DA_FARE,
        IN_ESECUZIONE,
        COMPLETATO
    }

    private final int toDoID;
    private String toDoTitle;
    private String toDoDescription;
    private Priority toDoPriority;
    private Status toDoStatus;
    private Date startDate;
    private Date endDate;

    public ToDo(int toDoID, String toDoTitle, String toDoDescription, Priority toDoPriority, Status toDoStatus, Date startDate, Date endDate) {
        this.toDoID = toDoID;
        this.toDoTitle = toDoTitle;
        this.toDoDescription = toDoDescription;
        this.toDoPriority = toDoPriority;
        this.toDoStatus = toDoStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public ToDo(ToDo another) {
        this.toDoID = another.toDoID;
        this.toDoTitle = another.toDoTitle;
        this.toDoDescription = another.toDoDescription;
        this.toDoPriority = another.toDoPriority;
        this.toDoStatus = another.toDoStatus;
        //this.startDate = another.startDate;     // a parte Date, tutti gli altri campi sono immutable;
        //this.endDate = another.endDate;         // per fare la deep copy delle date devo usare questo costrutto particolare (cosi dice baeldung)
        this.startDate = new Date(another.startDate.getTime());
        this.endDate = new Date(another.endDate.getTime());

    }

    public int getToDoID() {
        return toDoID;
    }

    public String getToDoTitle() {
        return toDoTitle;
    }

    public String getToDoDescription() {
        return toDoDescription;
    }

    public Priority getToDoPriority() {
        return toDoPriority;
    }

    public Status getToDoStatus() {
        return toDoStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setToDoTitle(String toDoTitle) {
        this.toDoTitle = toDoTitle;
    }

    public void setToDoDescription(String toDoDescription) {
        this.toDoDescription = toDoDescription;
    }

    public void setToDoPriority(Priority toDoPriority) {
        this.toDoPriority = toDoPriority;
    }

    public void setToDoStatus(Status toDoStatus) {
        this.toDoStatus = toDoStatus;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void prettyPrint() {
        System.out.printf(  "------------------------------------------------------\n" +
                        "|ID:          \t\t\t%d\n" +
                        "|Titolo:      \t\t\t%s\n" +
                        "|Descrizione: \t\t\t%s\n" +
                        "|Priorità:    \t\t\t%s\n" +
                        "|Status:      \t\t\t%s\n" +
                        "|Data inizio: \t\t\t%s\n" +
                        "|Data fine:   \t\t\t%s\n" +
                        "------------------------------------------------------\n",
                toDoID, toDoTitle, toDoDescription, toDoPriority, toDoStatus, startDate, endDate);
    }
}
