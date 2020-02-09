package eg.edu.alexu.csd.oop.game.model.gameObjects.constant;

import eg.edu.alexu.csd.oop.game.model.gameObjects.GameObjectImpl;

public class ConveyorBelt extends GameObjectImpl {

    public ConveyorBelt(int x, int y) {
        super(x, y, new String[]{"/conveyor.png"});
        this.height = getSpriteImages()[0].getHeight();
        this.width = getSpriteImages()[0].getWidth();
        this.visible = true;
    }
}
