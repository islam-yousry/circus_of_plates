package eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.states;

import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.plateStates.PlateState;
import eg.edu.alexu.csd.oop.game.model.utils.plateStates.Useless;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.PlateStack;
import org.apache.log4j.Logger;

import java.util.Stack;

public class OneToGo implements PlateStackState {
    private static final Logger LOGGER = Logger.getLogger(PlateState.class);
    private ShapeObject shape;
    private int changeInHeight = 0;

    public OneToGo(ShapeObject shape) {
        this.shape = shape;
    }

    public ShapeObject getShape() {
        return shape;
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
    public boolean changeState(ShapeObject shape, PlateStack stack) {
        Stack<PlateStackState> temp = stack.getStateStack();
        if (this.shape != null && shape.getColor().equals(this.shape.getColor())) {
            shape.setState(new Useless());
            changeInHeight = 0;
            temp.peek().getShape().setState(new Useless());
            changeInHeight -= temp.pop().getShape().getHeight();
            temp.peek().getShape().setState(new Useless());
            changeInHeight -= temp.pop().getShape().getHeight();
            temp.peek().setChangeInHeight(changeInHeight);
            stack.setStateStack(temp);
            LOGGER.info("score updated");
            return true;
        }
        PlateStackState state = new Waiting(shape);
        state.setChangeInHeight(shape.getHeight());
        temp.push(state);
        stack.setStateStack(temp);
        return false;
    }
}
