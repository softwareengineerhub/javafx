/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.details;

import com.backend.api.model.details.Details;
import com.backend.api.repository.xml.LocalXmlParser;
import com.firstscreen.category2.CategoryShelf;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Properties;

/**
 * @author asusadmin
 */
public class DetailsView2 {

    private DoubleProperty heightProperty = new SimpleDoubleProperty();
    private DoubleProperty widthProperty = new SimpleDoubleProperty();
    private StackPane root;
    private BorderPane borderPane = new BorderPane();
    private int categoryIndex;
    private int detailsIndex;
    private Text textA;
    private Text textB;
    private Text textC;
    private Text textD;
    private List<Details> detailsList;
    private ImageView homeButton;
    private CategoryShelf categoryShelf;
    private static final String soundPath = "http://128.199.185.171:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";
   // Properties props = new Properties();

    public DetailsView2(StackPane root, int categoryIndex, CategoryShelf categoryShelf) {
        detailsIndex = -1;
        this.root = root;
        this.categoryShelf = categoryShelf;
        this.categoryIndex = categoryIndex;
        root.getChildren().addAll(borderPane);
        detailsList = LocalXmlParser.findAllDetailsPerCategory("c" + categoryIndex);
        textA = new Text();
        textA.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textA.setFill(Color.WHITE);

        textB = new Text();
        textB.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textB.setFill(Color.WHITE);

        textC = new Text();
        textC.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textC.setFill(Color.WHITE);

        textD = new Text();
        textD.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textD.setFill(Color.WHITE);
        initHomeButton();

        showNextDetailsImage();

        initBottom();

        initTop();

        root.setStyle("-fx-background-color: linear-gradient(to right, green, yellow);");

    }

    private void initTop() {


        VBox vBox = new VBox(50);
        vBox.setPadding(new Insets(40, 40, 40, 40));
        vBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(50);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(textA, textB);
        HBox hBox2 = new HBox(50);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(textC, textD);
        vBox.getChildren().addAll(hBox1, hBox2);
        borderPane.setTop(vBox);
    }

    private void initBottom() {
        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(40, 40, 40, 40));
        ImageView iv1 = initButtonDetailsImage("/sound/details_sound1.png", 1);
        ImageView iv2 = initButtonDetailsImage("/sound/details_sound2.png", 2);
        ImageView iv3 = initButtonDetailsImage("/sound/details_sound3.png", 3);

        hBox.getChildren().addAll(homeButton, iv1, iv2, iv3);
        //hBox.getChildren().add(initDetailsImage("/sound/details_sound2.png"));
        //hBox.getChildren().add(initDetailsImage("/sound/details_sound3.png"));
        borderPane.setBottom(hBox);
    }

    private void showNextDetailsImage() {
        if (detailsIndex == detailsList.size() - 1) {
            return;
        }
        detailsIndex++;

        //detailsList.get(detailsIndex).getDescriptionA();
        //textA.setText("qqqq");
        textA.setText(detailsList.get(detailsIndex).getDescriptionA());
        textB.setText(detailsList.get(detailsIndex).getDescriptionB());
        textC.setText(detailsList.get(detailsIndex).getDescriptionC());
        textD.setText(detailsList.get(detailsIndex).getDescriptionD());


        ImageView initDetailsImage = initDetailsImage("/Details/c" + categoryIndex + "/" + detailsIndex + ".jpg");
        initDetailsImage.setFitWidth(510);
        initDetailsImage.setFitHeight(380);

        ImageView prev = initDetailsImage("/previous.png");
        prev.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showPrevDetailsImage();
            }
        });


        ImageView next = initDetailsImage("/next.png");
        next.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showNextDetailsImage();

                /*textA = new Text(detailsList.get(detailsIndex).getDescriptionA());
                textB = new Text(detailsList.get(detailsIndex).getDescriptionB());
                textC = new Text(detailsList.get(detailsIndex).getDescriptionC());
                textD = new Text(detailsList.get(detailsIndex).getDescriptionD());*/
            }
        });

        HBox hbox = new HBox(50);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(prev, initDetailsImage, next);

        borderPane.setCenter(hbox);

    }

    private void showPrevDetailsImage() {
        if (detailsIndex == 0) {
            return;
        }
        detailsIndex--;

        textA.setText(detailsList.get(detailsIndex).getDescriptionA());
        textB.setText(detailsList.get(detailsIndex).getDescriptionB());
        textC.setText(detailsList.get(detailsIndex).getDescriptionC());
        textD.setText(detailsList.get(detailsIndex).getDescriptionD());

        ImageView initDetailsImage = initDetailsImage("/Details/c" + categoryIndex + "/" + detailsIndex + ".jpg");
        initDetailsImage.setFitWidth(510);
        initDetailsImage.setFitHeight(380);

        ImageView prev = initDetailsImage("/previous.png");
        prev.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showPrevDetailsImage();
                if (detailsIndex == 0) {
                    return;
                }
                detailsIndex--;

                textA.setText(detailsList.get(detailsIndex).getDescriptionA());
                textB.setText(detailsList.get(detailsIndex).getDescriptionB());
                textC.setText(detailsList.get(detailsIndex).getDescriptionC());
                textD.setText(detailsList.get(detailsIndex).getDescriptionD());
            }
        });


        ImageView next = initDetailsImage("/next.png");
        next.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (detailsIndex >= detailsList.size()) {
                    return;
                }
                detailsIndex++;

                textA.setText(detailsList.get(detailsIndex).getDescriptionA());
                textB.setText(detailsList.get(detailsIndex).getDescriptionB());
                textC.setText(detailsList.get(detailsIndex).getDescriptionC());
                textD.setText(detailsList.get(detailsIndex).getDescriptionD());
                //showNextDetailsImage();
            }
        });

        HBox hbox = new HBox(50);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(prev, initDetailsImage, next);


        borderPane.setCenter(hbox);


//        borderPane.setCenter(initDetailsImage("/Details/c"+categoryIndex+"/"+detailsIndex+".jpg"));
    }

    private ImageView initButtonDetailsImage(String imgPath, int actionType) {
        ImageView initDetailsImage = initDetailsImage(imgPath);
        initDetailsImage.setFitWidth(190);
        initDetailsImage.setFitHeight(90);
        initDetailsImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                String soundFile = "/sound/c" + categoryIndex + "/d" + detailsIndex;
                switch (actionType) {
                    case 1:
                        soundFile += "/ch.m4a";
                        break;
                    case 2:
                        soundFile += "/eng.m4a";
                        break;
                    default:
                        soundFile += "/ru.m4a";
                }

                //Media sound = new Media(new File(soundFile).toURI().toString());
                try {
                    //String str = getClass().getResource(soundFile).toURI().toString();
                    //System.out.println("File path="+str);
                    //str = String.format(soundPath, "c0","d0","ch");

                   // String str = props.get("sound.path")+"";

                    String str = "file:///root/my-fx11-test/src/main/resources/sound/c0/d0/eng.m4a";
                    Media sound = new Media(str);
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.stop();
                    //mediaPlayer.
                    mediaPlayer.play();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        return initDetailsImage;
    }

    private ImageView initDetailsImage(String imgPath) {
        if ("/Details/c2/2.jpg".equals(imgPath)) {
            imgPath = "/Details/c2/2.png";
        }
        if ("/Details/c2/7.jpg".equals(imgPath)) {
            imgPath = "/Details/c2/7.png";
        }
        if ("/Details/c2/8.jpg".equals(imgPath)) {
            imgPath = "/Details/c2/8.png";
        }
        if ("/Details/c2/12.jpg".equals(imgPath)) {
            imgPath = "/Details/c2/12.png";
        }

        if ("/Details/c1/23.jpg".equals(imgPath)) {
            imgPath = "/Details/c1/23.png";
        }
        if ("/Details/c1/30.jpg".equals(imgPath)) {
            imgPath = "/Details/c1/30.png";
        }
        if ("/Details/c1/46.jpg".equals(imgPath)) {
            imgPath = "/Details/c1/46.png";
        }


        Image img = new Image(getClass().getResourceAsStream(imgPath));
        return new ImageView(img);
    }

    private void initHomeButton() {
        if (homeButton != null) {
            return;
        }


        Image img = new Image(getClass().getResourceAsStream("/home2.png"));

        double xDelta = widthProperty.getValue() * 10 / 335;
        double yDelta = heightProperty.getValue() * 10 / 600;


        homeButton = new ImageView(img);


        homeButton.setFitHeight(heightProperty.get() * 0.1 - yDelta);
        homeButton.setFitWidth((widthProperty.getValue() - 5 * xDelta) * 0.25 - xDelta);

        homeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            //  mobileApplication.switchView(HOME_VIEW);
            back();

        });
        //   homeButton.setFitWidth(190);
        //   homeButton.setFitHeight(90);

        //  homeButton.setX(10);
        // homeButton.setY(10);

    }

    private void back() {
        root.getChildren().clear();
        root.getChildren().addAll(categoryShelf);
    }
}
