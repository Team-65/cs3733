package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Adonay on 4/3/2017.
 */
public class ScreenUtil {
    FXMLLoader fxmlLoader;

    public void pullUpScreen(String fxmlName, ActionEvent event){
        fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));

        try{
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle(fxmlName);
            stage.setMinHeight(400);
            stage.setMinWidth(370);
            stage.setMaxHeight(400);
            stage.setMaxWidth(370);
            stage.setScene(new Scene(root1));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
