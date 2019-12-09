package denis.fx.treetable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class FXMLController implements Initializable {

    @FXML
    private JFXTreeTableView<Model> treeTableView;

    @FXML
    private TreeTableColumn<Model, String> nameCol;

    @FXML
    private TreeTableColumn<Model, String> jobCol;

    @FXML
    private TreeTableColumn<Model, String> ageCol;

    @FXML
    private TreeTableColumn<Model, String> genderCol;

    @FXML
    private JFXTextField nameTF;

    @FXML
    private JFXTextField searchTF;

    @FXML
    private GridPane managementTF;

    @FXML
    private JFXTextField jobTF;

    @FXML
    private JFXTextField ageTF;

    @FXML
    private JFXComboBox<String> genderCombo;

    @FXML
    private Label nameLB;

    @FXML
    private Label jobLB;

    @FXML
    private Label ageLB;

    @FXML
    private Label genderLB;


    ObservableList<Model> list;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderCombo.getItems().addAll("Male", "Female");
        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().name;
            }
        });

        jobCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().job;
            }
        });

        ageCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().age;
            }
        });

        genderCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().gender;
            }
        });

        list = FXCollections.observableArrayList();

        TreeItem<Model> root = new RecursiveTreeItem<Model>(list, RecursiveTreeObject ::getChildren);
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);

        list.addAll(new Model("a","b", "c", "male"));
        list.addAll(new Model("a1","b1", "c1", "female"));
        list.addAll(new Model("a2","b2", "c2", "male"));



        treeTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Model>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Model>> observable, TreeItem<Model> oldValue, TreeItem<Model> newValue) {
                    showDetails(newValue);
            }
        });


        searchTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                treeTableView.setPredicate(new Predicate<TreeItem<Model>>() {
                    @Override
                    public boolean test(TreeItem<Model> modelTreeItem) {
                        return modelTreeItem.getValue().name.getValue().contains(newValue) |modelTreeItem.getValue().age.getValue().contains(newValue) ;
                    }
                });

            }
        });

    }



    @FXML
    private void addAction(ActionEvent event) {
        String nameValue = nameTF.getText();
        String jobValue = jobTF.getText();
        String ageValue = ageTF.getText();
        String genderValue = genderCombo.getSelectionModel().getSelectedItem();

        list.addAll(new Model(nameValue, jobValue, ageValue, genderValue));
    }

    @FXML
    private void removeAction(ActionEvent event) {
        int index = treeTableView.getSelectionModel().getSelectedIndex();
        if(index!=-1) {
            list.remove(index);
        }
    }


    @FXML
    private void editAction(ActionEvent event) {
        int index = treeTableView.getSelectionModel().getSelectedIndex();
        if(index!=-1){
            String nameValue = nameTF.getText();
            String jobValue = jobTF.getText();
            String ageValue = ageTF.getText();
            String genderValue = genderCombo.getSelectionModel().getSelectedItem();
            list.set(index, new Model(nameValue, jobValue, ageValue, genderValue));

        }
    }

    private void showDetails(TreeItem<Model> treeItem){
        if(treeItem!=null) {
            Model model = treeItem.getValue();
            String nameValue = model.getName();
            String jobValue = model.getJob();
            String ageValue = model.getAge();
            String genderValue = model.getGender();
            nameLB.setText(nameValue);
            jobLB.setText(jobValue);
            ageLB.setText(ageValue);
            genderLB.setText(genderValue);
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        list.clear();
        nameLB.setText("");
        jobLB.setText("");
        ageLB.setText("");
        genderLB.setText("");
    }
}
