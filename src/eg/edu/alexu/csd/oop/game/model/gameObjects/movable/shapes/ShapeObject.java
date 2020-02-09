package eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.GameObjectImpl;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.LeftStick;
import eg.edu.alexu.csd.oop.game.model.gameObjects.controllable.RightStick;
import eg.edu.alexu.csd.oop.game.model.utils.plateStates.Conveyed;
import eg.edu.alexu.csd.oop.game.model.utils.plateStates.PlateState;
import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;

public abstract class ShapeObject extends GameObjectImpl implements Observer {

    protected boolean isRight;
    protected PlateState state = new Conveyed(this);
    protected String color;

    public ShapeObject(int x, int y, String[] paths) {
        super(x, y, paths);
        this.visible = true;
        this.height = getSpriteImages()[0].getHeight();
        this.width = getSpriteImages()[0].getWidth();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void update() {

    }

    @Override
    public void update(int x) {
        setX(x);
    }

    public String getColor() {
        return color;
    }

    public PlateState getState() {
        return state;
    }

    public void setState(PlateState state) {
        this.state = state;
    }

    public boolean isRight() {
        return this.isRight;
    }

    public boolean intersects(GameObject shape) {
        int absoluteHeight;
        if (shape instanceof LeftStick)
            absoluteHeight = shape.getY() - ((LeftStick) shape).getStack().getStackHeight();
        else if (shape instanceof RightStick)
            absoluteHeight = shape.getY() - ((RightStick) shape).getStack().getStackHeight();
        else
            absoluteHeight = shape.getY();
        return ((Math.abs(this.getY() + this.getHeight() - absoluteHeight) <= 4) && (Math.abs(this.getX() + this.getWidth() / 2 - (shape.getX() + shape.getWidth() / 2)) <= this.getWidth() / 2 + shape.getWidth() / 2));
    }

    public void vanish() {
        this.visible = false;
    }
}
