/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch05.mytableview;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import mycompositecontrols.ch05.mytableview2.JavaFXDynTable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTableView extends Application {

    private final ObservableList<SalesData> data = FXCollections.observableArrayList();
    
    private void initData(){
        data.setAll(new SalesData("a", 1),
                new SalesData("B", 2),
                new SalesData("C", 3),
                new SalesData("D", 4),
                new SalesData("E", 5));
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        initData();
  
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetX(6);
        dropShadow.setColor(Color.BLUE);
        
        Label label = new Label("SmartPhone Sales");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        
        VBox vbox = new VBox(label);
        vbox.setAlignment(Pos.CENTER);
        
        
        
        TableColumn<SalesData, String> companyColumn = new TableColumn<>("Company");
        companyColumn.setEditable(true);
        companyColumn.setMinWidth(75);
        companyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalesData, String>, ObservableValue<String>>() {
            
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalesData, String> param) {
                SalesData salesData = param.getValue();
                return salesData.getCompanyProperty();                
            }
        });
        companyColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<SalesData, String>>() {
        
            @Override
            public void handle(TableColumn.CellEditEvent<SalesData, String> event) {
                System.out.println("EDIT!!!");
            }
        });
        
        
        
        
        
        
        
        
        TableColumn<SalesData, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(75);
        priceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalesData, Double>, ObservableValue<Double>>() {
         
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<SalesData, Double> param) {
                return param.getValue().getUnitsProperty().asObject();
            }
        });
        
        
        /*
        priceColumn.setOnEditCommit(event-> {
            Double updatedValue = event.getNewValue();
            SalesData salesData = event.getTableView().getSelectionModel().getSelectedItem();
            salesData.setPrice(updatedValue);
        });*/
        
        
        
        TableView<SalesData> tableView = new TableView<>(data);
         tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setPrefHeight(175);
        tableView.getColumns().add(companyColumn);
        tableView.getColumns().add(priceColumn);
        tableView.setEffect(dropShadow);
       
        
        
        final TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setEffect(dropShadow);
        textField.setOnAction(event->{
            try{
                Double units = Double.parseDouble(textField.getText());
                SalesData salesData = tableView.getSelectionModel().getSelectedItem();
                if(salesData!=null){
                    salesData.setPrice(units);
                }
            }catch(Exception ex){
                
            }
        });
        
        
        
        
        Button removeButton = new Button("Remove Company");
        removeButton.setEffect(dropShadow);
        removeButton.setOnAction(event->{
            int index = tableView.getSelectionModel().getSelectedIndex();
            if(index>=0){
                data.remove(index);
            }
        });
        
        
        Button resetButton = new Button("Reset Table");
        resetButton.setEffect(dropShadow);
        resetButton.setOnAction(event->{
            initData();
        });
        
        
        Label changeLabel = new Label("Change Units Sold");
        changeLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        
        HBox hbox = new HBox(20, changeLabel, textField);
        hbox.setAlignment(Pos.CENTER_LEFT);
        
        VBox mainBox = new VBox(20, vbox, tableView, hbox, removeButton, resetButton);
        mainBox.setAlignment(Pos.CENTER_LEFT);
        mainBox.setPadding(new Insets(20, 30, 30, 30));
        mainBox.setStyle("-fx-background-color: palegreen");
                
        Scene scene = new Scene(mainBox, 850, 550);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    

}
