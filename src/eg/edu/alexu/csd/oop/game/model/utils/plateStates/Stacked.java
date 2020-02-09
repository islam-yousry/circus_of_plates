package eg.edu.alexu.csd.oop.game.model.utils.plateStates;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;

import java.util.List;

public class Stacked implements PlateState {

    ShapeObject shape;

    public Stacked(ShapeObject shape) {
        this.shape = shape;
    }

    @Override
    public boolean actUponState(List<GameObject> gameObjects, int speed) {
        return false;
    }
}
