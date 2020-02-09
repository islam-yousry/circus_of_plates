package eg.edu.alexu.csd.oop.game.model.utils.plateStates;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.LeftStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.RightStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Plate;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.Subject;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class Falling implements PlateState {

    private ShapeObject shape;
    private static final Logger LOGGER = Logger.getLogger(PlateState.class);
    public Falling(ShapeObject shape) {
        this.shape = shape;
    }

    private void checkState(List<GameObject> gameObjects) {
        if (shape.getY() >= 700)
            shape.setState(new Useless());
        else {
            Iterator<GameObject> iterator = gameObjects.iterator();
            while (iterator.hasNext()) {
                GameObject temp = iterator.next();
                if (temp instanceof LeftStick) {
                    if (shape.intersects(temp)) {
                        ((Subject) temp).register_observer(shape);
                        shape.setState(new Stacked(shape));
                        ((LeftStick) temp).setStack(shape);
                        shape.setY(temp.getY() - ((LeftStick) temp).getStack().getStackHeight());
                    }
                } else if (temp instanceof RightStick) {
                    if (shape.intersects(temp)) {
                        ((Subject) temp).register_observer(shape);
                        shape.setState(new Stacked(shape));
                        ((RightStick) temp).setStack(shape);
                        shape.setY(temp.getY() - ((RightStick) temp).getStack().getStackHeight());
                    }
                }
            }
        }
    }

    @Override
    public boolean actUponState(List<GameObject> gameObjects, int speed) {
        checkState(gameObjects);
        if (shape instanceof Plate)
            shape.setY(shape.getY() + speed);
        else
            shape.setY(shape.getY() + 2 * speed);
        LOGGER.info(shape +" moved");
        return false;
    }
}
