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

/**
 * Class that creates a menu when the game is over.
 */
public class GameOverMenu extends FXGLMenu {
    public GameOverMenu() {
        super(MenuType.GAME_MENU);
        var exitGameButton = new ExitGameButton("Exit",this::fireExitToMainMenu);
        exitGameButton.setTranslateX(getAppWidth()/2 - 200/2);
        exitGameButton.setTranslateY(getAppHeight()/2-40/2);
        getMenuContentRoot().getChildren().add(exitGameButton);
    }

    /**
     * Creates an action button.
     *
     * @param stringBinding
     * @param runnable
     * @return new Button
     */
    @Override
    protected Button createActionButton( StringBinding stringBinding, Runnable runnable) {
        return new Button();
    }

    /**
     * Creates an action button.
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
     * @return new Rectangle
     */
    @Override
    protected Node createBackground(double width, double height) {
        return new Rectangle(width, height, Color.DARKGREY);
    }

    /**
     * Creates the profile view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createProfileView(String s) {
        return new Text();
    }

    /**
     * Creates the title view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createTitleView(String s) {
        return new Text();
    }

    /**
     * Creates the version view.
     *
     * @param s
     * @return new Text
     */
    @Override
    protected Node createVersionView(String s) {
        return new Text();
    }

    /**
     * Creates the Exit game button that permits user to exit the game
     */
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