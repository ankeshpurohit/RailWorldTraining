package Array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAndMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size");
        int size=scanner.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter "+size+ " elements");
        for (int i = 0; i < size; i++) {
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
    }

    }
}
