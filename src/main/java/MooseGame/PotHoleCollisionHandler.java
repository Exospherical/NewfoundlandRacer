package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * MooseCollisionHandler class that deals with all the events that were to occur if the player were to hit a Pothole.
 */
public class PotHoleCollisionHandler extends CollisionHandler {

    /**
     * CoinCollisionHandler class that deals with all the events that were to occur if the player has collected a coin.
     */
    public PotHoleCollisionHandler() {
        super(EntityType.Player, EntityType.POTHOLE);
    }

    /**
     *  Method that ends the game and prompts with a dialog box if you were to hit a pothole.
     * @param Player
     * @param DRIVER
     */
    @Override
    protected void onCollisionBegin(Entity Player, Entity DRIVER) {
        //DRIVER.removeFromWorld();
        FXGL.getDialogService().showBox("You hit a pothole and died.",NewfoundlandRacerMainMenu.CreateGameOverScreen());

        // FXGL.getGameController().gotoGameMenu();
    }
}