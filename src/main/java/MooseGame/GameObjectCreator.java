package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * This class handles all entity spawning for the Racer App.
 */
public class GameObjectCreator implements EntityFactory {
    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        return FXGL.entityBuilder()
                .type(EntityType.BACKGROUND)
                .view(new ScrollingBackgroundView(getAssetLoader().loadTexture("4lanehighway.png", 840, 750),
                        Orientation.VERTICAL))
                .zIndex(-1)
                .build();
    }

    /**
     * Method that generates AI Driver entities that will drive straight
     *
     * @param data
     * @return
     */
    @Spawns("driver")
    public Entity newDriver(SpawnData data) {
        return FXGL.entityBuilder()
                .type(EntityType.DRIVER)
                .from(data)
                .viewWithBBox("driver" + FXGL.random(0, 4) + ".png").rotate(-90)
                .with(new ProjectileComponent(new Point2D(0, -1), 150))
                .collidable()
                .scale(1.5, 1.5)
                .build();
    }

    /**
     * Method that generates the player entity in their car onto the map
     *
     * @param data
     * @return drivers selected car
     */
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        if (NewfoundlandRacerMainMenu.getSelectedCar() == 0) {
            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("player.png").rotate(-90)
                    .scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        } else if (NewfoundlandRacerMainMenu.getSelectedCar() == 1) {
            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("driver1.png").rotate(-90)
                    .scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        } else if (NewfoundlandRacerMainMenu.getSelectedCar() == 2) {

            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("driver2.png").rotate(-90)
                    .scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        } else  {
            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("driver3.png").rotate(-90)
                    .scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        }
    }

    /**
     * Generates a coin sprite that also moves forward and can be collected by the driver to increase score.
     * @param data
     * @return coin
     */
    @Spawns("coin")
    public Entity coin(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.COIN)
                .from(data)
                .viewWithBBox(texture("coin.png").toAnimatedTexture(6, Duration.seconds(0.66)).loop())
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, -1), 150))
                .rotate(90)
                .scale(0.5,0.5)
                .build();
    }

    /**
     * Generates a moose that runs across the road as an obstacle for the driver, will end game if hit.
     * @return Moose obstacle
     */
    @Spawns("moose")
    public Entity moose(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.MOOSE)
                .from(data)
                .viewWithBBox(texture("cowmoosespriterunning.png").toAnimatedTexture(3, Duration.seconds(0.6)).loop())
                .collidable()
                .with(new ProjectileComponent(new Point2D(-1, 0), 150))
                .rotate(180)
                .scale(1.5,1.5)
                .build();
    }

    /**
     * Generates a stationary pothole in a lane as an obstacle for the driver, will end game if hit.
     * @param data
     * @return Pothole obstacle
     */
    @Spawns("pothole")
    public Entity pothole(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.POTHOLE)
                .from(data)
                .viewWithBBox("pothole.png")
                .collidable()
                .scale(0.15,0.15)
                .build();
    }
}
