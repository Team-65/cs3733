package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.List;
import javafx.collections.ObservableList;

public class SearchMenuController {
    @FXML Button Back;
    @FXML Button Search;
    @FXML CheckBox IsWine;
    @FXML CheckBox IsBeer;
    @FXML CheckBox IsOther;
    @FXML TextField Tags;
    @FXML TableColumn IDno;
    @FXML TableColumn Name;
    @FXML TableColumn BrandName;
    @FXML TableColumn Type;
    @FXML TableColumn Location;
    @FXML Button downRes;
    @FXML Button newSearch;
    ScreenUtil screenUtil;


    public void getResults(){
        table.getColumns().clear();
        IDno.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        BrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Appellation"));
        table.setItems(SearchMenuController.getObservableList());
        table.getColumns().addAll(IDno, Name, BrandName, Type, Location);
    }

    public void buttonClicked (javafx.event.ActionEvent event){
        try {
            if(event.getSource() == Back){
                fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            if(event.getSource() == Search){
                Search(event);
            }



            Parent root1 = null;
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MainMenu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML TableView table;


    private FXMLLoader fxmlLoader;

    Connection conn = connect();
    int wob = 0;
    final int BEER = 1;
    final int WINE = 2;

    List<AlcoholData> AlcoholDataList = new ArrayList<AlcoholData>();
    static ObservableList<AlcoholData> observableList;

    public static ObservableList<AlcoholData> getObservableList() {
        return observableList;
    }


    public void Search(ActionEvent event) throws SQLException, NoSuchMethodException, IllegalAccessException, InstantiationException, IOException{
        AlcoholDataList.clear();
        if (IsBeer.isSelected()){
            wob = 1;
        }
        else if (IsWine.isSelected()){
            wob = 2;
        }
        else if (Tags.getText() == null || Tags.getText().trim().isEmpty()) {
            screenUtil.pullUpScreen("ErrorState", event);
        }

        search(conn);
        observableList = FXCollections.observableList(AlcoholDataList);
        getResults();
    }


    private void search(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        ResultSet rset;
        Statement stmt;
        String brand;

        System.out.println("while loop executd");

        String qry = "SELECT * FROM ALCOHOL WHERE ALCOHOL.ALCOHOL_TYPE = ";

        stmt = conn.createStatement();

        System.out.println("while loop executd");
        if (IsWine.isSelected() && IsBeer.isSelected()){
            System.out.println("while loop executd");
            rset = stmt.executeQuery(qry + BEER);
            while(rset.next()){ //TODO Make this clean so that the while loop does not come up twice
                String ID = String.format("%1$"+3+ "s", rset.getString("AID"));
                String name = String.format("%1$"+25+ "s", rset.getString("NAME"));
                String brandname = String.format("%1$"+25+ "s", rset.getString("BRAND_NAME"));
                String app = String.format("%1$"+22+ "s", rset.getString("APPELLATION"));
                String type = String.format("%1$"+10+ "s", rset.getString("ALCOHOL_TYPE"));
                // AlcoholData Constructor
                AlcoholData a = new AlcoholData(ID, name, brandname, app, type);
                AlcoholDataList.add(a);
            }
            rset = stmt.executeQuery(qry + WINE);//TODO MAKE IT NOT SET TWICE PLSPLSPLS
        }
        else if(IsWine.isSelected() || IsBeer.isSelected()){
            System.out.println("while loop executd");
            rset = stmt.executeQuery(qry + wob);
        }
        else {
            brand = Tags.getText().trim();
            System.out.println("Hello");
            System.out.println(brand);
            rset = stmt.executeQuery("SELECT * FROM ALCOHOL WHERE ALCOHOL.BRAND_NAME = '"+brand+"'");
        }

        System.out.println("while loop executd");

        while(rset.next()){
            String ID = String.format("%1$"+3+ "s", rset.getString("AID"));
            String name = String.format("%1$"+25+ "s", rset.getString("NAME"));
            String brandname = String.format("%1$"+25+ "s", rset.getString("BRAND_NAME"));
            String app = String.format("%1$"+22+ "s", rset.getString("APPELLATION"));
            String type = String.format("%1$"+10+ "s", rset.getString("ALCOHOL_TYPE"));
            // AlcoholData Constructor
            AlcoholData a = new AlcoholData(ID, name, brandname, app, type);
            AlcoholDataList.add(a);
            System.out.println("while loop executd");
        }

        rset.close();
        stmt.close();
        input.close();
    }



    public static Connection connect(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Java DB Driver not found. Add the classpath to your module.");
            e.printStackTrace();
            return null;
        }

        System.out.println("Java DB driver registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:derby:Database\\ProjectC;create=true");
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
            return connection;
        }
        System.out.println("Java DB connection established!");

        return connection;
    }
}

