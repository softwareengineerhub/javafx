/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beautiful.taskbar;

import java.io.FileNotFoundException;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author asusadmin
 */
public class MainApp extends Application {

    private HBox taskBar;
    private StackPane view;
    private MediaPlayer mediaPlayer = new MediaPlayer(new Media("http://webcast-west.sun.com/oow2010.flv"));

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        stage.setTitle("Demo");
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 720, 550, Color.LIGHTGRAY);
        stage.setScene(scene);

        taskBar = new HBox(10);
        //taskBar.setPadding(new Insets(10, 30, 50, 30));
        taskBar.setPadding(new Insets(50, 50, 50, 50));
        taskBar.setPrefHeight(150);
        taskBar.setAlignment(Pos.CENTER);
        root.setBottom(taskBar);

        view = new StackPane();
        root.setCenter(view);
        view.getChildren().add(new Text("Hello from JavaFX..."));

        Node node = createButton("/icon-0.png", new Runnable() {
            @Override
            public void run() {
                changeCenter(new MediaView(mediaPlayer));
                mediaPlayer.play();
            }
        });
        taskBar.getChildren().add(node);

        node = createButton("/icon-1.png", new Runnable() {
            @Override
            public void run() {
                // оси координат
                NumberAxis xAxis = new NumberAxis();
                NumberAxis yAxis = new NumberAxis();
                // график
                LineChart<Number, Number> chart = new LineChart<Number, Number>(xAxis, yAxis);
                chart.setTitle("Basic LineChart");
                xAxis.setLabel("X Axis");
                yAxis.setLabel("Y Axis");
                // набор случайных данных
                XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                series.setName("Random Data");
                Random random = new Random();
                for (int i = 0; i < 10 + random.nextInt(20); i++) {
                    series.getData().add(new XYChart.Data<Number, Number>(10 * i + 5, random.nextDouble() * 120));
                }
                chart.getData().add(series);
                changeCenter(chart);
            }
        });
        taskBar.getChildren().add(node);

        node = createButton("/icon-2.png", new Runnable() {

            @Override
            public void run() {
                Accordion accordion = new Accordion();
                for (int i = 0; i <= 4; i++) {
                    ImageView iv = new ImageView(new Image(getClass().getResource("/icon-" + i + ".png").toString()));
                    TitledPane t1 = new TitledPane("Image " + i, iv);

                    accordion.getPanes().add(t1);
                }

                changeCenter(accordion);
            }

        });
        taskBar.getChildren().add(node);

        node = createButton("/icon-3.png", new Runnable() {
            @Override
            public void run() {
                WebView webView = new WebView();
                WebEngine webEngine = webView.getEngine();
                webEngine.load("http://it-interview.org/");
                changeCenter(webView);
            }
        });
        taskBar.getChildren().add(node);

        Slider slider = new Slider();
        Circle circle = new Circle();
        circle.radiusProperty().bind(slider.valueProperty());


        node = createButton("/icon-4.png", new Runnable() {
            @Override
            public void run() {
                ListView listView = new ListView();
                // заполняем его стилями
                listView.setItems(FXCollections.observableArrayList(
                        "-fx-background-color: green;",
                        "-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);",
                        "-fx-background-color: transparent;",
                        "-fx-opacity: 0.3;",
                        "-fx-opacity: 1;"));
                // через binding связываем стиль панели задач с выбранным элементом списка
                taskBar.styleProperty().bind(listView.getSelectionModel().selectedItemProperty());
                changeCenter(listView);
            }
        });
        taskBar.getChildren().add(node);
        
        
        
        /*for (int i = 0; i < 5; i++) {
            Node node = createButton("/icon-" + i + ".png", null);
            taskBar.getChildren().add(node);
        }*/
        stage.show();
    }

    private Node createButton(String iconName, final Runnable action) {
        Image img = new Image(getClass().getResourceAsStream(iconName));
        ImageView node = new ImageView(img);
        final Reflection effect = new Reflection();
        node.setEffect(effect);

        final ColorAdjust effectPressed = new ColorAdjust();
        effectPressed.setBrightness(-0.5);

        String DURATION = "300ms";
        double SCALE = 1.3;
        ScaleTransition animationGrow = new ScaleTransition(Duration.valueOf(DURATION), node);
        animationGrow.setToX(SCALE);
        animationGrow.setToY(SCALE);
        final ScaleTransition animationShrink = new ScaleTransition(Duration.valueOf(DURATION), node);
        animationShrink.setToX(1);
        animationShrink.setToY(1);

        node.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                effect.setInput(effectPressed);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.valueOf("300ms"), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        effect.setInput(null);
                    }

                }));
                timeline.play();
                //final ColorAdjust effectPressed = new ColorAdjustBuilder().brightness(-0.5).build();
                action.run();
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                /*effect.setInput(effectPressed);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.valueOf("300ms"), new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle(ActionEvent event) {
                        effect.setInput(null);
                    }
                    
                }));
                timeline.play();
                 */
            }

        });

        // при наведении курсора мы запускаем анимацию увеличения кнопки
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                animationGrow.playFromStart();
                animationShrink.stop();
            }
        });
        // когда курсор сдвигается -- запускаем анимацию уменьшения
        node.setOnMouseExited(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                animationGrow.stop();
                animationShrink.playFromStart();
            }
        });

        return node;
    }

    private void changeCenter(Node node) {
        view.getChildren().clear();
        mediaPlayer.stop();
        view.getChildren().add(node);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
