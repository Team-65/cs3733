package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class SearchMenuController {
    @FXML Button Back;
    @FXML Button Search;
    @FXML CheckBox IsWine;
    @FXML CheckBox IsBeer;
    @FXML CheckBox IsOther;
    @FXML TextField Tags;

    private FXMLLoader fxmlLoader;
    ScreenUtil work = new ScreenUtil();

    public void buttonClicked (javafx.event.ActionEvent event){
            if(event.getSource() == Back){
                work.pullUpScreen("MainMenu.fxml", event);
            }
            if(event.getSource() == Search){
                work.pullUpScreen("ErrorState.fxml", event);
            }
    }
}