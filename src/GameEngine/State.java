package GameEngine;

/**
 * @author Jack Kurfman
 * @version 5/5/2016.
 */
public interface State {

    /***METHOD TO PREFORM ANY COMPUTING PRIOR TO ENTERING***/
    void init();

    /***METHOD TO PREFORM ANY COMPUTING UPON ENTERING***/
    void onEnter();

    /***METHOD TO UPDATE ANY STATE LOGIC***/
    void update();

    /***METHOD TO SHOW STATE ON DISPLAY***/
    void render();

    /***METHOD TO HANDLE INPUT EVENTS***/
    void handle();

    /***METHOD TO DETERMINE CLOSE CONDITIONS***/
    boolean close();

    /***METHOD TO PREFORM ANY COMPUTING UPON EXITING***/
    void onExit();

}
