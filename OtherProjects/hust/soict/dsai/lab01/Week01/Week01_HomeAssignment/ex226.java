package OtherProjects.hust.soict.dsai.lab01.Week01.Week01_HomeAssignment;
import java.util.Scanner; 
public class ex226 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Giải phương trình ax^2 + bx + c = 0");
        System.out.print("Nhập a: "); double a = scanner.nextDouble();
        System.out.print("Nhập b: "); double b = scanner.nextDouble();
        System.out.print("Nhập c: "); double c = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println(c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
            } else {
                System.out.println("Nghiệm x = " + (-c / b));
            }
        }
        else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                System.out.println("Nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                System.out.println("Phương trình vô nghiệm thực.");
            }
        
        }
        scanner.close();
    }
}
