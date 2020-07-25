package MooseGame;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.inc;
import static com.almasb.fxgl.dsl.FXGLForKtKt.play;

public class PlayerCollisionHandler extends CollisionHandler {

    public PlayerCollisionHandler() {
        super(EntityType.Player, EntityType.COIN);
    }

    @Override
    protected void onCollisionBegin(Entity Player, Entity COIN) {
        COIN.removeFromWorld();
        inc("score", +100);
        play("coincollect.wav");

    }
}
