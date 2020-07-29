package MooseGame;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ExpireCleanComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class GameObjectCreator implements EntityFactory {

    /**
     * TODO: Fill out the rest of the textures and animate to give the appearance of infinite scrolling.
     * @param data
     * @return
     */
    @Spawns("background")
    public Entity newBackground(SpawnData data){
        /*
        return FXGL.entityBuilder()
                .from(data)
                .view("4lanehighway.png")
                .build();
         */
        return FXGL.entityBuilder()
                .type(EntityType.BACKGROUND)
                .view(new ScrollingBackgroundView(getAssetLoader().loadTexture("4lanehighway.png", 840, 750),
                        Orientation.VERTICAL))
                .zIndex(-1)
                .build();
    }

    /**
     * Other drivers spawn in in a lane, and continue going straight at a slightly random speed down the road.
     * TODO: ADD COLLISION
     * @param data
     * @return
     */
    @Spawns("driver")
    public Entity newDriver(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.DRIVER)
                .from(data)
                .viewWithBBox("driver" + FXGL.random(0,4)+".png").rotate(-90)
                .with(new ProjectileComponent(new Point2D(0, -1), 150))
                .collidable()
                .build();
    }

    /**
     * TODO: Add collision
     * @param data
     * @return
     */
    @Spawns("player")
    public Entity newPlayer(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.Player)
                .from(data)
                .viewWithBBox("player.png").rotate(-90)
                .collidable()
                .with(new PlayerComponent())
                .build();
    }

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

    @Spawns("moose")
    public Entity moose(SpawnData data){
        return FXGL.entityBuilder()
                .type(EntityType.MOOSE)
                .from(data)
                .viewWithBBox(texture("cowmoosespriterunning.png").toAnimatedTexture(3, Duration.seconds(0.6)).loop())
                .collidable()
                .with(new ProjectileComponent(new Point2D(-1, 0), 150))
                .rotate(180)
                //.scale(0.5,0.5)
                .build();
    }
}
