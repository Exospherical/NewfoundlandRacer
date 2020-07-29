package MooseGame;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class MooseCollisionHandler extends CollisionHandler {

    public MooseCollisionHandler() {
        super(EntityType.Player, EntityType.MOOSE);
    }
    @Override
    protected void onCollisionBegin(Entity Player, Entity MOOSE) {

        //spawn("scoreText", new SpawnData(200, 500));
        MOOSE.removeFromWorld();
        //inc("score", +100);
        //play("coincollect.wav");
    }


}
