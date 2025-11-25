package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileController xử lý đọc/ghi file
 */
public class FileController {

    /**
     * Ghi danh sách đối tượng vào file
     */
    public static <T> void writeToFile(String filename, List<T> list) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
        }
    }

    /**
     * Đọc danh sách đối tượng từ file
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> readFromFile(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        }
    }

    /**
     * Kiểm tra file có tồn tại không
     */
    public static boolean fileExists(String filename) {
        return new File(filename).exists();
    }

    /**
     * Xóa file
     */
    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        return file.delete();
    }
}
