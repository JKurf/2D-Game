import GameEngine.Game;

/**
 * @author Jack Kurfman
 * @version 5/5/2016.
 */
public class GameClient {

    public static void main(String[] args) {
        Game.init();
        while (!Game.done) {
            Game.update();
        }
        Game.exit();
    }

}
