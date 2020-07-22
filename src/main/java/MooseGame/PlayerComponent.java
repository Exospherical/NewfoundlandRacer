package MooseGame;

import com.almasb.fxgl.entity.component.Component;

public class PlayerComponent extends Component {

    public void rotateLeft(){
        entity.rotateBy(-5);
    }

    public void rotateRight(){

    }
}
