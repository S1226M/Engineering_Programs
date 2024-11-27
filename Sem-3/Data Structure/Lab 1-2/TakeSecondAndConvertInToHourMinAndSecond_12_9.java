import java.util.Scanner;

public class TakeSecondAndConvertInToHourMinAndSecond_12_9 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float inputInSecond = sc.nextInt();//10000
            double hour1 = (inputInSecond/3600);//2.7777777..
            int hour = (int)hour1;//2
            double hour2 = hour1 - hour;//0.777777...

            double min1 = hour2*60;//46.6666...
            int min = (int)min1;//46
            double min2 = min1 - min;//0.66666..
            
            double second1 = min2 * 60;//39.9999
            int second = (int)(second1);
            System.out.println("Hour :"+hour+",Minutes:"+min+",Second:"+second);
        }
    }
}