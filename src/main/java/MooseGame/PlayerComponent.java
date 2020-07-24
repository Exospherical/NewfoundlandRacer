package MooseGame;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;

public class PlayerComponent extends Component {

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(entity.getCenter());
    }

    public void moveForward(){
        Vec2 dir = Vec2.fromAngle(entity.getRotation());
        entity.translate(dir);
    }

    public void rotateRight(){

    }
}
