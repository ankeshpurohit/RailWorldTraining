package ElectritiBill.src;

import java.util.Scanner;

public class ArrayNested {

    public static void main(String args[]){

        int n,m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any size of Aeeay : ");
        n=sc.nextInt();
        m=sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter the elements of array : ");
        for (int i=0; i<n; i++){
            for (int j = 0; j <m; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]==arr[j][i] || i+j == n-1) {
                    System.out.print(arr[i][j]+" ");
                }
                else
                    {
                        System.out.print(" ");
                    }
            }
            System.out.println();
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <m; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//
//        }
    }
}
