package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAppController {

    private FXMLLoader fxmlLoader;
    @FXML Button back, newApp, oldApp;
    ScreenUtil work = new ScreenUtil();


    public void buttonClicked (javafx.event.ActionEvent event){
            if(event.getSource() == back){
                work.pullUpScreen("MainMenu.fxml", event);
            }else if (event.getSource() == newApp) {
                work.pullUpScreen("NewLabel.fxml", event);
            } else if (event.getSource() == oldApp) {
                work.pullUpScreen("ReviseMenu.fxml", event);
            }

    }
}
