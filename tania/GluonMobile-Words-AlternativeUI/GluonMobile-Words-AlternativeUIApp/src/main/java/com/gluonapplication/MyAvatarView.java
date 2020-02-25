package com.gluonapplication;

import com.backend.api.model.details.Details;
import com.backend.api.model.details.sound.SoundApi;
import com.backend.api.model.details.sound.SoundApiImpl;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.ShareService;
import com.gluonhq.charm.down.plugins.VideoService;
import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class MyAvatarView extends View {

    private GluonApplication gluonApplication;
    private List<Details> list;
    private ObservableList<Details> speakers;
    private AvatarPane<Details> avatarPane;
    private int currentPage;
    private int step = 4;
    private AppBar appBar;
    private String categoryName;
    private SoundApi soundApi;

    public MyAvatarView(GluonApplication gluonApplication) {
        this.gluonApplication = gluonApplication;
        list = new ArrayList();
        soundApi = new SoundApiImpl();
        setBottom(createBottom());
    }

    public void initData(String categoryName) {
        this.categoryName = categoryName;
        list.clear();
        list.addAll(gluonApplication.details2Dao.findAllDetails(categoryName));
        speakers = FXCollections.observableList(list.subList(0, Math.min(step, list.size())));

        avatarPane = new AvatarPane(speakers);

        avatarPane.setCollapsible(true);
        avatarPane.setAvatarFactory(speaker -> {
            Avatar avatar = new Avatar();

            if (speaker.getImage() == null) {
                try (ByteArrayInputStream in = new ByteArrayInputStream(speaker.getImageData());) {
                    Image img = new Image(in);
                    speaker.setImage(img);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            Image image = speaker.getImage();

            //Image image = new Image(speaker.getImageData());
            avatar.setImage(image);
            avatar.setRadius(avatar.getRadius());
            return avatar;
        });

        /*avatarPane.setContentFactory(speaker -> {
            VBox container = new VBox();
            Label name = new Label(speaker.getDescriptionA());
            name.setWrapText(true);
            Label jobTitle = new Label(speaker.getDescriptionB());
            jobTitle.setWrapText(true);
            Label company = new Label(speaker.getDescriptionC());
            company.setWrapText(true);
            Label summary = new Label(speaker.getDescriptionD());
            summary.setWrapText(true);
            ImageView imageView = new ImageView(speaker.getImage());
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            container.getChildren().addAll(name, jobTitle, imageView, company, summary);
            container.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,#14C9CB) (1.0,aqua);");
            return container;
        });*/
        //avatarPane.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,#14C9CB) (1.0,aqua);");
        Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 15);
        avatarPane.setContentFactory(speaker -> {
            BorderPane container = new BorderPane();
            StackPane center = new StackPane();
            Label name = new Label(speaker.getDescriptionA());
            name.setFont(font);
            name.setWrapText(true);
            Label jobTitle = new Label(speaker.getDescriptionB());
            jobTitle.setWrapText(true);
            jobTitle.setFont(font);
            Label company = new Label(speaker.getDescriptionC());
            company.setWrapText(true);
            company.setFont(font);
            Label summary = new Label(speaker.getDescriptionD());
            summary.setWrapText(true);
            summary.setFont(font);

            ImageView imageView = new ImageView(speaker.getImage());

            double value = Math.min(avatarPane.getHeight() * 0.7, avatarPane.getWidth() * 0.7);
            imageView.setFitHeight(value);
            imageView.setFitWidth(value);
            center.getChildren().addAll(imageView);

            Insets insets = new Insets(10, 10, 10, 10);
            HBox topCh = new HBox(10);
            topCh.setAlignment(Pos.CENTER);
            topCh.getChildren().addAll(name, jobTitle);

            HBox topOther = new HBox(10);
            topOther.setAlignment(Pos.CENTER);
            topOther.getChildren().addAll(company, summary);

            VBox top = new VBox(10);
            top.setPadding(insets);
            top.getChildren().addAll(topCh, topOther);

            HBox bottom = new HBox(20);
            bottom.setPadding(insets);
            bottom.setAlignment(Pos.CENTER);

            Node imgUK = initBottomImageWithAction("/UK.png", "uk");
            Node imgChina = initBottomImageWithAction("/China.png", "ch");
            Node imgRussia = initBottomImageWithAction("/Russia.png", "ru");

            bottom.getChildren().addAll(imgUK, imgChina, imgRussia);
            // bottom.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,#14C9CB) (1.0,aqua);");

            container.setTop(top);
            container.setCenter(center);
            container.setBottom(bottom);

            //bottom.styleProperty().set("-fx-background-color: gray;");
            //bottom.styleProperty().set("-fx-background-color: #ffffff67;");
            return container;
        });

        setCenter(avatarPane);
        // avatarPane.styleProperty().set("-fx-background-color: gray;");

    }

    private BottomNavigation createBottom() {
        BottomNavigation bottomNavigation = new BottomNavigation();

        BottomNavigationButton btn1 = new BottomNavigationButton();
        btn1.setGraphic(new Icon(MaterialDesignIcon.NAVIGATE_BEFORE));
        btn1.setOnAction(e -> {
            if (currentPage > 0) {
                currentPage--;
                avatarPane.setItems(FXCollections.observableList(list.subList(currentPage * step, currentPage * step + step)));
                if (!avatarPane.getItems().isEmpty()) {
                    avatarPane.setValue(avatarPane.getItems().get(0));
                }
            }
        });

        BottomNavigationButton btn2 = new BottomNavigationButton();
        btn2.setGraphic(new Icon(MaterialDesignIcon.HOME));
        btn2.setOnAction(e -> gluonApplication.switchView("CATEGORY_VIEW"));

        BottomNavigationButton btn3 = new BottomNavigationButton();
        btn3.setGraphic(new Icon(MaterialDesignIcon.NAVIGATE_NEXT));
        btn3.setOnAction(e -> {
            if ((currentPage + 1) * step < list.size()) {
                currentPage++;
                avatarPane.setItems(FXCollections.observableList(list.subList(currentPage * step, Math.min(currentPage * step + step, list.size()))));
                if (!avatarPane.getItems().isEmpty()) {
                    avatarPane.setValue(avatarPane.getItems().get(0));
                }
            }
        });

        bottomNavigation.getActionItems().addAll(btn1, btn2, btn3);
        return bottomNavigation;
    }

    private Node initBottomImageWithAction(String imgPath, String language) {
        StackPane stackPane = new StackPane();
        Image img = new Image(getClass().getResourceAsStream(imgPath));
        ImageView imageView = new ImageView(img);
        double value = avatarPane.getWidth() / 7 + 7;
        imageView.setFitHeight(value);
        imageView.setFitWidth(value * 1.2);
        stackPane.getChildren().add(imageView);
        final String cssDefault = "-fx-border-color: black; -fx-border-width: 1;";
        stackPane.setStyle(cssDefault);

        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            if (avatarPane.getItems() == null || avatarPane.getItems().isEmpty()) {
                return;
            }
            int selectedIndex = avatarPane.getItems().indexOf(avatarPane.getValue());
            String url = soundApi.getUrl(categoryName, "d" + selectedIndex, language);
            Services.get(VideoService.class).ifPresent(video -> {
                try {
                    video = video.getClass().newInstance();
                    video.stop();
                    video.getPlaylist().clear();
                    video.getPlaylist().add(url);
                    video.play();
                } catch (Throwable th) {

                }
            });
        }
        );

        return stackPane;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setTitleText("Happy Learning");
        appBar.getActionItems().add(MaterialDesignIcon.SHARE.button(e -> {

            Services.get(ShareService.class).ifPresent(service -> service.share("This is the subject", "This is the content of the message"));

        }));
    }
}
