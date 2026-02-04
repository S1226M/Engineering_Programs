import java.util.Arrays;

public class Second_Largest_Unique {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 6, 9, 4, 2, 65, 32, 9, 9 };

        int unique[] = Arrays.stream(arr).distinct().toArray();
        int sorted[] = Arrays.stream(unique).sorted().toArray();

        System.out.println(sorted[sorted.length - 2]);
    }
}
