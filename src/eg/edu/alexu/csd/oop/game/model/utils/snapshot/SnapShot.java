package eg.edu.alexu.csd.oop.game.model.utils.snapshot;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public class SnapShot {

    private List<GameObject> movableObjects;
    private List<GameObject> controllableObjects;

    public SnapShot(List<GameObject> movableObjects, List<GameObject> controllableObjects) {
        this.movableObjects = movableObjects;
        this.controllableObjects = controllableObjects;
    }

    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    public List<GameObject> getControllableObjects() {
        return controllableObjects;
    }
}
