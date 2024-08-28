package jsonfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JsonFileReader {
    public static String readJsonFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        byte[] data = new byte[(int) new File(path).length()];
        fileInputStream.read(data);
        fileInputStream.close();
        return new String(data);
    }
}
