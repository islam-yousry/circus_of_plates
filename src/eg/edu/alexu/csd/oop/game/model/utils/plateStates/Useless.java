package eg.edu.alexu.csd.oop.game.model.utils.plateStates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public class Useless implements PlateState {

    @Override
    public boolean actUponState(List<GameObject> gameObjects, int speed) {
        return true;
    }
}
