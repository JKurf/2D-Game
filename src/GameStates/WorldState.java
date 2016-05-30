package GameStates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public abstract class WorldState {

    public WorldState(String filepath) {
        try {
            Scanner file = new Scanner(new File(filepath));
            String line;
            do {
                line = file.nextLine();
            } while (!line.equals("<world>"));
            System.out.println(line);
            while (file.hasNext()) {
                line = file.nextLine();
                System.out.println(line);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
