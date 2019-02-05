/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch05.mytreetableview;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import mycompositecontrols.ch05.mytableview.SalesData;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTreeTableView extends Application {

    
    private final TreeTableView<MySalesData> treeTableView = new TreeTableView<>();
    
   // private final ObservableList<MySalesData> data = FXCollections.observableArrayList();

    private void initData() {
        TreeItem<MySalesData> root = new TreeItem<>(new MySalesData("All Companies", 500.0));
        root.setExpanded(true);
        
        root.getChildren().add(new TreeItem<>(new MySalesData("Company1", 77.3)));
        root.getChildren().add(new TreeItem<>(new MySalesData("Company2", 78.3)));
        root.getChildren().add(new TreeItem<>(new MySalesData("Company3", 15.3)));
        root.getChildren().add(new TreeItem<>(new MySalesData("Company4", 90.3)));
        root.getChildren().add(new TreeItem<>(new MySalesData("Company5", 75.3)));        
        treeTableView.setRoot(root);
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

       
        TreeTableColumn<MySalesData, String> companyColumn = new TreeTableColumn<>("Company");
        companyColumn.setMinWidth(75);
        companyColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MySalesData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MySalesData, String> param) {
                return param.getValue().getValue().getCompanyProperty();
            }
        });
        
        
        TreeTableColumn<MySalesData, Double> priceColumn = new TreeTableColumn<>("Price");
        priceColumn.setMinWidth(75);
        priceColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MySalesData, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TreeTableColumn.CellDataFeatures<MySalesData, Double> param) {
                return param.getValue().getValue().getUnitsProperty().asObject();
            }
        });
        
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        treeTableView.setPrefHeight(300);
        treeTableView.getColumns().add(companyColumn);
        treeTableView.getColumns().add(priceColumn);
        treeTableView.setEffect(dropShadow);
       

        final TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setEffect(dropShadow);
        textField.setOnAction(event -> {
            try {
                Double units = Double.parseDouble(textField.getText());
                TreeItem<MySalesData> mySalesData = treeTableView.getSelectionModel().getSelectedItem();
                mySalesData.getValue().setPrice(units);                
            } catch (Exception ex) {

            }
        });

        Button removeButton = new Button("Remove Company");
        removeButton.setEffect(dropShadow);
        removeButton.setOnAction(event -> {
            int index = treeTableView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                TreeItem<MySalesData> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
                if(selectedItem.isLeaf()){
                    selectedItem.getParent().getChildren().remove(selectedItem);
                }else {
                    treeTableView.setRoot(null);
                }
            }
        });

        Button resetButton = new Button("Reset Table");
        resetButton.setEffect(dropShadow);
        resetButton.setOnAction(event -> {
            initData();
        });

        Label changeLabel = new Label("Change Units Sold");
        changeLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

        HBox hbox = new HBox(20, changeLabel, textField);
        hbox.setAlignment(Pos.CENTER_LEFT);

        VBox mainBox = new VBox(20, vbox, treeTableView, hbox, removeButton, resetButton);
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
