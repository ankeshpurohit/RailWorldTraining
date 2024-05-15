package ElectritiBill.src;
import java.util.Scanner;

public class highest {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any Array Length : ");

        int n=sc.nextInt();

        System.out.println("Enter "+n+ " Array Value : ");

        int[] arr =new int[n]; //declaring an array
        for (int col=0;col<arr.length;col++) // initializing
        {
            arr[col]=sc.nextInt();
        }

        //[4,7,10,30,15]
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1] ) {
                System.out.println(arr[i]);

            }}}}