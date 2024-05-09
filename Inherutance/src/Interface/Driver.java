package Interface;


import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String pawan;
        String kumar;
        System.out.println("Enter first Name : ");
        pawan=sc.nextLine();
        System.out.println("Enter Second Name : ");
        kumar=sc.nextLine();
        System.out.println("Enter marks of "+pawan);
        int x=sc.nextInt();
        System.out.println("Enter marks of "+kumar);
        int y=sc.nextInt();

        System.out.println("This is Marks and Name : ");
        Student student=new Student(x,y,pawan,kumar);

        student.showMarks();
        student.displayName();
        //student.showMarks();
        int a= student.compareTo(student);
        if (a == 1) {
            System.out.println("Highest marks of "+pawan);
        }
        else
            System.out.println("Highest marks of "+kumar);
    }



}