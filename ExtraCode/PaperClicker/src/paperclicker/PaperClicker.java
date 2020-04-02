package paperclicker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Paper Clicker. Its a clicker game I don't know what else to say...
 *
 * @author Alex Vasil
 */
public class PaperClicker extends Application {

    private double paperCount;
    private int autoPaperCount;
    private int modelPaperCount;
    private long firstClickTime;

    //How often the CPS counter is updated.
    private final Duration CPS_UPDATE_TIME = Duration.millis(100);
    private final Duration AUTOPAPER_UPDATE_TIMER = Duration.seconds(1);

    private GridPane grid;
    private Text paperCountText;
    private Text cpsText;
    private Text autoPaperText;
    private Text modelPaperText;
    private Button autoPaperButton;
    private Button modelPaperButton;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Paper Heroes!");
        initComponents();
        initValues();
        addToGrid();

        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);
//        grid.setGridLinesVisible(true);
        primaryStage.show();
        update();
    }

    public void initValues() {
        paperCount = 0;
        autoPaperCount = 0;
        firstClickTime = -1;
        modelPaperCount = 0;
        autoPaperButton.setTooltip(new Tooltip("Cost: 20 papers, increases paper generation by 0.05 papers each second!"));
        modelPaperButton.setTooltip(new Tooltip("Cost: 200 papers, increases paper generation by 0.1 papers each second!"));
    }

    public void addToGrid() throws FileNotFoundException {
        Text paperCounterLabel = new Text("Paper Count:");
        Text paperCPS = new Text("CPS:");
        grid.add(paperCounterLabel, 0, 1);
        grid.add(paperCountText, 1, 1);
        grid.add(paperCPS, 2, 1);
        grid.add(cpsText, 3, 1);
        grid.add(paperButton(), 0, 0);
        grid.add(autoPaperButton, 5, 0);
        grid.add(autoPaperText, 5, 1);
        grid.add(modelPaperButton, 5, 2);
        grid.add(modelPaperText, 5, 3);
    }

    public void initComponents() {
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        paperCountText = new Text(String.format("%.1f", paperCount));
        cpsText = new Text("0");
        autoPaperButton = new Button();
        autoPaperText = new Text("Autopaper count: " + autoPaperCount);
        modelPaperButton = new Button();
        modelPaperText = new Text("Modelpaper count: " + modelPaperCount);
    }

    /**
     * Method containing the various updating methods.
     */
    private void update() throws FileNotFoundException {
        updateCPS();
        updatePaperCount();
        autoPaperClickerButton();
        modelPaperButton();
    }
    
    /**
     * Updates the CPS counter.
     */
    private void updateCPS() {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //Calculates the clicks per second everytime the button is clicked.
                        cpsText.setText(String.format("%.1f", paperCount / ((System.currentTimeMillis() - firstClickTime) / 1000)));
                        paperCountText.setText(String.format("%.0f", paperCount));
                    }
                }), new KeyFrame(CPS_UPDATE_TIME)
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * A button that can be clicked to gain paper points!
     *
     * @return A button.
     * @throws FileNotFoundException If the paperIcon isn't found.
     */
    private Button paperButton() throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("D:\\Computer Science Code&Homework\\ProgrammingTwo\\ExtraCode\\PaperClicker\\Images\\smallPaperImg.jpg");
        Image paperImg = new Image(inputstream);

        Button paperButton = new Button();
        paperButton.setGraphic(new ImageView(paperImg));
        paperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                paperCount++;
                paperCountText.setText(String.format("%.0f", paperCount));
                if (firstClickTime == -1) {
                    firstClickTime = System.currentTimeMillis();
                }
                paperClickAnimation();
            }
        });

        return paperButton;
    }

    private void autoPaperClickerButton() throws FileNotFoundException {
        updateButtonGraphics();
        autoPaperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (paperCount >= 20) {
                    paperCount -= 20;
                    autoPaperCount++;
                    autoPaperText.setText("Autopaper count: " + autoPaperCount);
                }
            }
        });
    }

    private void updateButtonGraphics() throws FileNotFoundException {
        //Autopaper graphics.
        FileInputStream mousePointer = new FileInputStream("D:\\Computer Science Code&Homework\\ProgrammingTwo\\ExtraCode\\PaperClicker\\Images\\mousePointer.png");
        FileInputStream grayedOutMousePointer = new FileInputStream("D:\\Computer Science Code&Homework\\ProgrammingTwo\\ExtraCode\\PaperClicker\\Images\\grayOutMousePointer.png");
        //Modelpaper graphics.
        FileInputStream modelPaper = new FileInputStream("D:\\Computer Science Code&Homework\\ProgrammingTwo\\ExtraCode\\PaperClicker\\Images\\modelPaper.png");
        FileInputStream grayedOutModelPaper = new FileInputStream("D:\\Computer Science Code&Homework\\ProgrammingTwo\\ExtraCode\\PaperClicker\\Images\\grayOutModelPaper.png");

        Image autoPaperClicker;

        //Updates the graphics of the Autopaper button.
        if (paperCount >= 20) {
            autoPaperClicker = new Image(mousePointer);
            autoPaperButton.setGraphic(new ImageView(autoPaperClicker));
        } else {
            autoPaperClicker = new Image(grayedOutMousePointer);
            autoPaperButton.setGraphic(new ImageView(autoPaperClicker));
        }

        //Updates the graphics of the Modelpaper button.
        if (paperCount >= 200) {
            autoPaperClicker = new Image(modelPaper);
            modelPaperButton.setGraphic(new ImageView(autoPaperClicker));
        } else {
            autoPaperClicker = new Image(grayedOutModelPaper);
            modelPaperButton.setGraphic(new ImageView(autoPaperClicker));
        }

    }

    /**
     * Auto updates the paper count based on how many paper generators the player has.
     */
    private void updatePaperCount() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.ZERO,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    updateButtonGraphics();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PaperClicker.class.getName()).log(Level.SEVERE, null, ex);
                }
                paperCount += autoPaperCount * 0.05;
                paperCount += modelPaperCount * 0.1;
            }
        }), new KeyFrame(AUTOPAPER_UPDATE_TIMER)
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void modelPaperButton() {
        modelPaperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (paperCount >= 200) {
                    paperCount -= 200;
                    modelPaperCount++;
                    modelPaperText.setText("Modelpaper count: " + modelPaperCount);
                }
            }
        });
    }

    /**
     * Animates a small rectangle that moves randomly across the screen.
     */
    private void paperClickAnimation() {
        Group rectangles = new Group();

        Rectangle rectangle = new Rectangle(10, 20, Color.web("black", 0.05));
        rectangle.localToScene(0, 10, true);
        rectangle.setStrokeType(StrokeType.OUTSIDE);
        rectangle.setStroke(Color.web("black", 0.16));
        rectangle.setStrokeWidth(4);
        rectangles.getChildren().add(rectangle);

        Timeline timeline = new Timeline();

        for (Node rectangleTimeLine : rectangles.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(rectangleTimeLine.translateXProperty(), random() * 50),
                            new KeyValue(rectangleTimeLine.translateYProperty(), random() * 400)
                    ),
                    new KeyFrame(new Duration(2000), // set end position at 40s
                            new KeyValue(rectangleTimeLine.translateXProperty(), random() * 50),
                            new KeyValue(rectangleTimeLine.translateYProperty(), random() * 400)
                    )
            );
        }
        //Sets a fade transition to 3 seconds. From opacity 1 to 0
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        timeline.setOnFinished(event -> {
            rectangle.setVisible(false);
        });
        timeline.play();

        grid.getChildren().add(rectangle);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
