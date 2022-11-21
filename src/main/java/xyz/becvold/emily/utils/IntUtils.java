package xyz.becvold.emily.utils;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class IntUtils {

    public int randomInt(int max, int min) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
