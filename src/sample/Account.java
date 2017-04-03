package sample;

/**
 * Created by Adonay on 4/3/2017.
 */
public abstract class Account {
    private String username;
    private int accessLevel;
    private boolean isLoggedIn;

    public Account(String usrnm, int accL){
        username = usrnm;
        accessLevel = accL;
        isLoggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
