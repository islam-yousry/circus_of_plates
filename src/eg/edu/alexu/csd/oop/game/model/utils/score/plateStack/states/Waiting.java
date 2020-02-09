package eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.states;

import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.PlateStack;

import java.util.Stack;

public class Waiting implements PlateStackState {

    private ShapeObject shape;
    private int changeInHeight;

    public Waiting(ShapeObject shape) {
        this.shape = shape;
    }

    @Override
    public int getChangeInHeight() {
        return changeInHeight;
    }

    @Override
    public void setChangeInHeight(int changeInHeight) {
        this.changeInHeight = changeInHeight;
    }

    @Override
    public ShapeObject getShape() {
        return shape;
    }

    @Override
    public boolean changeState(ShapeObject shape, PlateStack stack) {
        Stack<PlateStackState> temp = stack.getStateStack();
        shape.getHeight();
        PlateStackState state;
        if (this.shape != null && shape.getColor().equals(this.shape.getColor())) {
            state = new OneToGo(shape);
        } else {
            state = new Waiting(shape);
        }
        state.setChangeInHeight(shape.getHeight());
        temp.push(state);
        stack.setStateStack(temp);
        return false;
    }
}
