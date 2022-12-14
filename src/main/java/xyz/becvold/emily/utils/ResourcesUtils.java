package xyz.becvold.emily.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Lukáš Bečvář on 14.12.22
 * @project Emily
 */
public class ResourcesUtils {

    public void copyResource(InputStream source , String destination) {

        try {
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
