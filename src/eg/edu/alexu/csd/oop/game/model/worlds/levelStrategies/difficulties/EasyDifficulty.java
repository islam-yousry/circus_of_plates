package eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.constant.Background;
import eg.edu.alexu.csd.oop.game.model.gameObjects.constant.ConveyorBelt;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.ClownObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.LeftStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.RightStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;

import java.util.ArrayList;
import java.util.List;

public class EasyDifficulty implements Difficulty {

    private ClownObject clown = new ClownObject(625, 475);
    private List<GameObject> movableObjects = new ArrayList<>();
    private List<GameObject> controllableObjects = new ArrayList<>();
    private List<GameObject> constantObjects = new ArrayList<>();

    public EasyDifficulty() {
        controllableObjects.add(clown);
        GameObject leftStick = new LeftStick(585, 435);
        GameObject rightStick = new RightStick(740, 452);
        movableObjects.add(leftStick);
        movableObjects.add(rightStick);
        clown.register_observer((Observer) leftStick);
        clown.register_observer((Observer) rightStick);
        constantObjects.add(new Background(0, 0));
        constantObjects.add(new ConveyorBelt(-30, 60));
        constantObjects.add(new ConveyorBelt(960, 60));
    }

    @Override
    public List<GameObject> getControllableObjects() {
        return controllableObjects;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    @Override
    public void setMovableObjects(ShapeObject shape) {
        movableObjects.add(shape);
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public double getPowerUpProbability() {
        return 0;
    }

    @Override
    public double getShapeProbability() {
        return 0.005;
    }

    @Override
    public int getGameTime() {
        return 3 * 60000;
    }

    @Override
    public int getShapeCount() {
        return 1;
    }

    public String[] getColors() {
        return new String[]{"red", "yellow", "green"};
    }

    @Override
    public boolean getConveyorPosition() {
        return true;
    }
}
