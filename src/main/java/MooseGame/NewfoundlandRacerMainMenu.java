package MooseGame;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class NewfoundlandRacerMainMenu extends FXGLMenu {
    private Node mainScreen;
    private Node highScoreScreen;
    private StackPane carChooserScreen;
    private Node optionsScreen;

    public NewfoundlandRacerMainMenu() {
        super(MenuType.MAIN_MENU);
        mainScreen = CreateMainScreen();
        optionsScreen = CreateOptionsScreen();
        mainScreen.setTranslateX(getAppWidth()/2 - 200/2);
        mainScreen.setTranslateY(getAppHeight()/2-40/2);
        getMenuContentRoot().getChildren().addAll(mainScreen);
//        ShowMainMenu();
    }

    /**
     * Busted
     * @return
     */
    private void ShowMainMenu(){
        getContentRoot().getChildren().remove(0);
        //ImageView bg = new ImageView("mainmenu.jpg");
        ///getContentRoot().getChildren().add(0,bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(mainScreen);
    }

    /**
     * Busted
     */
    private void ShowOptionsMenu(){
        getContentRoot().getChildren().remove(0);
        //ImageView bg = new ImageView("opt.jpg");
        //getContentRoot().getChildren().add(0,bg);
        getMenuContentRoot().getChildren().clear();
        getMenuContentRoot().getChildren().addAll(optionsScreen);
    }

    private Node CreateMainScreen(){
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPrefSize(200.0, 40.0);
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

        exitGameButton.setOnMouseEntered((event) -> exitGameButton.setStyle(quitStyle) );
        exitGameButton.setOnMouseExited((event) -> exitGameButton.setStyle(regularStyle) );


        return  mainBox;
    }


    private Node CreateOptionsScreen(){


        VBox optionsBox = new VBox();
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPrefSize(200.0, 40.0);
        Button mainmenuButton = new Button("Back");
        Button carChooserButton = new Button("Choose Car");
        Button highScoreButton = new Button("High Scores");

        optionsBox.getChildren().add(carChooserButton);
        optionsBox.getChildren().add(highScoreButton);
        optionsBox.getChildren().add(mainmenuButton);

        return optionsBox;
    }

    private void selectFirstCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("TopDownAMCar.jpg");
        carChooserScreen.getChildren().add(carView);
    }
    private void selectSecondCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("TopDownAMCar2.jpg");
        carChooserScreen.getChildren().add(carView);
    }
    private void selectThirdCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("TopDownAMCar3.jpg");
        carChooserScreen.getChildren().add(carView);
    }
    private void selectFourthCar(){
        carChooserScreen.getChildren().remove(1);
        ImageView carView = new ImageView("TopDownAMCar4.jpg");
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
        Button firstCarButton = new Button("Car One");
        firstCarButton.setOnAction((event) -> {selectFirstCar();});
        carBox.getChildren().add(firstCarButton);

        Button secondCarButton = new Button("Car Two");
        firstCarButton.setOnAction((event) -> {selectSecondCar();});
        carBox.getChildren().add(firstCarButton);

        Button thirdCarButton = new Button("Car Three");
        firstCarButton.setOnAction((event) -> {selectThirdCar();});
        carBox.getChildren().add(firstCarButton);

        Button fourthCarButton = new Button("Car Four");
        fourthCarButton.setOnAction((event) -> {selectFourthCar();});
        carBox.getChildren().add(firstCarButton);

        carBox.getChildren().add(mainmenuButton);

        ImageView carView = new ImageView("TopDownAMCar.jpg");
        pane.getChildren().add(carView);
        return pane;
    }
//    private Node CreateHighScoreScreen(){
//
//    }


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
