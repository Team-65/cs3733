package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Created by Adonay on 3/27/2017.
 */
public class NewAccountController {

    @FXML
    private TextField newUsernameField;
    @FXML
    private ChoiceBox accountChoiceBox;

    private String newUsername;
    private String accountChoice;


    public void createAccount(ActionEvent event){

        newUsername = newUsernameField.getText();
        accountChoice = accountChoiceBox.getValue().toString();

    }
}
