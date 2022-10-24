package kg.attractor.homework50.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    private static final String postsDir = "src/main/resources/static/";

    public static String createFileFromMultipartFile(MultipartFile multipartFile) {
        byte[] data = getBytesFromMultipartFile(multipartFile);
        String name = String.format("posts_%s_%s.jpg");
        File file = new File(postsDir + name);
        try(FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }



    private static byte[] getBytesFromMultipartFile(MultipartFile multipartFile) {
        byte[] data = new byte[0];
        try {
            data = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}