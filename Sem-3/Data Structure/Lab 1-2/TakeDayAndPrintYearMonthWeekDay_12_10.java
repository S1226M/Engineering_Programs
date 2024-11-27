import java.util.Scanner;

public class TakeDayAndPrintYearMonthWeekDay_12_10 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float inputDay = sc.nextInt();//397
            double year1 = (inputDay/365);//1.087.....
            int year = (int)year1;//1
            double year2 = year1 - year;//0.87...

            double month1 = year2 * 12;//1.052054....
            int month = (int)month1;//1
            double month2 = month1 - month;//0.052054....

            double week1 = month2 * 4;//0.20821...
            int week = (int)week1;//0
            double week2 = week1 - week;//0.2021...

            double day1 = week2 * 7;//1.457...
            int day = (int)day1;//1
            System.out.println("Year:"+year+", Month:"+month+", Week:"+week+", Day"+day);
        }
    }
}
