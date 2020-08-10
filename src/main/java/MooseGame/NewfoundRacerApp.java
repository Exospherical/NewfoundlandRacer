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
        settings.setSceneFactory(new SceneFactory() {
                                     @Override
                                     public NewfoundlandRacerMainMenu newMainMenu(){
                                         return new NewfoundlandRacerMainMenu();}});
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
                player.rotateBy(4);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.rotateBy(-4);
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
        spawn("background", 0, 0);
        player = spawn("player", 300, 300);
        getGameScene().getViewport().bindToEntity(player, getAppWidth()/2, getAppHeight()/2);
        getGameScene().getViewport().setBounds(0,-Integer.MAX_VALUE,getAppWidth(), Integer.MAX_VALUE);
        //this function implements runnable allowing parameters to be passed
        getGameTimer().runAtInterval(() -> spawnDriver() , Duration.seconds(3));
        getGameTimer().runAtInterval(this::spawnPotHole , Duration.seconds(5));
        getGameTimer().runAtInterval(this::spawnCoin , Duration.seconds(12));
        getGameTimer().runAtInterval(this::spawnMoose , Duration.seconds(10));
        getGameTimer().runAtInterval(() ->inc("score", +10), Duration.seconds(3));
        //getGameTimer().runAtInterval(this::getGameTime , Duration.seconds(1));
    }

    /**
     * Contains game variables, like score.
     * @param vars
     */
    @Override
    protected void initGameVars(Map<String, Object> vars){
        vars.put("score", 0);
        vars.put("selectedCar", 0);
    }

    @Override
    protected void initPhysics(){
        var coinCollisionHandler = new CoinCollisionHandler();
        var mooseCollisionHandler = new MooseCollisionHandler();
        var driverCollisionHandler = new DriverCollisionHandler();
        var potHoleCollisionHandler = new PotHoleCollisionHandler();
        getPhysicsWorld().addCollisionHandler(coinCollisionHandler);
        getPhysicsWorld().addCollisionHandler(mooseCollisionHandler);
        getPhysicsWorld().addCollisionHandler(driverCollisionHandler);
        getPhysicsWorld().addCollisionHandler(potHoleCollisionHandler);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes UI (score).
     * */
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
     */
    private void spawnDriver() {
        int lane = FXGL.random(0,3);
            if (lane == 0) {
                getGameWorld().spawn("driver", 595, player.getY()-400);
            }
            else if (lane == 1) {
                getGameWorld().spawn("driver", 450, player.getY()-400);

            }
            else if (lane == 2) {
                getGameWorld().spawn("driver", 350, player.getY()-400);
            }
            else if (lane == 3) {
                getGameWorld().spawn("driver", 175, player.getY()-400);
            }
    }

    /**
     * This method spawns a moose slighly ahead of the player, and runs in the x axis across the road.
     */
    private void spawnMoose() {
        getGameWorld().spawn("moose", 800, player.getY()-200);
    }
    /**
     * Spawns a coin in a random lane, with same speed as cars.
     */
    private void spawnCoin(){
        int lane = FXGL.random(0,3);
        if (lane == 0) {
            getGameWorld().spawn("coin", 595, player.getY()-400);
        }
        else if (lane == 1) {
            getGameWorld().spawn("coin", 450, player.getY()-400);
        }
        else if (lane == 2) {
            getGameWorld().spawn("coin", 350, player.getY()-400);
        }
        else if (lane == 3) {
            getGameWorld().spawn("coin", 175, player.getY()-400);
        }
    }

    /**
     * Spawns potholes on the road.
     */
    private void spawnPotHole() {
        int lane = FXGL.random(0, 3);
        if (lane == 0) {
            getGameWorld().spawn("pothole", 100, player.getY() -800);

        } else if (lane == 1) {
            getGameWorld().spawn("pothole", 200, player.getY() -800);

        } else if (lane == 2) {
            getGameWorld().spawn("pothole", -100, player.getY() -800);
        } else if (lane == 3) {
            getGameWorld().spawn("pothole", -200, player.getY() -800);
        }
    }

    private void getGameTime(){
        System.out.println();
        FXGL.getDialogService().showBox("ur ded lol",NewfoundlandRacerMainMenu.CreateGameOverScreen());
    }
}
