package OtherProjects.hust.soict.dsai.garbage;
import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        int count = 65536;
        byte[] inputBytes = new byte[count];
        r.nextBytes(inputBytes);

        // Đo thời gian dùng String cộng chuỗi (+)
        long start = System.currentTimeMillis();
        String s = "";
        for (byte b : inputBytes) {
            s += (char) b;
        }
        System.out.println("Processing time with String (+): " + (System.currentTimeMillis() - start) + " ms");

        // Đo thời gian dùng StringBuilder (Hiệu năng cao)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        s = sb.toString();
        System.out.println("Processing time with StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}