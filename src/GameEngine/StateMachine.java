package GameEngine;

import GameStates.MenuStates.MainMenu;
import java.util.Stack;

/**
 * @author Jack Kurfman
 * @version 5/5/2016.
 */
public class StateMachine {

    private static Stack<State> stateStack = new Stack<>();

    public static void init() {
        stateStack.push(new MainMenu(new String[]{"New Game", "Load Game", "Options"}));
        stateStack.peek().init();
        stateStack.peek().onEnter();
    }

    public static void update() {
        stateStack.peek().update();
        stateStack.peek().render();
        stateStack.peek().handle();
        if (stateStack.peek().close() && (stateStack.size() > 1)) removeState();
    }

    public static void addState(State newState) {
        stateStack.push(newState);
        stateStack.peek().init();
        stateStack.peek().onEnter();
    }

    public static void removeState() {
        stateStack.pop().onExit();
        stateStack.peek().onEnter();
    }

    public static void exit() {
        while (!stateStack.isEmpty()) stateStack.pop().onExit();
    }
}
