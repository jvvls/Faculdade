import java.util.Scanner;

public class Main {

    public static int binarySearch(int[] list, int target) {
        int start = 0;
        int end = list.length - 1;
        int tries = 0;

        while (start <= end) {
            tries++;
            int mid = (start + end) / 2;
            int guess = list[mid];

            if (guess == target) {
                System.out.println("Found at index " + mid + " in " + tries + " tries");
                return mid;
            } 
            else if (guess > target) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        System.out.println("Not found after " + tries + " tries");
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9};

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        binarySearch(list, target);
        scanner.close();
    }
}
