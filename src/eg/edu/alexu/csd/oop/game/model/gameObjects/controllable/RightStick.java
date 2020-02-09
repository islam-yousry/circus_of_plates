package eg.edu.alexu.csd.oop.game.model.gameObjects.controllable;

import eg.edu.alexu.csd.oop.game.model.gameObjects.GameObjectImpl;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.PlateStack;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.Subject;

import java.util.ArrayList;
import java.util.List;

public class RightStick extends GameObjectImpl implements Subject, Observer {

    private List<Observer> Observers = new ArrayList<>();
    private PlateStack stack = new PlateStack();

    public RightStick(int x, int y) {
        super(x, y, new String[]{"/right_stick.png"});
        this.visible = true;
        this.height = getSpriteImages()[0].getHeight();
        this.width = getSpriteImages()[0].getWidth();
    }

    @Override
    public void setY(int y) {
        this.height = y;
    }

    @Override
    public void setX(int x) {
        super.setX(x + 115);
        notify_observers();
    }

    @Override
    public void update() {
    }

    @Override
    public void update(int x) {
        setX(x);
    }

    @Override
    public void register_observer(Observer e) {
        Observers.add(e);
    }

    @Override
    public void notify_observers() {
        for (Observer observer : Observers)
            observer.update(this.getX());
    }

    @Override
    public int getHeight() {
        return super.getHeight() + getStack().getStackHeight();
    }

    public PlateStack getStack() {
        return stack;
    }

    public void setStack(ShapeObject shape) {
        this.stack.checkStack(shape);
    }
}
