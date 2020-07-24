package MooseGame;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

public class GameObjectCreator implements EntityFactory {

    /**
     * TODO: Fill out the rest of the textures and animate to give the appearance of infinite scrolling.
     * @param data
     * @return
     *
     */
    @Spawns("background")
    public Entity newBackground(SpawnData data){
        return FXGL.entityBuilder()
                .from(data)
                .view("topdownroad.jpg")
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
                .from(data)
                .viewWithBBox("driver.png").rotate(-90)
                .with(new ProjectileComponent(new Point2D(0, -1), FXGLMath.random(50, 150)))
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
                .from(data)
                .viewWithBBox("player.png").rotate(-90)
                .collidable()
                .with(new PlayerComponent())
                .build();
    }
}
