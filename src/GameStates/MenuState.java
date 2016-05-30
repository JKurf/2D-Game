package GameStates;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public abstract class MenuState {

    private String[] options;

    public MenuState(String[] options) {
        this.options = options;
    }

    public boolean equals(MenuState menuState) {
        return (menuState == this);
    }
}
