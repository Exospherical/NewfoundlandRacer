package MooseGame;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class MooseCollisionHandler extends CollisionHandler {

    public MooseCollisionHandler() {
        super(EntityType.Player, EntityType.MOOSE);
    }
    @Override
    protected void onCollisionBegin(Entity Player, Entity MOOSE) {
        MOOSE.removeFromWorld();
        FXGL.getDialogService().showBox("You hit a moose and died.",NewfoundlandRacerMainMenu.CreateGameOverScreen());


    }
}
