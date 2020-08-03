package MooseGame;


import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.StringBinding;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameOverMenu extends FXGLMenu {
    public GameOverMenu() {
        super(MenuType.GAME_MENU);
        var exitGameButton = new ExitGameButton("Exit",this::fireExitToMainMenu);
        exitGameButton.setTranslateX(getAppWidth()/2 - 200/2);
        exitGameButton.setTranslateY(getAppHeight()/2-40/2);
        getMenuContentRoot().getChildren().add(exitGameButton);
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

    public static class ExitGameButton extends StackPane {
        public  ExitGameButton(String name, Runnable action) {
            var bg = new Rectangle(200,40, Color.BLACK);
            bg.setStroke(Color.WHITE);
            var text = FXGL.getUIFactoryService().newText(name, Color.WHITE, 18);
            getChildren().addAll(bg, text);
            setOnMouseClicked(e -> action.run());
        }
    }
}