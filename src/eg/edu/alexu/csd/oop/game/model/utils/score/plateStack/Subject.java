package eg.edu.alexu.csd.oop.game.model.utils.score.plateStack;

import eg.edu.alexu.csd.oop.game.model.utils.score.Observer;

public interface Subject {

    //adding observer
    void register_observer(Observer e);

    //notify observers when subject changes
    void notify_observers();

}
