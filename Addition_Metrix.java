import java.util.Scanner;

public class Addition_Metrix {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,m;
        System.out.println("Enter any size of 1st Array : ");
        n=sc.nextInt();
        m=sc.nextInt();
        int arr1 [][] =new int[n][m];
        System.out.println("Enter element of 1st Array : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j]=sc.nextInt();
            }
        }

        int arr2 [][] =new int[n][m];
        System.out.println("Enter element of 2nd Array : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j]=sc.nextInt();
            }
        }

        System.out.println("After Addition : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j]+=arr2[i][j];
            }
                }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(arr1[j][k]+" ");
            }
            System.out.println();
        }
    }
}
