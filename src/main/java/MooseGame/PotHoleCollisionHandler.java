package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class PotHoleCollisionHandler extends CollisionHandler {

    public PotHoleCollisionHandler() {
        super(EntityType.Player, EntityType.POTHOLE);
    }

    @Override
    protected void onCollisionBegin(Entity Player, Entity DRIVER) {
        //DRIVER.removeFromWorld();
        FXGL.getDialogService().showBox("You hit a pothole and died.",NewfoundlandRacerMainMenu.CreateGameOverScreen());

        // FXGL.getGameController().gotoGameMenu();
    }
}