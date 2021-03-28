package conferenceFX;

import com.firstscreen.animations.AnimationUtils;
import com.jpro.webapi.JProApplication;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.Properties;


public class MainApp extends JProApplication {
    private Socket socket;
    private String username;

    double xDelta;
    double yDelta;
    GridPane gridPane = new GridPane();
    StackPane root = new StackPane();


    @Override
    public void start(Stage stage) throws Exception {
        //BorderPane root = new BorderPane();
        /*Label label = new Label("Learning Path");
        final double MAX_FONT_SIZE = 25.0; // define max font size you need
        label.setFont(new Font(MAX_FONT_SIZE)); // set to Label
        label.setTextFill(Color.web("white"));*/

        //gridPane.add(label,1,0, 3, 1);
        //gridPane.add(label,1,0 );
        gridPane.add(initHeader(),1,0,3,1 );



        /*gridPane.add(initImage("/education/education3.jpg", 0),0,1);
        gridPane.add(initImage("/education/education2.jpg", 1),1,1);
        gridPane.add(initImage("/education/education1.jpg", 2),2,1);

        gridPane.add(initImage("/education/education9.jpg", 3),0,2);
        gridPane.add(initImage("/education/education5.jpg", 4),1,2);
        gridPane.add(initImage("/education/education4.jpg", 5),2,2);

        gridPane.add(initImage("/education/education7.jpg", 6),0,3);
        gridPane.add(initImage("/education/education8.jpg", 7),1,3);
        gridPane.add(initImage("/education/education6.jpg", 8),2,3);*/

        gridPane.add(initImage("/education/education3.jpg", 0),0,1);
        gridPane.add(initImage("/education/education2.jpg", 1),1,1);
        gridPane.add(initImage("/education/education1.jpg", 2),2,1);

        gridPane.add(initImage("/education/education9.jpg", 3),0,2);
        gridPane.add(initImage("/education/education5.jpg", 4),1,2);
        gridPane.add(initImage("/education/education4.jpg", 5),2,2);

        gridPane.add(initImage("/education/education7.jpg", 6),0,3);
        gridPane.add(initImage("/education/education8.jpg", 7),1,3);
        gridPane.add(initImage("/education/education6.jpg", 8),2,3);



        gridPane.setAlignment(Pos.CENTER);
        //gridPane.setHgap(110);
        //gridPane.setVgap(110);

        gridPane.setHgap(110);
        gridPane.setVgap(55);




        //VBox vBox = new VBox();
        //vBox.getChildren().addAll(gridPane, label);
        root.getChildren().add(gridPane);

        //root.getChildren().addAll(gridPane, label);


        //  label.setLayoutX(root.getWidth()/2);
        //  label.setLayoutY(10);




        //root.getChildren().add(new Label("Center"));
        //root.getChildren().add(gridPane);

        /*listView.setItems(FXCollections.observableArrayList(
                "-fx-background-color: green;",
                "-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);",
                "-fx-background-color: transparent;",
                "-fx-opacity: 0.3;",
                "-fx-opacity: 1;"));
         */

        // через binding связываем стиль панели задач с выбранным элементом списка
        //root.styleProperty().bind(listView.getSelectionModel().selectedItemProperty());


        //root.setStyle("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);");

//        root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #32cd32);");
        /*.linear-grad2{
            -fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #32cd32);
        }*/


        //int[] colors = {Color.parseColor("red"),Color.parseColor("aqua")};
        //GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
        //gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        //root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, red, aqua);");
        root.setStyle("-fx-background-color: linear-gradient(to right, red, aqua);");


        xDelta = (720 * 10 / 335)/2;
        yDelta = (550 * 10 / 600)/2;

        Scene scene = new Scene(root, 720, 550, Color.LIGHTGRAY);
        stage.setScene(scene);

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();


    }



    private Node initImage(String imgPath, int pathIndex) {
        Reflection effect = new Reflection();
        // effect.setTopOpacity(0.1);

        Image img = new Image(getClass().getResourceAsStream(imgPath));
        ImageView imgNode = new ImageView(img);

        // imgNode.setEffect(effect);
        AnimationUtils.animate(imgNode, effect);
        imgNode.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
                int n = gridPane.getChildren().size();
                for(int i=0;i<n;i++){
                    AnimationUtils.animateCategories(gridPane.getChildren().get(i), root, pathIndex, i==pathIndex, gridPane);
                }
            }
        });


        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }


    private Node initHeader() {
        Reflection effect = new Reflection();
        // effect.setTopOpacity(0.1);

        //Image img = new Image(getClass().getResourceAsStream(imgPath));
        //ImageView imgNode = new ImageView(img);


        Label imgNode = new Label("Learning Path");
        imgNode.setFont(Font.font("Verdana", FontWeight.BOLD, 25)); // set to Label
        imgNode.setTextFill(Color.web("white"));
        //AnimationUtils.animate(imgNode, effect);



        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
