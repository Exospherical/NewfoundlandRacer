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
        showMessage("You Hit a Pothole and Died!");
        // FXGL.getGameController().gotoGameMenu();
    }
}