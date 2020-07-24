package MooseGame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class NewfoundRacerApp extends GameApplication {

    private Entity player;

    /**
     * The settings for the game window.
     * @param settings
     * the game window settings
     */
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(700);
        settings.setHeight(500);
        settings.setTitle("Newfoundland Moose Collision");
        settings.setVersion("0.1");
    }

    /**
     * This method sets up the controls that the player uses to move.
     */
    @Override
    protected void initInput() {
        Input input = FXGL.getInput();
        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.rotateBy(5); // move right 5 pixels
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.rotateBy(-5); // move left 5 pixels
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                Vec2 dir = Vec2.fromAngle(player.getRotation()).mulLocal(4);
                player.translate(dir);

            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                Vec2 dir = Vec2.fromAngle(player.getRotation()).mulLocal(-1);
                player.translate(dir);
            }
        }, KeyCode.S);
    }

    /**
     * This method sets up the gameplay loop by spawning the players, other cars and obstacles.
     */
    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new GameObjectCreator());
        spawn("background", 300, 150);
        player = spawn("player", 300, 300);

        //spawn("driver", 350, 350);
        getGameTimer().runAtInterval(this::spawnDriver, Duration.seconds(2));
    }

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This method is used to spawn a driver object on the road.
     */
    private void spawnDriver() {
        getGameWorld().spawn("driver", 350, 350);

    }
}
