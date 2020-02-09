package eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes;

public class Bowl extends ShapeObject {

    public Bowl(boolean right, boolean top, String color) {
        super(right ? 1400 : 0, top ? 22 : 200 - 38, new String[]{"/bowl_" + color + ".png"});
        this.color = color;
        this.isRight = right;
    }
}
