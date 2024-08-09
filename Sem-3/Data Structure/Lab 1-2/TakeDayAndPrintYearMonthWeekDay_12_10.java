import java.util.Scanner;

public class TakeDayAndPrintYearMonthWeekDay_12_10 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float inputDay = sc.nextInt();
            double year1 = (inputDay/365);
            int year = (int)year1;
            double year2 = year1 - year;

            double month1 = year2 * 12;
            int month = (int)month1;
            double month2 = month1 - month;

            double week1 = month2 * 4;
            int week = (int)week1;
            double week2 = week1 - week;

            double day1 = week2 * 7;
            int day = (int)day1;
            System.out.println("Year:"+year+", Month:"+month+", Week:"+week+", Day"+day);
        }
    }
}
