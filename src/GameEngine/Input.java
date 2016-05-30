package GameEngine;

import org.lwjgl.input.Keyboard;
import java.util.Arrays;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public class Input {

    private static final int keyCount = Keyboard.getKeyCount();

    private static boolean[] key = new boolean[keyCount];
    private static boolean[] pressed = new boolean[keyCount];
    private static boolean[] held = new boolean[keyCount];
    private static int[] cooldown = new int[keyCount];
    private static int cooldownMax = 250; //Milliseconds
    private static int elapsedTime;
    private static int lastTime;

    public static void init() {
        Arrays.fill(key, Boolean.FALSE);
        Arrays.fill(pressed, Boolean.FALSE);
        Arrays.fill(held, Boolean.FALSE);
        Arrays.fill(cooldown, 0);
        lastTime = (int) System.currentTimeMillis();
    }

    public static void update() {
        elapsedTime = (int) System.currentTimeMillis() - lastTime;
        lastTime = (int) System.currentTimeMillis();
        for (int i = 0; i < keyCount; i++) {
            if (cooldown[i] != 0) {
                cooldown[i] -= elapsedTime;
                if (cooldown[i] < 0) cooldown[i] = 0;
            }
            pressed[i] = false;
            if (Keyboard.isKeyDown(i) != key[i]) {
                if (key[i]) {
                    if (cooldown[i] == 0) {
                        held[i] = false;
                    } else {
                        pressed[i] = true;
                    }
                } else {
                    if (cooldown[i] == 0) cooldown[i] = cooldownMax;
                }
            } else {
                if (key[i] && (cooldown[i] == 0)) held[i] = true;
            }
            key[i] = Keyboard.isKeyDown(i);
        }
    }

    public static boolean keyHeld(int key) {
        return held[key];
    }

    public static boolean keyPressed(int key) {
        return pressed[key];
    }

    public static boolean close() {
        return keyHeld(Keyboard.KEY_ESCAPE);
    }
}
