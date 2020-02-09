package eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes;

public class Vase extends ShapeObject {

    public Vase(boolean right, boolean top, String color) {
        super(right ? 1340 : 0, top ? 0 : 200 - 60, new String[]{"/vase_" + color + ".png"});
        this.color = color;
        this.isRight = right;
    }
}
