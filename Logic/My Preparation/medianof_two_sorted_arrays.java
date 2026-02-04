import java.util.ArrayList;

public class medianof_two_sorted_arrays {
    public static void main(String[] args) {

        int arr1[] = { 1, 3, 4, 8, 10 };
        int arr2[] = { 2, 5, 6, 7, 9 };

        ArrayList<Integer> tempArr = new ArrayList<>();

        for (int i : arr1) {
            tempArr.add(i);
        }

        for (int i = 0; i < arr2.length; i++) {

            boolean inserted = false;

            for (int j = 0; j < tempArr.size(); j++) {
                if (arr2[i] <= tempArr.get(j)) {
                    tempArr.add(j, arr2[i]);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                tempArr.add(arr2[i]);
            }
        }

        System.out.println(tempArr.get(tempArr.size() / 2));
    }
}
