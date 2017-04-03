package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adonay on 3/26/2017.
 */
public class LoginController {
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Button loginButton, guestLoginButton;
    @FXML
    private Hyperlink newAccountLink;

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
            screenUtil.pullUpScreen("Login.fxml", event);
        }

    }

    public void guestLogin(ActionEvent event){
       screenUtil.pullUpScreen("MainMenu.fxml", event);
    }

    public void createAccount(ActionEvent event){

        screenUtil.pullUpScreen("NewAccount.fxml", event);

    }

}
