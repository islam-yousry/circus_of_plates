package eg.edu.alexu.csd.oop.game.model.utils.snapshot;

import java.util.ArrayList;

public class Caretaker {

    private ArrayList<SnapShot> history = new ArrayList<>();

    public void addSnapshot(SnapShot snapShot) {
        history.add(snapShot);
    }

    public ArrayList<SnapShot> getHistory() {
        return history;
    }
}
