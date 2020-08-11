package MooseGame;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;

/**
 * PlayerComponent class that deals the generation of the components of the player.
 */
public class PlayerComponent extends Component {

    /**
     * Onadded method that deals he events after the player component has been added, namely its spawn position.
     */
    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(entity.getCenter());
    }

    /**
     * moveForward method that controls how the player is able to move forward on the map.
     */
    public void moveForward(){
        Vec2 dir = Vec2.fromAngle(entity.getRotation());
        entity.translate(dir);
    }

    /**
     * moveRight method that controls how the player is able to move right on the map.
     */
    public void rotateRight(){

    }
}
