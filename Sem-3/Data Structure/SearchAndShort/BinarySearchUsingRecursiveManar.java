class BinarySearch {
    int binarySearchUsingRecurunce(int[] arr, int left, int right, int x) {
        int middle;
        if (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] == x) {
                return middle;
            } else if (arr[middle] < x) {
                return binarySearchUsingRecurunce(arr, middle + 1, right, x);
            } else {
                return binarySearchUsingRecurunce(arr, left, middle - 1, x);
            }
        }
        return -1;
    }
}

public class BinarySearchUsingRecursiveManar {
    public static void main(String[] args) {
        BinarySearch s = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5};
        int x = 3;
        int result = s.binarySearchUsingRecurunce(arr, 0, arr.length - 1, x);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
