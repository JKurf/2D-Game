package GameStates.MenuStates;

import GameEngine.Graphics;
import GameEngine.Input;
import GameEngine.State;
import GameEngine.StateMachine;
import GameStates.MenuState;
import org.lwjgl.input.Keyboard;

import java.util.Random;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public class MainMenu extends MenuState implements State {

    public static int counter = 0;
    public int num;

    public MainMenu(String[] options) {
        super(options);
        this.num = counter++;
    }

    @Override
    public void init() {
        System.out.println("Initializing...");
    }

    @Override
    public void onEnter() {
        System.out.println("Menu #" + num);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Random r = new Random(System.nanoTime());
        Graphics.drawBox(100.0, 100.0, 100.0, 100.0, new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
        Graphics.drawBox(300.0, 400.0, 100.0, 100.0, new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
    }

    @Override
    public void handle() {
        if (Input.keyPressed(Keyboard.KEY_0)) {
            StateMachine.addState(new MainMenu(new String[]{"New Menu", "New Menu"}));
        }
    }

    @Override
    public boolean close() {
        return Input.keyPressed(Keyboard.KEY_BACK);
    }

    @Override
    public void onExit() {

    }
}
