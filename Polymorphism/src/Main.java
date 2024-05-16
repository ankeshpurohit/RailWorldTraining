import model.Employee;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any length & width of rectangle : ");
        int l=sc.nextInt();
        int w= sc.nextInt();
        float a=emp.area(l,w);
        System.out.println("Area of Rectangle : "+a);

        System.out.println("Enter any radius of Circle : ");
        int r=sc.nextInt();
        float ar=emp.area(r);
        System.out.println("Area of Circle : "+ar);
    }
}