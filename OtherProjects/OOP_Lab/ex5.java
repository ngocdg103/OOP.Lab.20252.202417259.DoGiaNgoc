import java.util.Scanner; 

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        // Nhập 2 số
        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();

        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine(); 

        // Chuyển string sang dạng số 
        double a = Double.parseDouble(strNum1); 
        double b = Double.parseDouble(strNum2);

        // Tổng
        double sum = a + b; 
        System.out.println("Sum = " + sum);

        // Hiệu
        double diff = a - b; 
        System.out.println("Difference = " + diff);

        // Tích
        double product = a * b; 
        System.out.println("Product = " + product);

        // Thương
        // Kiểm tra xem số chia có khác 0 không
        if (b == 0) {
            System.out.println("Quotient: The second number is 0. The division is not allowed!");
        }
        else {
            System.out.println("Quotient = " + (a / b));
        }
        scanner.close();
    }
    
}
