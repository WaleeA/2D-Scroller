package game;

import city.cs.engine.*;

/**
 * This class stores the information on how the floor and other static platforms are created by the level
 */
public class Platform extends StaticBody {
    private float width;
    private float height;
    public Platform(World w,float width, float height) {
        super(w);
        Shape s = new BoxShape(width, height);
        Fixture f = new SolidFixture(this, s);
        this.width = width;
        this.height = height;

    }

    /**
     * functions below is used to hold the dimensions of the static platforms for whenever it is called outside of this class
     * @return
     */
    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
