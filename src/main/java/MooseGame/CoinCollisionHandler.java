package MooseGame;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class CoinCollisionHandler extends CollisionHandler {

    public CoinCollisionHandler() {
        super(EntityType.Player, EntityType.COIN);
    }
    @Override
    protected void onCollisionBegin(Entity Player, Entity COIN) {

        //spawn("scoreText", new SpawnData(200, 500));
        COIN.removeFromWorld();
        inc("score", +100);
        play("coincollect.wav");
    }
}
