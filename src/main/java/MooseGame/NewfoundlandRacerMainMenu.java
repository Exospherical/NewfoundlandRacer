package MooseGame;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.StringBinding;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Class that creates the main menu for the Newfoundland Racer App.
 */
public class NewfoundlandRacerMainMenu extends FXGLMenu {
    private Node mainScreen;
    private Node highScoreScreen;
    private StackPane carChooserScreen;
    private Node optionsScreen;
    private final String currentDirectory = System.getProperty("user.dir");
    private static int selectedCar;


    /**
     * Method that creates the main menu but connecting all the nodes to the methods.
     */
    public NewfoundlandRacerMainMenu() {
        super(MenuType.MAIN_MENU);
        mainScreen = CreateMainScreen();
        optionsScreen = CreateOptionsScreen();
        carChooserScreen = CreateCarScreen();
        highScoreScreen = CreateHighScoreScreen();
        mainScreen.setTranslateX(getAppWidth() / 2 - 200 / 2);
        mainScreen.setTranslateY(getAppHeight() / 2 - 40 / 2);
        getMenuContentRoot().getChildren().addAll(mainScreen);
        ShowMainMenu();
        //mainScreen.getParent().setTranslateY(200);
        // mainScreen.getParent().setTranslateX(350);
    }

    /**
     * Draws the main menu when called, removing any node that were present before.
     */
    private void ShowMainMenu() {
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/mainmenu.png");
        bg.setFitHeight(840);
        getContentRoot().getChildren().add(0, bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(mainScreen);
    }

    /**
     * Draws the options menu, removing any other nodes that were present.
     */
    private void ShowOptionsMenu() {
        getContentRoot().getChildren().remove(0);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(optionsScreen);
    }

    /**
     * Draws the car selection menu.
     */
    private void ShowCarMenu() {
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/garagebackground.png");
        getContentRoot().getChildren().add(0, bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(carChooserScreen);
    }

    /**
     * Draws score menu.
     */
    private void ShowScoreMenu() {
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/opt.jpg");
        getContentRoot().getChildren().add(0, bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(highScoreScreen);
    }

    /**
     * Draws the main screen menu.
     *
     * @return mainBox
     */
    private Node CreateMainScreen() {
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        Button startGameButton = new Button("Start New Game");
        Button gameOptionsButton = new Button("Options");
        Button exitGameButton = new Button("Exit Game");
        startGameButton.setAlignment(Pos.TOP_CENTER);
        startGameButton.setOnAction((event) -> {
            fireNewGame();
        });
        gameOptionsButton.setOnAction((event) -> {
            CreateOptionsScreen();
        });
        exitGameButton.setOnAction((event) -> {
            fireExit();
        });
        String hoverStyle = "-fx-background-color:#0000ff";
        String quitStyle = "-fx-background-color:#ff0000";
        String regularStyle = "-fx-background-color:#ffffff";
        startGameButton.setStyle(regularStyle);
        gameOptionsButton.setStyle(regularStyle);
        exitGameButton.setStyle(regularStyle);
        mainBox.getChildren().add(startGameButton);
        mainBox.getChildren().add(gameOptionsButton);
        mainBox.getChildren().add(exitGameButton);
        startGameButton.setOnMouseEntered((event) -> startGameButton.setStyle(hoverStyle));
        startGameButton.setOnMouseExited((event) -> startGameButton.setStyle(regularStyle));
        gameOptionsButton.setOnMouseEntered((event) -> gameOptionsButton.setStyle(hoverStyle));
        gameOptionsButton.setOnMouseExited((event) -> gameOptionsButton.setStyle(regularStyle));
        //set on click event for options menu
        gameOptionsButton.setOnAction((event) -> ShowOptionsMenu());
        exitGameButton.setOnMouseEntered((event) -> exitGameButton.setStyle(quitStyle));
        exitGameButton.setOnMouseExited((event) -> exitGameButton.setStyle(regularStyle));
        return mainBox;
    }

    /**
     * Draws the options screen.
     *
     * @return optionsBox
     */
    private Node CreateOptionsScreen() {
        GridPane optionsBox = new GridPane();
        String backgroundImageURL = "file:" + currentDirectory + "/src/main/resources/assets/textures/optionsmenu.jpg";
        Image image = new Image(backgroundImageURL);
        ImageView imageView = new ImageView(image);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPrefSize(800.0, 600.0);
        Button mainmenuButton = new Button("Back");
        Button carChooserButton = new Button("Choose Car");
        Button highScoreButton = new Button("High Scores");
        mainmenuButton.setOnAction((event) -> ShowMainMenu());
        carChooserButton.setOnAction((event) -> ShowCarMenu());
        optionsBox.getChildren().add(imageView);
        GridPane.setHalignment(imageView, HPos.CENTER);
        optionsBox.getChildren().add(carChooserButton);
        GridPane.setHalignment(carChooserButton, HPos.LEFT);
        optionsBox.getChildren().add(highScoreButton);
        GridPane.setHalignment(highScoreButton, HPos.RIGHT);
        optionsBox.getChildren().add(mainmenuButton);
        GridPane.setHalignment(mainmenuButton, HPos.CENTER);
        return optionsBox;
    }

    /**
     * Method to change picture to first car on car selection menu.
     */
    private void selectFirstCar() {
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/player.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);
        carChooserScreen.getChildren().add(carView);
        selectedCar = 0;
    }

    /**
     * Method to change picture to second car in car selection menu.
     */
    private void selectSecondCar() {
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/driver1.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);
        carChooserScreen.getChildren().add(carView);
        selectedCar = 1;
    }

    /**
     * Method to change picture to 3rd car in car selection menu.
     */
    private void selectThirdCar() {
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/driver2.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);
        carChooserScreen.getChildren().add(carView);
        selectedCar = 2;

    }

    /**
     * Method to change picture in car selection menu to 4th car.
     */
    private void selectFourthCar() {
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/driver3.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);
        carChooserScreen.getChildren().add(carView);
        selectedCar = 2;

    }

    /**
     * Method to generate the overall car selection menu. Container for whole screen is a stackpane, with a vBox nested inside of it for buttons.
     *
     * @return pane
     */
    private StackPane CreateCarScreen() {
        StackPane pane = new StackPane();
        pane.setPrefSize(800.0, 600.0);
        pane.setAlignment(Pos.CENTER);
        VBox carBox = new VBox();
        carBox.setAlignment(Pos.CENTER);
        carBox.setPrefSize(200.0, 40.0);
        Button mainmenuButton = new Button("Back");
        mainmenuButton.setOnAction((event) -> {
            ShowMainMenu();
        });
        mainmenuButton.setLayoutX(200);
        Button firstCarButton = new Button("Car One");
        firstCarButton.setOnAction((event) -> {
            selectFirstCar();
        });
        carBox.getChildren().add(firstCarButton);
        Button secondCarButton = new Button("Car Two");
        secondCarButton.setOnAction((event) -> {
            selectSecondCar();
        });
        carBox.getChildren().add(secondCarButton);
        Button thirdCarButton = new Button("Car Three");
        thirdCarButton.setOnAction((event) -> {
            selectThirdCar();
        });
        carBox.getChildren().add(thirdCarButton);
        Button fourthCarButton = new Button("Car Four");
        fourthCarButton.setOnAction((event) -> {
            selectFourthCar();
        });
        carBox.getChildren().add(fourthCarButton);
        carBox.getChildren().add(mainmenuButton);
        ImageView carView = new ImageView("file:" + currentDirectory + "/src/main/resources/assets/textures/player.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        pane.getChildren().add(carBox);
        pane.getChildren().add(carView);
        carBox.setAlignment(Pos.CENTER_LEFT);
        return pane;
    }

    /**
     * Generates high score screen.
     *
     * @return highScoreBox
     */
    private Node CreateHighScoreScreen() {
        VBox highScoreBox = new VBox();
        highScoreBox.setPrefSize(800.0, 600.0);
        highScoreBox.setAlignment(Pos.CENTER);
        Button mainmenuButton = new Button("Back");
        highScoreBox.getChildren().add(mainmenuButton);
        return highScoreBox;
    }


    /**
     * Generates action button.
     *
     * @param stringBinding
     * @param runnable
     * @return new Button
     */
    @Override
    protected Button createActionButton(StringBinding stringBinding, Runnable runnable) {
        return new Button();
    }

    /**
     * Generates action button.
     *
     * @param s
     * @param runnable
     * @return new Button
     */
    @Override
    protected Button createActionButton(String s, Runnable runnable) {
        return new Button();
    }

    /**
     * Creates background.
     *
     * @param width
     * @param height
     * @return Rectangle
     */
    @Override
    protected Node createBackground(double width, double height) {

        return new Rectangle(width, height, Color.DARKGREY);
    }

    /**
     * Creates a profile view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createProfileView(String s) {
        return new Text();
    }

    /**
     * Creates title view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createTitleView(String s) {
        return new Text();
    }

    /**
     * Creates version view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createVersionView(String s) {
        return new Text();
    }

    /**
     * Creates a button to start the Racer app
     */
    public static class StartGameButton extends StackPane {
        public StartGameButton(String name, Runnable action) {
            var bg = new Rectangle(200, 40, Color.BLACK);
            bg.setStroke(Color.WHITE);
            var text = FXGL.getUIFactoryService().newText(name, Color.WHITE, 18);
            getChildren().addAll(bg, text);
            setOnMouseClicked(e -> action.run());
        }
    }

    /**
     * Gets the selected car and returns it.
     *
     * @return selectedCar
     */
    public static int getSelectedCar() {
        return selectedCar;
    }

    /**
     * Creates a game over screen by generating a VBox called gameEndDialog.
     *
     * @return gameEndDialog
     */
    static Node CreateGameOverScreen() {
        VBox gameEndDialog = new VBox();
        gameEndDialog.setPrefSize(400.0, 400.0);
        gameEndDialog.setAlignment(Pos.CENTER);
        int score = FXGL.geti("score");
        TextArea t = new TextArea();
        t.setFont(new Font(20));
        t.setText("Your score was: " + score);
        Button continueButton = new Button("Try Again");
        Button endButton = new Button("Quit to main menu");
        continueButton.setOnAction((event) -> FXGL.getGameController().startNewGame());
        gameEndDialog.getChildren().add(t);
        gameEndDialog.getChildren().add(continueButton);
        endButton.setOnAction((event) -> FXGL.getGameController().gotoMainMenu());
        gameEndDialog.getChildren().add(endButton);
        return gameEndDialog;
    }


}
