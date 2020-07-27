package MooseGame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class NewfoundRacerApp extends GameApplication {

    private Entity player;
    private int DRIVEUP = 1;
    private int DRIVEDOWN = 0;
    private int heightIncreaser = 50;

    /**
     * The settings for the game window.
     * @param settings
     * the game window settings
     */
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(840);
        settings.setHeight(650);
        settings.setTitle("Newfoundland Moose Collision");
        settings.setVersion("0.1");
        settings.setMainMenuEnabled(true);
        settings.setSceneFactory(new SceneFactory(){
            @Override
            public NewfoundlandRacerMainMenu newMainMenu(){
                return new NewfoundlandRacerMainMenu();

            }
                                 }

        );

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
                player.rotateBy(5);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.rotateBy(-5);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                Vec2 dir = Vec2.fromAngle(player.getRotation()).mulLocal(6);
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
        spawn("background", 0, 0);
        player = spawn("player", 300, 300);
        getGameScene().getViewport().bindToEntity(player, getAppWidth()/2, getAppHeight()/2);
        getGameScene().getViewport().setBounds(0,-Integer.MAX_VALUE,getAppWidth(), Integer.MAX_VALUE);

        //this function implements runnable allowing parameters to be passed
        getGameTimer().runAtInterval(() -> spawnDriver() , Duration.seconds(0.5));
        getGameTimer().runAtInterval(this::incrementHeight , Duration.seconds(2));
        getGameTimer().runAtInterval(this::spawnCoin , Duration.seconds(10));
    }

    /**
     * Contains game variables, like score
     * @param vars
     */
    @Override
    protected void initGameVars(Map<String, Object> vars){
        vars.put("score", 0);
    }

    @Override
    protected void initPhysics(){
        var playerCollisionHandler = new PlayerCollisionHandler();
        getPhysicsWorld().addCollisionHandler(playerCollisionHandler);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
    TODO: maybe make every few seconds alive gives a point too?
     */
    @Override
    protected void initUI() {
        Text uiScore = new Text("");
        uiScore.setFont(Font.font(72));
        uiScore.setTranslateX(getAppWidth() - 200);
        uiScore.setTranslateY(50);
        uiScore.textProperty().bind(getip("score").asString());
        addUINode(uiScore);
    }

    /**
     * This method is used to spawn a driver object on the road, in one of the 4 lanes randomly.
     * TODO: Add slightly random x-axis variation to make game more interesting
     */
    private void spawnDriver() {
        int lane = FXGL.random(0,3);
            if (lane == 0) {
                getGameWorld().spawn("driver", 595, -getAppHeight() - heightIncreaser);
            }
            else if (lane == 1) {
                getGameWorld().spawn("driver", 450, -getAppHeight()- heightIncreaser);
            }
            else if (lane == 2) {
                getGameWorld().spawn("driver", 350, -getAppHeight()- heightIncreaser);
            }
            else if (lane == 3) {
                getGameWorld().spawn("driver", 175, -getAppHeight()- heightIncreaser);
            }
    }

    /**
     * TODO: Add slight random x-axis variation to make game more interesting
     */
    private void spawnCoin(){
        int lane = FXGL.random(0,3);
        if (lane == 0) {
            getGameWorld().spawn("coin", 595, -getAppHeight() - heightIncreaser);
        }
        else if (lane == 1) {
            getGameWorld().spawn("coin", 450, -getAppHeight()- heightIncreaser);
        }
        else if (lane == 2) {
            getGameWorld().spawn("coin", 350, -getAppHeight()- heightIncreaser);
        }
        else if (lane == 3) {
            getGameWorld().spawn("coin", 175, -getAppHeight()- heightIncreaser);
        }
    }

    private int incrementHeight(){
        heightIncreaser += 800;
        //System.out.println(player.getX());
       // System.out.println(player.getY());
        return heightIncreaser;

    }
}
