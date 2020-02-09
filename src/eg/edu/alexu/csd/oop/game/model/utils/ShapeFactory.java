package eg.edu.alexu.csd.oop.game.model.utils;

import eg.edu.alexu.csd.oop.game.control.dynamicLoading;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Bowl;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Plate;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;
import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Vase;

import java.lang.reflect.InvocationTargetException;

public class ShapeFactory {

    Class<? extends ShapeObject>[] classes = new Class[3];

    private String[] colors;
    private dynamicLoading dynamic = new dynamicLoading();

    public ShapeFactory(String[] colors) {
        this.colors = colors;
    }

    public ShapeObject createShape(int x, boolean top, boolean right) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        classes[0] = dynamic.dynamicLoad("D:\\70_circus_of_plates\\eg\\edu\\alexu\\csd\\oop\\game\\model\\gameObjects\\movable\\shapes", "eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Plate");
        classes[1] = dynamic.dynamicLoad("D:\\output\\production\\70_circus_of_plates\\eg\\edu\\alexu\\csd\\oop\\game\\model\\gameObjects\\movable\\shapes", "eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Bowl");
        classes[2] = dynamic.dynamicLoad("D:\\output\\production\\70_circus_of_plates\\eg\\edu\\alexu\\csd\\oop\\game\\model\\gameObjects\\movable\\shapes", "eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.Vase");

        double color = Math.random() * colors.length;

        Class<? extends ShapeObject> result = classes[x];
        switch (x) {
            case 0:
                return new Plate(right, top, colors[(int) color]);
            case 1:
                return new Bowl(right, top, colors[(int) color]);
            case 2:
                return new Vase(right, top, colors[(int) color]);
        }
        return result.getDeclaredConstructor(int.class, boolean.class, boolean.class).newInstance(x, top, right);
    }
}
