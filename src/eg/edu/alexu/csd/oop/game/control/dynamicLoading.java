package eg.edu.alexu.csd.oop.game.control;

import eg.edu.alexu.csd.oop.game.model.gameObjects.movable.shapes.ShapeObject;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class dynamicLoading {

    public Class<? extends ShapeObject> dynamicLoad(String path, String name) {
        File file = new File(path);

        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            ClassLoader cl = new URLClassLoader(urls);

            return (Class<? extends ShapeObject>) cl.loadClass(name);

        } catch (MalformedURLException | ClassNotFoundException e) {
            throw new NullPointerException();
        }

    }
}
