package eg.edu.alexu.csd.oop.game.model.utils.score.plateStack;

import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;
import eg.edu.alexu.csd.oop.game.model.utils.score.Score;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.states.PlateStackState;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.states.Waiting;

import java.util.ArrayList;
import java.util.Stack;

public class PlateStack implements Subject {

    private ArrayList<Observer> observers = new ArrayList<>();
    private Stack<PlateStackState> stateStack = new Stack<>();
    private int stackHeight;

    public PlateStack() {
        stateStack.push(new Waiting(null));
        register_observer(Score.getInstance());
    }

    public Stack<PlateStackState> getStateStack() {
        return stateStack;
    }

    public void setStateStack(Stack<PlateStackState> stateStack) {
        this.stateStack = stateStack;
    }

    @Override
    public void register_observer(Observer e) {
        observers.add(e);
    }

    @Override
    public void notify_observers() {
        for (Observer e : observers) {
            e.update();
        }
    }

    public void checkStack(ShapeObject shape) {
        if (stateStack.peek().changeState(shape, this))
            notify_observers();
        setStackHeight(stateStack.peek().getChangeInHeight());
    }

    public int getStackHeight() {
        return stackHeight;
    }

    public void setStackHeight(int stackHeight) {
        this.stackHeight += stackHeight;
    }
}
