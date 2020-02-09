package eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.states;

import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.PlateStack;

public interface PlateStackState {

    int getChangeInHeight();

    void setChangeInHeight(int changeInHeight);

    ShapeObject getShape();

    boolean changeState(ShapeObject shape, PlateStack stack);
}
