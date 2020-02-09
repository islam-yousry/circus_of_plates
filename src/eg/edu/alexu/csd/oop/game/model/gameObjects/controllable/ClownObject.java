package eg.edu.alexu.csd.oop.game.model.gameObjects.controllable;

import eg.edu.alexu.csd.oop.game.model.gameObjects.GameObjectImpl;
import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;
import eg.edu.alexu.csd.oop.game.model.utils.score.plateStack.Subject;

import java.util.ArrayList;
import java.util.List;

public class ClownObject extends GameObjectImpl implements Subject {

    private List<Observer> Observers = new ArrayList<>();

    public ClownObject(int x, int y) {
        super(x, y, new String[]{"/clown.png"});
        super.setX(x);
        this.visible = true;
        this.width = getSpriteImages()[0].getHeight();
        this.height = getSpriteImages()[0].getWidth();
    }

    @Override
    public void setY(int y) {
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        notify_observers();
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
}
