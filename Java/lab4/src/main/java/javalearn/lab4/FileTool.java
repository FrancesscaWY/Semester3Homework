package javalearn.lab4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileTool {
    public static String read(String path) throws IOException {
        Path path1 = Paths.get(path);
        List<String> content = Files.readAllLines(path1);
        System.out.println(content.toString());
        return content.toString();
    }
    public static void save(String path,String content) throws IOException {
        Path path2 = Paths.get(path);
        byte[] text = content.getBytes();
        Files.write(path2,text);
    }
}
