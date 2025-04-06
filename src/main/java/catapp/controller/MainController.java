package catapp.controller;

import catapp.model.CatImage;
import catapp.service.ApiService;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class MainController {

    @FXML
    private TilePane imagePane;

    @FXML
    private Label introText;

    @FXML
    public void initialize() {
        // Fade in animation for intro text
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), introText);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play();
    }

    @FXML
    public void loadCats() {
        try {
            List<CatImage> catImages = ApiService.fetchCatImages();
            imagePane.getChildren().clear();

            for (CatImage cat : catImages) {
                ImageView imageView = new ImageView(new Image(cat.getUrl(), 200, 200, true, true));

                VBox card = new VBox(imageView);
                card.getStyleClass().add("cat-card");

                imagePane.getChildren().add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
