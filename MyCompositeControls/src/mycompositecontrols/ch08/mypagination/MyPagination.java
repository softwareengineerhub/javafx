/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch08.mypagination;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPagination extends Application {

    private final int itemCount = 15;
    private final String[] colors = getColors();
    private final int lastPage = colors.length / itemCount;
    private final int reminder = colors.length - colors.length / itemCount * itemCount;

    @Override
    public void start(Stage primaryStage) {
        Pagination pagination = new Pagination();
        pagination.setPrefWidth(300);
        pagination.setPageFactory(pageIndex -> {
            return createPage(pageIndex);
        });

        HBox hbox = new HBox(pagination);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));
        Scene scene = new Scene(hbox, 400, 420);
      //  scene.getStylesheets().add("resources/pagination.css");

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

    private String[] getColors() {
        List<String> data = new ArrayList();
        Field[] fields = Color.class.getFields();
        for (Field field : fields) {
            String name = field.getName();
            data.add(name);
        }
        return data.toArray(new String[0]);
    }

    private VBox createPage(Integer pageIndex) {
        VBox vbox = new VBox(5);
        int page = pageIndex * itemCount;
        int maxIndex = page + (pageIndex == lastPage ? reminder : itemCount);
        for (int i = page; i < maxIndex; i++) {
            Label colorName = new Label();
            Rectangle colorSquare = new Rectangle(15, 15, Color.web(colors[i]));
            HBox hbox = new HBox(5, colorSquare, colorName);
            vbox.getChildren().add(hbox);
        }
        return vbox;
    }

}
