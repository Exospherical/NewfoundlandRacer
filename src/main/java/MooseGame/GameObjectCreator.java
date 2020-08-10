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
 * This class handles all entity spawning.
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
     * Other drivers spawn in in a lane, and continue going straight.
     * TODO: ADD COLLISION
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
     * Spawns the player entity.
     *
     * @param data
     * @return
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
                    //.scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        } else if (NewfoundlandRacerMainMenu.getSelectedCar() == 2) {

            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("driver2.png").rotate(-90)
                    //.scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        } else  {
            return FXGL.entityBuilder()
                    .type(EntityType.Player)
                    //.from(data)
                    .viewWithBBox("driver3.png").rotate(-90)
                    //.scale(1.5, 1.5)
                    .collidable()
                    .with(new PlayerComponent())
                    .build();
        }
    }

    /**
     * Spawns an animated coin sprite that moves the same speed as other drivers in the -y axis.
     * @param data
     * @return
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
     * Spawns moose that runs from right to left across the road. animated sprite.
     * @param data
     * @return
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
     * spawns a stationary pothole in the lane that car drive down.
     * @param data
     * @return
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
