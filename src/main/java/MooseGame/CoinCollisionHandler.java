package MooseGame;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * CoinCollisionHandler class that deals with all the events that were to occur if the player has collected a coin.
 */
public class CoinCollisionHandler extends CollisionHandler {

    /**
     *Method that connects the player and coin entities to the racer app.
     */
    public CoinCollisionHandler() {
        super(EntityType.Player, EntityType.COIN);
    }

    /**
     * Method that increases the score of the player if the player were to collect a coin.
     * @param Player
     * @param COIN
     */
    @Override
    protected void onCollisionBegin(Entity Player, Entity COIN) {

        //spawn("scoreText", new SpawnData(200, 500));
        COIN.removeFromWorld();
        inc("score", +100);
        play("coincollect.wav");
    }
}
