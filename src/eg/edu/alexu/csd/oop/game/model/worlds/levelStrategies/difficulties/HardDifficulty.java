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
import java.util.Random;

public class HardDifficulty implements Difficulty {

    private ClownObject clown = new ClownObject(625, 475);
    private List<GameObject> movableObjects = new ArrayList<>();
    private List<GameObject> controllableObjects = new ArrayList<>();
    private List<GameObject> constantObjects = new ArrayList<>();

    public HardDifficulty() {
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
        constantObjects.add(new ConveyorBelt(-100, 200));
        constantObjects.add(new ConveyorBelt(960 + 70, 200));
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
        return 2;
    }

    @Override
    public int getControlSpeed() {
        return 15;
    }

    @Override
    public double getPowerUpProbability() {
        return 0;
    }

    @Override
    public double getShapeProbability() {
        return 0.02;
    }

    @Override
    public int getGameTime() {
        return 60000;
    }

    @Override
    public int getShapeCount() {
        return 3;
    }

    @Override
    public String[] getColors() {
        return new String[]{"red", "yellow", "green", "cyan", "orange"};
    }

    @Override
    public boolean getConveyorPosition() {
        return new Random().nextBoolean();
    }
}
