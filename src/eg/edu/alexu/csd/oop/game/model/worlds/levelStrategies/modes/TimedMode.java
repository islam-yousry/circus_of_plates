package eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.modes;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.constant.ConveyorBelt;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.LeftStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.RightStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.ShapeFactory;
import eg.edu.alexu.csd.oop.game.model.utils.score.Score;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.Difficulty;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TimedMode implements Mode {

    private long gameTime;
    private long timeLeft;
    private long startTime = System.currentTimeMillis();
    private Difficulty difficulty;
    private ShapeFactory factory;
    private List<GameObject> intersectedObjects = new ArrayList<>();

    public TimedMode(Difficulty difficulty) {
        this.difficulty = difficulty;
        factory = new ShapeFactory(difficulty.getColors());
        gameTime = difficulty.getGameTime();
        for (GameObject gameObject : difficulty.getConstantObjects()) {
            if (gameObject instanceof ConveyorBelt)
                intersectedObjects.add(gameObject);
        }
        for (GameObject gameObject : difficulty.getMovableObjects()) {
            if (gameObject instanceof LeftStick || gameObject instanceof RightStick)
                intersectedObjects.add(gameObject);
        }
    }

    @Override
    public boolean refresh() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        boolean leftStick = true, rightStick = true;
        timeLeft = gameTime - (System.currentTimeMillis() - startTime);
        if (Math.random() < difficulty.getShapeProbability())
            difficulty.setMovableObjects(factory.createShape((int) (Math.random() * difficulty.getShapeCount()), difficulty.getConveyorPosition(), new Random().nextBoolean()));
        Iterator<GameObject> iterator = difficulty.getMovableObjects().iterator();
        while (iterator.hasNext()) {
            GameObject temp = iterator.next();
            ShapeObject shape;
            if (temp instanceof ShapeObject) {
                shape = (ShapeObject) temp;
                if (shape.getState().actUponState(intersectedObjects, difficulty.getSpeed()))
                    iterator.remove();
            } else if (temp instanceof LeftStick) {
                if (temp.getY() - ((LeftStick) temp).getStack().getStackHeight() <= 50)
                    leftStick = false;
            } else if (temp instanceof RightStick) {
                if (temp.getY() - ((RightStick) temp).getStack().getStackHeight() <= 50)
                    rightStick = false;
            }
        }
        return timeLeft > 0 && (leftStick || rightStick);
    }

    @Override
    public String getStatus() {
        return "Score: " + Score.getInstance().getScore() + " Time Left: " + Math.max(0, timeLeft) / 1000;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
