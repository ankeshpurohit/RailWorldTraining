package ElectritiBill.src;

import java.util.Scanner;

public class Electricity {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Units :");
        int ut = sc.nextInt();
        double ans;
        ans=(ut<=100) ? ut*2 :
                (ut<=150) ? (100*2)+(ut-100)*3 :
                        (ut<=200) ? (100*2)+(50*3)+(ut-150)*4 :
                                (ut<=250) ? (100*2)+(50*3)+(50*4)+(ut-200)*5:
                                        (ut<=300) ? (100*2)+(50*3)+(50*4)+(50*5)+(ut-250)*6:
                                                (ut<=500) ? (100*2)+(50*3)+(50*4)+(50*5)+(50*6)+(ut-300)*7:
                                                        (100*2)+(50*3)+(50*4)+(50*5)+(50*6)+(50*7)+(ut-500)*8;

        System.out.println(ans);
    }
}
