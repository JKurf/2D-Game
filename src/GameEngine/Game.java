package GameEngine;

/**
 * @author Jack Kurfman
 * @version 5/5/2016.
 */
public class Game {

    public static boolean done = false;

    public static void init() {
        Graphics.init();
        Input.init();
        StateMachine.init();
    }

    public static void update() {
        Graphics.update();
        Input.update();
        StateMachine.update();
        done = Graphics.close() || Input.close();
    }

    public static void exit() {
        StateMachine.exit();
        Graphics.exit();
    }
}
