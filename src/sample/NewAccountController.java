package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Adonay on 3/27/2017.
 */
public class NewAccountController {

    @FXML
    private TextField newUsernameField;
    @FXML
    private ChoiceBox accountChoiceBox;
    @FXML
    private Label errorBox;

    private String newUsername;
    private String accountChoice;

    private AccountsUtil accountsUtil = new AccountsUtil();
    private ScreenUtil screenUtil = new ScreenUtil();

    public void createAccount(ActionEvent event){

        try{
            newUsername = newUsernameField.getText();
            accountChoice = accountChoiceBox.getValue().toString();
            if(!accountsUtil.contains(newUsername)){
                accountsUtil.put(newUsername, new Account(newUsername,0));
                screenUtil.pullUpScreen("Login.fxml", event);
            }else{
                errorBox.setText("Username taken!");
            }
        }catch(NullPointerException e){
            errorBox.setText("Please select an account type");
        }


    }
}
