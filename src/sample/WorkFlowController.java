package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WorkFlowController {

    private FXMLLoader fxmlLoader;
    @FXML private Button back;
    ScreenUtil work = new ScreenUtil();

    public void buttonClicked (javafx.event.ActionEvent event){
            if(event.getSource() == back){
                work.pullUpScreen("MainMenu.fxml", event);
            }

    }
}
