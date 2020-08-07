package MooseGame;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class NewfoundlandRacerMainMenu extends FXGLMenu {
    private Node mainScreen;
    private Node highScoreScreen;
    private Node carChooserScreen;
    private Node optionsScreen;

    public NewfoundlandRacerMainMenu() {
        super(MenuType.MAIN_MENU);
        mainScreen = CreateMainScreen();
        mainScreen.setTranslateX(getAppWidth()/2 - 200/2);
        mainScreen.setTranslateY(getAppHeight()/2-40/2);
        getMenuContentRoot().getChildren().addAll(mainScreen);
    }

    private Node CreateMainScreen(){
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPrefSize(200.0, 40.0);
        Button startGameButton = new Button("Start New Game");
        Button gameOptionsButton = new Button("Options");
        Button carChooserButton = new Button("Choose Car");
        Button highScoreButton = new Button("High Scores");
        Button exitGameButton = new Button("Exit Game");
        startGameButton.setAlignment(Pos.TOP_CENTER);
        startGameButton.setOnAction((event) -> {fireNewGame();});
        exitGameButton.setOnAction((event) -> {fireExit();});
        mainBox.getChildren().add(startGameButton);
        mainBox.getChildren().add(exitGameButton);


        return  mainBox;
    }
//    private Node CreateOptionsScreen(){
//
//    }
//    private Node CreateCarScreen(){
//
//    }
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
