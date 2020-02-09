package eg.edu.alexu.csd.oop.game.model.utils.plateStates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public interface PlateState {

    boolean actUponState(List<GameObject> gameObjects, int speed);
}
