package GameEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * @author Jack Kurfman
 * @version 5/5/2016.
 */
public class Graphics {

    public static final String GAME_TITLE = "The Game";
    public static final int DISPLAY_WIDTH = 800;
    public static final int DISPLAY_HEIGHT = 600;
    public static final int RESOLUTION = 16;

    public static void init() {
        try {
            Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            Display.setTitle(GAME_TITLE);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, DISPLAY_WIDTH, 0, DISPLAY_HEIGHT, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public static void update() {
        Display.update();
        Display.sync(60);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public static void exit() {
        Display.destroy();
    }

    public static boolean close() {
        return (Display.isCloseRequested());
    }

    public static void drawBox(double x, double y, double w, double h, double[] c) {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor3d(c[0], c[1], c[2]);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x + w, y);
        GL11.glVertex2d(x + w, y + h);
        GL11.glVertex2d(x, y + h);
        GL11.glEnd();
    }
}