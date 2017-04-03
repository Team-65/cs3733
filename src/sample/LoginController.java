package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Adonay on 3/26/2017.
 */
public class LoginController {
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Label errorBox;

    ScreenUtil screenUtil = new ScreenUtil();

    private String username;
    private String password;
    private AccountsUtil aUtil = new AccountsUtil();

       public void login(ActionEvent event){

        username = usernameField.getText();
        password = passwordField.getText();

        if(aUtil.contains(username)){
            aUtil.setUser_id(username);
            screenUtil.pullUpScreen("MainMenu.fxml", event);
        }
        else{
            errorBox.setText("Username does not exist!");
        }

    }

    public void guestLogin(ActionEvent event){
           aUtil.setUser_id("guest");
           screenUtil.pullUpScreen("MainMenu.fxml", event);
    }

    public void createAccount(ActionEvent event){

        screenUtil.pullUpScreen("NewAccount.fxml", event);

    }

    public void clearData(){
        aUtil.clearData();
    }
}
