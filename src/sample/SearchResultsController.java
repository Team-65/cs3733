package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class SearchResultsController {
    @FXML
    TableColumn IDno;
    @FXML
    TableColumn Name;
    @FXML
    TableColumn Company;
    @FXML
    TableColumn Type;
    @FXML
    TableColumn Date;
    @FXML
    Button downRes;
    @FXML
    Button startOver;
    private FXMLLoader fxmlLoader;
    ScreenUtil work = new ScreenUtil();

    public void buttonClicked(javafx.event.ActionEvent event) {
        if (event.getSource() == startOver) {
            work.pullUpScreen("SearchMenu.fxml", event);
        }

    }
}
