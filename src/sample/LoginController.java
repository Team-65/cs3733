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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adonay on 3/26/2017.
 */
public class LoginController {
    FXMLLoader fxmlLoader;

    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Button loginButton, guestLoginButton;
    @FXML
    private Hyperlink newAccountLink;

    private String username;
    private String password;


    public void pullUpScreen(String fxmlName, String user_id){
        fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));

        try{
            Parent root1 = fxmlLoader.load();
            MainMenuController mcontroller = fxmlLoader.<MainMenuController>getController();
            mcontroller.setUsername(user_id);

            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle(fxmlName);
            stage.setMinHeight(400);
            stage.setMinWidth(370);
            stage.setMaxHeight(400);
            stage.setMaxWidth(370);
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void login(ActionEvent event){

        username = usernameField.getText();
        password = passwordField.getText();

        pullUpScreen("MainMenu.fxml", username);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    public void guestLogin(ActionEvent event){
        pullUpScreen("MainMenu.fxml", "Guest");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void createAccount(ActionEvent event){



    }

}
