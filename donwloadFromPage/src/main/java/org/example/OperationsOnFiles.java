package org.example;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OperationsOnFiles {
    static final String PATH_TO_LINKS = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\links\\";
    private static void writeToFile(String fileName, String link) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(link);
            writer.close();
        } catch (FileNotFoundException e) {
            Files.createDirectories(Paths.get(PATH_TO_LINKS));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(link);
            writer.close();
        }
    }

    static void saveFiles(List<String> linksList) throws IOException {
        int i = 1;
        for (String link : linksList) {
            writeToFile(PATH_TO_LINKS + i + ".url", "[InternetShortcut]\nURL=" + link);
            i++;
        }
    }

    static void deleteFiles(){
        Arrays.stream(Objects.requireNonNull(new File(PATH_TO_LINKS).listFiles())).forEach(File::delete);
    }
}
