package GameStates.WorldStates;

import GameEngine.State;
import GameStates.WorldState;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public class TestWorld extends WorldState implements State {

    private static final String FILEPATH = "World/Test World.world";

    public TestWorld() {
        super(FILEPATH);
    }

    @Override
    public void init() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void handle() {

    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public void onExit() {

    }
}
