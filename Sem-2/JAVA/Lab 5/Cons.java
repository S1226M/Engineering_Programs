public class Cons {
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(55, 12);
        System.out.println(t1.hr + " " + t1.min + " " + t2.hr + " " + t2.min);
        Time.addition(t1.hr, t2.hr, t1.min, t2.min);
        // t1.addition(t1.hr, t2.hr, t1.min, t2.min);
    }
}

class Time {
    int hr;
    int min;

    Time() {
        min = 12;
        hr = 12;
    }

    Time(int m, int h) {
        min = m;
        hr = h;
    }

    static void addition(int hour1, int hour2, int minute1, int minute2) {
        int th = hour1 + hour2;
        int tm = minute1 + minute2;
        if (tm > 59) {
            th++;
            tm = tm - 60;
        }
        System.out.println("the ans is" + th + ":" + tm);
    }
}
