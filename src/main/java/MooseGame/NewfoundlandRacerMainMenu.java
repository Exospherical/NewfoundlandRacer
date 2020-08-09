package MooseGame;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.StringBinding;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileInputStream;

public class NewfoundlandRacerMainMenu extends FXGLMenu {
    private Node mainScreen;
    private Node highScoreScreen;
    private StackPane carChooserScreen;
    private Node optionsScreen;
    private final String currentdirectory = System.getProperty("user.dir");


    public NewfoundlandRacerMainMenu() {
        super(MenuType.MAIN_MENU);
        mainScreen = CreateMainScreen();
        optionsScreen = CreateOptionsScreen();
        carChooserScreen = CreateCarScreen();
        highScoreScreen = CreateHighScoreScreen();
        mainScreen.setTranslateX(getAppWidth()/2 - 200/2);
        mainScreen.setTranslateY(getAppHeight()/2-40/2);
        getMenuContentRoot().getChildren().addAll(mainScreen);
        ShowMainMenu();
        //mainScreen.getParent().setTranslateY(200);
       // mainScreen.getParent().setTranslateX(350);
    }

    /**
     * Busted
     * @return
     */
    private void ShowMainMenu(){
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/mainmenu.png");
        bg.setFitHeight(840);

        getContentRoot().getChildren().add(0,bg);
        getMenuContentRoot().getChildren().clear();

        getMenuContentRoot().getChildren().addAll(mainScreen);
    }

    /**
     * Busted
     */
    private void ShowOptionsMenu(){
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView("file:"+currentdirectory+"/src/main/resources/assets/textures/optionsmenu.jpg");
       // getContentRoot().getChildren().add(0,bg);
        //System.out.println(getContentRoot().getChildren().get(0));
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(optionsScreen);

    }

    /**
     * Busted
     */
    private void ShowCarMenu(){
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/garagebackground.png");
        getContentRoot().getChildren().add(0,bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(carChooserScreen);
    }

    /**
     * Busted
     */
    private void ShowScoreMenu(){
        getContentRoot().getChildren().remove(0);
        ImageView bg = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/opt.jpg");
        getContentRoot().getChildren().add(0,bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(highScoreScreen);
    }

    private Node CreateMainScreen(){
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        //mainBox.setPrefSize(getAppWidth()/2-200, getAppHeight()/2-300);

        Button startGameButton = new Button("Start New Game");
        Button gameOptionsButton = new Button("Options");
        Button exitGameButton = new Button("Exit Game");
        startGameButton.setAlignment(Pos.TOP_CENTER);
        startGameButton.setOnAction((event) -> {fireNewGame();});
        gameOptionsButton.setOnAction((event) -> {CreateOptionsScreen();});
        exitGameButton.setOnAction((event) -> {fireExit();});
        String hoverStyle = "-fx-background-color:#0000ff";
        String quitStyle = "-fx-background-color:#ff0000";
        String regularStyle = "-fx-background-color:#ffffff";
        startGameButton.setStyle(regularStyle);
        gameOptionsButton.setStyle(regularStyle);
        exitGameButton.setStyle(regularStyle);



        mainBox.getChildren().add(startGameButton);
        mainBox.getChildren().add(gameOptionsButton);
        mainBox.getChildren().add(exitGameButton);
        startGameButton.setOnMouseEntered((event) -> startGameButton.setStyle(hoverStyle) );
        startGameButton.setOnMouseExited((event) -> startGameButton.setStyle(regularStyle) );

        gameOptionsButton.setOnMouseEntered((event) -> gameOptionsButton.setStyle(hoverStyle) );
        gameOptionsButton.setOnMouseExited((event) -> gameOptionsButton.setStyle(regularStyle) );
        //set on click event for options menu
        gameOptionsButton.setOnAction((event) -> ShowOptionsMenu() );


        exitGameButton.setOnMouseEntered((event) -> exitGameButton.setStyle(quitStyle) );
        exitGameButton.setOnMouseExited((event) -> exitGameButton.setStyle(regularStyle) );

        return  mainBox;
    }


    private Node CreateOptionsScreen(){
        GridPane optionsBox = new GridPane();

        String backgroundImageURL = "file:"+currentdirectory+"/src/main/resources/assets/textures/optionsmenu.jpg";

        Image image = new Image(backgroundImageURL);
        ImageView imageView = new ImageView(image);

        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPrefSize(800.0, 600.0);
        Button mainmenuButton = new Button("Back");
        Button carChooserButton = new Button("Choose Car");
        Button highScoreButton = new Button("High Scores");
        mainmenuButton.setOnAction((event) -> ShowMainMenu() );
        carChooserButton.setOnAction((event) -> ShowCarMenu() );



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

    private void selectFirstCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/TopDownAMCar.jpg");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);

        carChooserScreen.getChildren().add(carView);
    }
    private void selectSecondCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/TopDownAMCar2.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);

        carChooserScreen.getChildren().add(carView);
    }
    private void selectThirdCar(){

        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/TopDownAMCar3.jpg");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);

        carChooserScreen.getChildren().add(carView);
    }
    private void selectFourthCar(){

        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/TopDownAMCar2.png");
        carView.setFitHeight(201);
        carView.setFitWidth(251);
        carView.setPreserveRatio(true);

        carChooserScreen.getChildren().add(carView);
    }

    private StackPane CreateCarScreen(){
        StackPane pane = new StackPane();
        pane.setPrefSize(800.0,600.0);
        pane.setAlignment(Pos.CENTER);

        VBox carBox = new VBox();
        carBox.setAlignment(Pos.CENTER);
        carBox.setPrefSize(200.0, 40.0);
        Button mainmenuButton = new Button("Back");
        mainmenuButton.setOnAction((event) -> {ShowMainMenu();});

        mainmenuButton.setLayoutX(200);
        Button firstCarButton = new Button("Car One");
        firstCarButton.setOnAction((event) -> {selectFirstCar();});
        carBox.getChildren().add(firstCarButton);

        Button secondCarButton = new Button("Car Two");
        secondCarButton.setOnAction((event) -> {selectSecondCar();});
        carBox.getChildren().add(secondCarButton);

        Button thirdCarButton = new Button("Car Three");
        thirdCarButton.setOnAction((event) -> {selectThirdCar();
        });
        carBox.getChildren().add(thirdCarButton);

        Button fourthCarButton = new Button("Car Four");
        fourthCarButton.setOnAction((event) -> {selectFourthCar();});
        carBox.getChildren().add(fourthCarButton);

        carBox.getChildren().add(mainmenuButton);


        ImageView carView = new ImageView( "file:"+currentdirectory+"/src/main/resources/assets/textures/TopDownAMCar.jpg");

        pane.getChildren().add(carBox);
        pane.getChildren().add(carView);


        carBox.setAlignment(Pos.CENTER_LEFT);


        return pane;
    }
    private Node CreateHighScoreScreen(){
        VBox highScoreBox = new VBox();
        highScoreBox.setPrefSize(800.0,600.0);
        highScoreBox.setAlignment(Pos.CENTER);
        Button mainmenuButton = new Button("Back");
        highScoreBox.getChildren().add(mainmenuButton);

        return highScoreBox;
    }


    @Override
    protected Button createActionButton( StringBinding stringBinding, Runnable runnable) {
        return new Button();
    }

    @Override
    protected Button createActionButton(String s, Runnable runnable) {
        return new Button();
    }

    @Override
    protected Node createBackground(double width, double height) {

        return new Rectangle(width, height, Color.DARKGREY);


    }

    @Override
    protected Node createProfileView(String s) {
        return new Text();
    }

    @Override
    protected Node createTitleView(String s) {
        return new Text();
    }

    @Override
    protected Node createVersionView(String s) {
        return new Text();
    }

    public static class StartGameButton extends StackPane {
        public StartGameButton(String name, Runnable action) {
            var bg = new Rectangle(200,40, Color.BLACK);
            bg.setStroke(Color.WHITE);
            var text = FXGL.getUIFactoryService().newText(name, Color.WHITE, 18);
            getChildren().addAll(bg, text);
            setOnMouseClicked(e -> action.run());
        }
    }
}
