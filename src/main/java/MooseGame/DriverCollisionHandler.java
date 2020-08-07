package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class DriverCollisionHandler extends CollisionHandler {

    public DriverCollisionHandler() {
        super(EntityType.Player, EntityType.DRIVER);
    }

    @Override
    protected void onCollisionBegin(Entity Player, Entity DRIVER) {
        //DRIVER.removeFromWorld();
         showMessage("You Hit a Car and Died!");
        //FXGL.getGameController().gotoGameMenu();
    }
}