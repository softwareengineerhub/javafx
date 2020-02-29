package com.firstscreen.category2;

import com.backend.api.model.category.Category;
import com.firstscreen.FirstScreen;
import com.firstscreen.details.PerspectiveImage;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class CategoryShelf extends Region {

    private static final Duration DURATION = Duration.millis(500);
    private static final Interpolator INTERPOLATOR = Interpolator.EASE_BOTH;
    private static final double SPACING = 50;
    private static final double LEFT_OFFSET = -110;
    private static final double RIGHT_OFFSET = 110;
    private static final double SCALE_SMALL = 0.7;
    private PerspectiveImage[] items;
    private Group centered = new Group();
    private Group left = new Group();
    private Group center = new Group();
    private Group right = new Group();
    private int centerIndex = 0;
    private Timeline timeline;
    private ScrollBar scrollBar = new ScrollBar();
    private boolean localChange = false;
    private Rectangle clip = new Rectangle();

    //private Image[] images;
    private List<Category> categoriesList;
    private Text topText;
    private Text bottomText;
    private FirstScreen mobileApplication;

    public CategoryShelf(Text topText, Text bottomText, FirstScreen mobileApplication) {
        this.topText = topText;
        this.bottomText = bottomText;
        getChildren().addAll(centered, scrollBar);
        this.mobileApplication = mobileApplication;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }


    private void cleanup() {
        items = null;
        centered.getChildren().clear();
        left.getChildren().clear();
        center.getChildren().clear();
        right.getChildren().clear();
    }

    public void refresh() {
        cleanup();
        // set clip
        setClip(clip);
        //setStyle("-fx-background-color: linear-gradient(to bottom, black 60, 60.1%, black 100%);");
        setStyle("-fx-background-color: '#FFCB0B'");
        //  scrollBar.setStyle("-fx-base: #202020; -fx-background: #202020;");
        // create items
        items = new PerspectiveImage[categoriesList.size()];
        for (int i = 0; i < items.length; i++) {
            Category category = categoriesList.get(i);
            Image image = createImage(category);
            items[i] = new PerspectiveImage(image, i);
            final PerspectiveImage item = items[i];
            final int localIndex = i;
            final double index = i;
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    localChange = true;
                    scrollBar.setValue(index);
                    localChange = false;
                    shiftToCenter(item);
                    topText.setText(category.getDescriptionA() + "\n" + category.getDescriptionB());
                    bottomText.setText(category.getDescriptionC() + "\n" + category.getDescriptionD());

                }
            });
            item.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                if (centerIndex == localIndex) {

                    mobileApplication.detailsView2.refresh(categoriesList.get(centerIndex));
                    mobileApplication.switchView("details2_view");
                }

            });
        }

        topText.setText(categoriesList.get(0).getDescriptionA() + "\n" + categoriesList.get(0).getDescriptionB());
        bottomText.setText(categoriesList.get(0).getDescriptionC() + "\n" + categoriesList.get(0).getDescriptionD());

        // setup scroll bar

        scrollBar.setMax(items.length - 1);
        scrollBar.setVisibleAmount(1);
        scrollBar.setUnitIncrement(1);
        scrollBar.setBlockIncrement(1);
        scrollBar.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (!localChange) {
                    shiftToCenter(items[(int) scrollBar.getValue()]);

//                    detailsView.selectedDetails=(int)scrollBar.getValue();
                }
            }
        });
        scrollBar.setVisible(false);
        centered.getChildren().addAll(left, right, center);
        setFocusTraversable(true);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.LEFT) {
                    shift(1);
                    localChange = true;
                    scrollBar.setValue(centerIndex);
                    localChange = false;
                } else if (ke.getCode() == KeyCode.RIGHT) {
                    shift(-1);
                    localChange = true;
                    scrollBar.setValue(centerIndex);
                    localChange = false;
                }
            }
        });
        // update
        update();
        shiftToCenter(items[0]);
        scrollBar.setValue(0);
    }

    private Image createImage(Category category) {
        if(category.getImage()!=null){
            return category.getImage();
        }
        byte[] imageData = category.getImageData();
        try (InputStream in = new ByteArrayInputStream(imageData)) {
            return new Image(in);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void layoutChildren() {
        // update clip to our size
        clip.setWidth(getWidth());
        clip.setHeight(getHeight());
        // keep centered centered
        centered.setLayoutY((getHeight() - PerspectiveImage.HEIGHT) / 2);
        centered.setLayoutX((getWidth() - PerspectiveImage.WIDTH) / 2);
        // position scroll bar at bottom
        scrollBar.setLayoutX(10);
        scrollBar.setLayoutY(getHeight() - 25);
        scrollBar.resize(getWidth() - 20, 15);
    }

    private void update() {
        // move items to new homes in groups
        left.getChildren().clear();
        center.getChildren().clear();
        right.getChildren().clear();
        for (int i = 0; i < centerIndex; i++) {
            left.getChildren().add(items[i]);
        }
        center.getChildren().add(items[centerIndex]);
        for (int i = items.length - 1; i > centerIndex; i--) {
            right.getChildren().add(items[i]);
        }
        // stop old timeline if there is one running
        if (timeline != null) {
            timeline.stop();
        }
        // create timeline to animate to new positions
        timeline = new Timeline();
        // add keyframes for left items
        final ObservableList<KeyFrame> keyFrames = timeline.getKeyFrames();
        for (int i = 0; i < left.getChildren().size(); i++) {
            final PerspectiveImage it = items[i];
            double newX = -left.getChildren().size()
                    * SPACING + SPACING * i + LEFT_OFFSET - 25;
            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 45.0, INTERPOLATOR)));
        }
        // add keyframe for center item
        final PerspectiveImage centerItem = items[centerIndex];
        keyFrames.add(new KeyFrame(DURATION,
                new KeyValue(centerItem.translateXProperty(), 0, INTERPOLATOR),
                new KeyValue(centerItem.scaleXProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.scaleYProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.angle, 90.0, INTERPOLATOR)));
        // add keyframes for right items
        for (int i = 0; i < right.getChildren().size(); i++) {
            final PerspectiveImage it = items[items.length - i - 1];
            final double newX = right.getChildren().size()
                    * SPACING - SPACING * i + RIGHT_OFFSET;
            //        * SPACING - SPACING * i + LEFT_OFFSET;


            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 135.0, INTERPOLATOR)));
        }
        // play animation
        timeline.play();
    }

    private void shiftToCenter(PerspectiveImage item) {


        for (int i = 0; i < left.getChildren().size(); i++) {
            if (left.getChildren().get(i) == item) {
                int shiftAmount = left.getChildren().size() - i;
                shift(shiftAmount);
                return;
            }
        }
        if (center.getChildren().get(0) == item) {
            return;
        }
        for (int i = 0; i < right.getChildren().size(); i++) {
            if (right.getChildren().get(i) == item) {
                int shiftAmount = -(right.getChildren().size() - i);
                shift(shiftAmount);
                return;
            }
        }
    }

    public void shift(int shiftAmount) {


        if (centerIndex <= 0 && shiftAmount > 0) {
            return;
        }
        if (centerIndex >= items.length - 1 && shiftAmount < 0) {
            return;
        }


        centerIndex -= shiftAmount;
        //detailsView.selectedDetails=centerIndex;

        update();
        Category category = categoriesList.get(centerIndex);
        topText.setText(category.getDescriptionA() + "\n" + category.getDescriptionB());
        bottomText.setText(category.getDescriptionC() + "\n" + category.getDescriptionD());
    }

    public int getCenterIndex() {
        return centerIndex;
    }


}

