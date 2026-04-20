package OtherProjects.hust.soict.dsai.lab01.OOP_Lab;
import java.util.Scanner;

public class DayDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = -1, month = -1; 
        while (true) {
            System.out.print("Enter a month: ");
            String mInput = scanner.nextLine();  

            System.out.print("Enter a year: ");
            String yearInput = scanner.nextLine(); 
            
            // Kiểm tra tháng
            try {
                month = Integer.parseInt(mInput); 

                if (month < 1 || month > 12) {
                    month = -1; 
                }
            }

            catch (NumberFormatException e) {
                if (mInput.equals("January") || mInput.equals("Jan.") || mInput.equals("Jan")) month = 1;
                else if (mInput.equals("February") || mInput.equals("Feb.") || mInput.equals("Feb")) month = 2;
                else if (mInput.equals("March") || mInput.equals("Mar.") || mInput.equals("Mar")) month = 3;
                else if (mInput.equals("April") || mInput.equals("Apr.") || mInput.equals("Apr")) month = 4;
                else if (mInput.equals("May")) month = 5;
                else if (mInput.equals("June") || mInput.equals("Jun.") || mInput.equals("Jun")) month = 6;
                else if (mInput.equals("July") || mInput.equals("Jul.") || mInput.equals("Jul")) month = 7;
                else if (mInput.equals("August") || mInput.equals("Aug.") || mInput.equals("Aug")) month = 8;
                else if (mInput.equals("September") || mInput.equals("Sept.") || mInput.equals("Sep")) month = 9;
                else if (mInput.equals("October") || mInput.equals("Oct.") || mInput.equals("Oct")) month = 10;
                else if (mInput.equals("November") || mInput.equals("Nov.") || mInput.equals("Nov")) month = 11;
                else if (mInput.equals("December") || mInput.equals("Dec.") || mInput.equals("Dec")) month = 12;
                else month = -1; 
            }

            // Kiểm tra năm
            try {
                year = Integer.parseInt(yearInput); 
                if (year < 0 || yearInput.length() != 4) year = -1; 
            } catch(NumberFormatException e) {
                year = -1; 
            }

            if (month != -1 && year != -1) {
                break;
            } 
            else if (month == -1 && year == -1) {
                System.out.println("Invalid month and year! Please enter again!");
            }
            else if (month == -1) {
                System.out.println("Invalid month! Please enter again!");
            } else if (year == -1) {
                System.out.println("Invalid year! Please enter again!");
            }
        }
        int days = 0; 
        switch(month) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) days = 29;
                else days = 28;
            }
        }

        System.out.println("There are " + days + " days in month " + month + "/" + year);


        scanner.close();
    }
}
