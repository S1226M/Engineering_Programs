import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Total_Number_Of_Pairs_BaseOnK {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 4, 4, 4 };
        int arr2[] = { 2, 2, 2, 4, 4, 5 };

        int uniqueArr1[] = Arrays.stream(arr1).distinct().toArray();
        int uniqueArr2[] = Arrays.stream(arr2).distinct().toArray();

        Map<Integer, Integer> arr1Map = new HashMap<>();
        Map<Integer, Integer> arr2Map = new HashMap<>();

        for (int i : uniqueArr1) {
            int count = 0;
            for (int num : arr1) {
                if (num == i) {
                    count++;
                }
            }
            arr1Map.put(i,count);
        }
        for(int i : uniqueArr2){
            int count = 0;
            for(int num : arr2){
                if(num == i){
                    count++;
                }
            }
        }

        int comunKey = communKey(arr1Map.keySet(),arr2Map.keySet()); 

        for(int i : arr1Map.keySet()){
            for(int j : arr2Map.keySet()){
                if(i == j){
                }
            }
        }
    }
}
