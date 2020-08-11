package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * MooseCollisionHandler class that deals with all the events that were to occur if the player were to hit a Moose.
 */
public class MooseCollisionHandler extends CollisionHandler {

    /**
     *Method that connects the player and moose entities to the racer app.
     */
    public MooseCollisionHandler() {
        super(EntityType.Player, EntityType.MOOSE);
    }

    /**
     * Method that ends the game and prompts with a dialog box if you were to hit a moose.
     * @param Player
     * @param MOOSE
     */
    @Override
    protected void onCollisionBegin(Entity Player, Entity MOOSE) {
        MOOSE.removeFromWorld();
        FXGL.getDialogService().showBox("You hit a moose and died.",NewfoundlandRacerMainMenu.CreateGameOverScreen());


    }
}
