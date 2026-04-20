package OtherProjects.hust.soict.dsai.garbage;
import java.util.Random;
public class GarbageTest {
    public static void main(String[] args) {
        Random r = new Random(123);
        int count = 65536; // Số lượng chuỗi cần nối
        byte[] inputBytes = new byte[count];
        r.nextBytes(inputBytes);

        // 1. Kiểm tra với String và toán tử +
        long start = System.currentTimeMillis();
        String s = "";
        for (byte b : inputBytes) {
            s += (char) b;
        }
        System.out.println("Time with String (+): " + (System.currentTimeMillis() - start) + "ms");

        // 2. Kiểm tra với StringBuilder (Nhanh nhất)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        s = sb.toString();
        System.out.println("Time with StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
        
        // 3. Kiểm tra với StringBuffer (An toàn đa luồng nhưng chậm hơn StringBuilder một chút)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (byte b : inputBytes) {
            sbf.append((char) b);
        }
        s = sbf.toString();
        System.out.println("Time with StringBuffer: " + (System.currentTimeMillis() - start) + "ms");
    }
}
