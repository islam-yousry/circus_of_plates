package eg.edu.alexu.csd.oop.game.model.utils.snapshot;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public class Originator {

    public SnapShot createSnapshot(List<GameObject> controllableObjects, List<GameObject> movableObjects){
        return new SnapShot(controllableObjects, movableObjects);
    }
}
