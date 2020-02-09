package eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.modes;

import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.Difficulty;

import java.lang.reflect.InvocationTargetException;

public interface Mode {

    boolean refresh() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    String getStatus();

    Difficulty getDifficulty() throws NullPointerException;
}
