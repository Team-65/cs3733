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

            if(!accountsUtil.contains(newUsername) && newUsername.length() >= 5){
                accountsUtil.put(newUsername, new Account(newUsername,0));
                screenUtil.pullUpScreen("Login.fxml", event);
            }else if(newUsername.length() < 5){
                errorBox.setText("User name must be at least five character long");
            }else if(accountsUtil.contains(newUsername)){
                errorBox.setText("Username taken!");
            }else{
                errorBox.setText("Unknown error!");
            }
        }catch(NullPointerException e){
            errorBox.setText("Please select an account type");
        }


    }
}
