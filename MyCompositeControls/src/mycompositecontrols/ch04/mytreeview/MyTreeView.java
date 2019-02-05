/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch04.mytreeview;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTreeView extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        Button b1 = new Button("Add");
        TextField textField = new TextField();
        Button b2 = new Button("Delete");

        HBox hbox = new HBox(20, b1, textField, b2);
        hbox.setAlignment(Pos.CENTER);
        hbox.setMinWidth(40);

        
        TreeView treeView = buildTree();
        VBox vbox = new VBox(20, treeView, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(40);
        vbox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        b1.setOnAction(event -> {
             Object nodeObject = treeView.getSelectionModel().getSelectedItem();
             String text = textField.getText();
             if(text!=null && !text.isEmpty()){
                 if(nodeObject instanceof TreeItem){
                     TreeItem node = (TreeItem) nodeObject;
                     if(node!=null){
                         node.getChildren().add(new TreeItem(text));
                     }
                 }
             }
        });

        b2.setOnAction(event -> {
            
            Object nodeObject = treeView.getSelectionModel().getSelectedItem();            
                 if(nodeObject instanceof TreeItem){
                     TreeItem node = (TreeItem) nodeObject;
                     if(node!=null){
                         node.getParent().getChildren().remove(node);
                         //node.getChildren().add(new TreeItem(text));
                     }
                 }
             
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static TreeView<String> buildTree(){
        TreeItem<String> leagues = new TreeItem<>("Major League");
        TreeItem<String> national = new TreeItem<>("National League");
        TreeItem<String> nationalEast = new TreeItem<>("East");
        TreeItem<String> nationals = new TreeItem<>("Nationals");
        nationalEast.getChildren().add(nationals);
        national.getChildren().add(nationalEast);        
        leagues.getChildren().add(national);
        return new TreeView(leagues);
        
    }

}
