package files.search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("temp");
        List<File> files = findWithFormat(file, "bin");
        files.forEach(System.out::println);
    }

    private static List<File> findWithFormat(File file, String format) {
        List<File> fileList = new ArrayList<>();
        return findFormat(file, format, fileList);
    }

    private static List<File> findFormat(File file, String format, List<File> fileList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        findFormat(f, format, fileList);
                    } else {
                        if (f.getName().endsWith("." + format)) {
                            fileList.add(f);
                        }
                    }
                }
            }
        }
        return fileList;
    }
}
