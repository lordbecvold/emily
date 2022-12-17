package xyz.becvold.emily.utils.helpers;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class IntegerHelper {

    // generate random number [int input: minimal int & maximal int]
    public int randomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
