package eg.edu.alexu.csd.oop.game.model.gameObjects;

import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

abstract public class GameObjectImpl implements GameObject {

    protected int width;
    protected int height;
    protected boolean visible;
    private int x;
    private int y;
    private BufferedImage[] spriteImages;

    public GameObjectImpl(int x, int y, String[] paths) {
        this.x = x;
        this.y = y;
        ArrayList<BufferedImage> spriteImages = new ArrayList<>();
        for (String path : paths) {
            try {
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream(path));
                spriteImages.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.spriteImages = spriteImages.toArray(new BufferedImage[0]);
    }

    @Override
    public int getX() {
        return Math.max(-100, Math.min(x, 1400));
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
}
