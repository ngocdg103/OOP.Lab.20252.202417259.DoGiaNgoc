package OtherProjects.hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Ngọc hãy tìm 1 file bất kỳ trong máy, nặng tầm vài MB
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Processing time (String +): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error: Could not find or read file " + filename);
        }
    }
}