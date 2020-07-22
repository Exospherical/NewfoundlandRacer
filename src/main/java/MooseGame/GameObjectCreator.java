package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

public class GameObjectCreator implements EntityFactory {

    @Spawns("background")
    public Entity newBackground(SpawnData data){
        return FXGL.entityBuilder()
                .from(data)
                .view("topdownroad.jpg")
                .build();
    }

    @Spawns("player")
    public Entity newPlayer(SpawnData data){
        return FXGL.entityBuilder()
                .from(data)
                .view("player.png").rotate(-90)
                .with(new PlayerComponent())
                .build();

    }
}
