package xyz.becvold.emily.utils.helpers;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Lukáš Bečvář on 09.12.22
 * @project Emily
 */
public class FileHelper {

    // function for check if path exist
    public boolean checkIfPathExist(String filePath) {
        File path = new File(filePath);

        return path.exists();
    }

    // function for create directory
    public void createDirectory(String directoryPath) {
        try {
            Files.createDirectory(Path.of(directoryPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // function for create file
    public void createFile(String filePath) {
        try {
            Files.createFile(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // delete all files from directory
    public void purgeDirectory(String path) {

        try {
            Files.newDirectoryStream(Path.of(path)).forEach(file -> {
                try {
                    Files.delete(file);
                }
                catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // delete file by name
    public void deleteFile(String fileName) {

        File f = new File(fileName);

        if (f.exists()) {
            f.delete();
        }
    }
}
