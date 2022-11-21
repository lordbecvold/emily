package xyz.becvold.emily.utils;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class SystemUtils {

    // shutdown app with exit code
    public void appShutdown(int code) {
        System.exit(code);
    }

    // get os name
    public String getOS() {
        return System.getProperty("os.name");
    }
}
