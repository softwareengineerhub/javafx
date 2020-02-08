package com.firstscreen.details2;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.firstscreen.CommonAnimationUtils;
import com.firstscreen.FirstScreen;
import com.firstscreen.animations.AnimationUtils;
import com.firstscreen.details2.sound.SoundApi;
import com.firstscreen.details2.sound.SoundApiImpl;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.VideoService;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;

public class Details2View extends View {

    private VBox flowPane;
    private StackPane center;
    public BorderPane root = new BorderPane();
    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    private Category category;
    public FirstScreen mobileApplication;
    private int selectedIndex;
    private ImageView prev;
    private ImageView imgNode;
    private ImageView next;
    private Details details;
    private Text textTopA;
    private Text textTopB;
    private Text textBottomA;
    private Text textBottomB;
    SoundApi soundApi = new SoundApiImpl();
    int soundIndex;

    public Details2View(FirstScreen mobileApplication){
        this.mobileApplication=mobileApplication;
        flowPane = new VBox(10.0);
        //flowPane.setPadding(new Insets(20, 0, 20, 0));
        //flowPane = new FlowPane(Orientation.VERTICAL);
        flowPane.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,red) (1.0,aqua);");
        flowPane.prefWidthProperty().bind(widthProperty);
        flowPane.prefHeightProperty().bind(heightProperty);
        //flowPane.setHgap(25);
        //flowPane.setVgap(25);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.prefWidthProperty().bind(widthProperty);
        flowPane.prefHeightProperty().bind(heightProperty);

        /*center = new StackPane();
        center.prefWidthProperty().bind(widthProperty);
        center.prefHeightProperty().bind(heightProperty);
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(flowPane);*/
    }


    public void refresh(Category category) {
        if(this.category!=null && !category.getName().equalsIgnoreCase(this.category.getName())) {
            mobileApplication.detailsDao2.cleanup();
            selectedIndex = 0;
        }
        this.category = category;
        if (root.getBottom() == null) {
            root.setBottom(initBottomContent());
        }
        if (root.getCenter() == null) {
           root.setCenter(flowPane);
        }
        initCentralContent();
        setCenter(root);
    }

    private VBox initCentralContent() {
        if(selectedIndex==0){
            System.out.println("category.getName()="+category.getName());
            System.out.println("selected index = 0");
            flowPane.getChildren().clear();
            details = category.getFirstDetails();
            System.out.println("details="+details);
            
            if (details.getImage() == null) {
                byte[] data = details.getImageData();
                try (InputStream in = new ByteArrayInputStream(data)) {
                    details.setImage(new Image(in));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

            imgNode = new ImageView(details.getImage());
            imgNode.setFitWidth(widthProperty.getValue()*0.9);
            imgNode.setFitHeight(250);

            prev = new ImageView(new Image(getClass().getResourceAsStream("/prev2.png")));
            prev.setFitWidth(65);
            prev.setFitHeight(65);
            next = new ImageView(new Image(getClass().getResourceAsStream("/next2.png")));
            next.setFitWidth(65);
            next.setFitHeight(65);

            next.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                if(!AnimationUtils.canStartNewAnimation()){
                    return;
                }
                Details detailsTmp = mobileApplication.detailsDao2.findDetail(category.getName(), selectedIndex + 1);
                if(detailsTmp!=null) {
                    details=detailsTmp;
                    AnimationUtils.animateDetailsChanged(imgNode, details.getImage());
                    textTopA.setText(details.getDescriptionA());
                    textTopB.setText(details.getDescriptionB());
                    textBottomA.setText(details.getDescriptionC());
                    textBottomB.setText(details.getDescriptionD());
                    selectedIndex++;

                }
            });

            prev.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                if(!AnimationUtils.canStartNewAnimation()){
                    return;
                }

                Details detailsTmp = mobileApplication.detailsDao2.findDetail(category.getName(), selectedIndex-1);
                if(detailsTmp!=null) {
                    details=detailsTmp;
                    AnimationUtils.animateDetailsChanged(imgNode, details.getImage());
                    textTopA.setText(details.getDescriptionA());
                    textTopA.setText(details.getDescriptionB());
                    textBottomA.setText(details.getDescriptionC());
                    textBottomB.setText(details.getDescriptionD());
                    selectedIndex--;

                }
            });

            HBox controlsBox = new HBox(40.0, prev, next);
            controlsBox.setAlignment(Pos.CENTER);
            textTopA = new Text();
            textTopA.setFont(Font.font("Noto Sans CJK SC Regular", FontWeight.BOLD, 20));
            textTopA.setText(details.getDescriptionA());
            textTopA.setFill(Color.valueOf("white"));

            textTopB = new Text(details.getDescriptionB());
            textTopB.setFont(Font.font("Noto Sans CJK SC Regular", FontWeight.BOLD, 20));
            textTopB.setText(details.getDescriptionB());
            textTopB.setFill(Color.valueOf("white"));


            textBottomA = new Text(details.getDescriptionC());
            textBottomB = new Text(details.getDescriptionD());

            textBottomA.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
            textBottomA.setFill(Color.valueOf("white"));

            textBottomB.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
            textBottomB.setFill(Color.valueOf("white"));

            flowPane.setAlignment(Pos.CENTER);
            flowPane.getChildren().addAll(textTopB,textTopA, imgNode, textBottomA,textBottomB, controlsBox);






            mobileApplication.detailsDao2.initAllDetailsPerCategory(category.getName());

        } else {
      //      int itemPosition = flowPane.getChildren().indexOf(imgNode);

            details = mobileApplication.detailsDao2.findDetail(category.getName(), selectedIndex);




//            imgNode = new ImageView(details.getImage());
  //          imgNode.setFitWidth(widthProperty.getValue()*0.9);
    //        imgNode.setFitHeight(250);


            //flowPane.getChildren().set(itemPosition, imgNode);

            imgNode.setImage(details.getImage());

            textTopA = new Text(details.getDescriptionA());
            textTopB = new Text(details.getDescriptionB());

            textBottomA.setText(details.getDescriptionC());
            textBottomB.setText(details.getDescriptionD());

        }




        //flowPane.getChildren().clear();




        //List<Details> list =  mobileApplication.detailsDao2.findAllDetails(category.getName());
//mobileApplication.detailsDao2.findDetail(category.getName(), selectedIndex);




        Charset dfset = Charset.defaultCharset();
        //out.println(dfset.name());

        //setTop(new Label("Cahrset: "+dfset.name()));

        //String s = new String(, "cp-1251");
        //String value = new String("海龟".getBytes(), "UTF-8");
        //byte[] textByte = "海龟".getBytes(StandardCharsets.UTF_16);
        //setTop(new Text(new String(textByte, StandardCharsets.UTF_16)));
        //setTop(new Label("Charset: "+dfset.name()+";"+ new String(textByte, StandardCharsets.UTF_16)));

       // setTop(new StringBuilder(""));

        //Charset dfset2 = Charset.forName("windows-1251");
        //byte[] textByte = "海龟".getBytes(dfset2);
        //setTop(new Label("Charset: "+dfset.name()+";"+ new String(textByte, dfset2)));

       /* try {
            String utf8String = new String("海龟".getBytes("windows-1251"), "windows-1251");
            String ansiString = new String(utf8String.getBytes("windows-1251"), "windows-1251");
            setTop(new Label(ansiString));

        }catch(Exception ex){
            setTop(new Label(ex.getMessage()));
        }*/







        return flowPane;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> {}));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> {}));
    }

    private HBox initBottomContent() {
        HBox menu = new HBox(0);
        menu.setAlignment(Pos.CENTER);
        menu.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,#14C9CB) (1.0,aqua);");
        Node imgHome = initBottomImageWithAction("/home2.png", "");
        Node imgUK = initBottomImageWithAction("/UK.png", "uk");
        Node imgChina = initBottomImageWithAction("/China.png", "ch");
        Node imgRussia = initBottomImageWithAction("/Russia.png", "ru");
        menu.getChildren().addAll(imgHome, imgUK, imgChina, imgRussia);
        return menu;
    }

    private Node initBottomImageWithAction(String imgPath, String language) {
        Reflection effect = new Reflection();
        double xDelta = widthProperty.getValue() * 10 / 335;
        double yDelta = heightProperty.getValue() * 10 / 600;
        Image img = new Image(getClass().getResourceAsStream(imgPath));

        ImageView imgNode = new ImageView(img);

        imgNode.setFitHeight(heightProperty.get() * 0.1 - yDelta);
        imgNode.setFitWidth((widthProperty.getValue() - 5 * xDelta) * 0.25 - xDelta);


        imgNode.setEffect(effect);
        CommonAnimationUtils.animate(imgNode, effect);
        imgNode.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {


                        if (details == null) {
                            return;
                        }


                        if (language.isEmpty()) {
                            Services.get(VideoService.class).ifPresent(video -> {
                                video.stop();
                                video.hide();
                            });
                            mobileApplication.switchView("category2_view");
                            //mobileApplication.switchView(HOME_VIEW);
                            return;
                        }


            String url = soundApi.getUrl(category.getName(), "d"+selectedIndex, language);






            Services.get(VideoService.class).ifPresent(video -> {
                try {

                    video = video.getClass().newInstance();

                    video.stop();
                    video.getPlaylist().clear();

                    //video.setControlsVisible(false);


                    // Details2View.this.setTop(new Label(url+";"));
                    //String url = String.format(SOUND_URL, category.getName(), DetailsCache.getInstance().getDetailses().get(selectedDetails).getName(), language);
                    video.getPlaylist().add(url);
                    //video.setLooping(true);
                    //video.currentIndexProperty().setValue(soundIndex++);
                    video.play();
                    //video.show();


                    //Details2View.this.setTop(new Label(url));

                }catch(Throwable th){

                }


            });


                     //   root.setCenter(initCentralContent());

                    }

        );

        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }


    private void showError(Throwable ex){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //alert.setTitle(ex.getMessage());
       // alert.setHeaderText("Results:");

        alert.setContentText(ex.getMessage());

        alert.showAndWait();
    }


}

