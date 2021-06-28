package ires.corso.parttwo.bibilioteca;

public class User
{
    private final String userID;
    private final String userName;
    private final String userSurname;

    public User(String userID, String userName, String userSurname) {
        this.userID = userID;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getUserID() {
        return userID;
    }
}