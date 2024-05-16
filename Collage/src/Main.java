package Collage.src;

import Collage.src.model.Student;
import Collage.src.model.Subject;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student();
//        Subject subject = new Subject();

        System.out.print("Enter Student Name : ");
        student.setName(sc.nextLine());
        student.setId(547);
        student.setSubject(new Subject(78,69,89));

        System.out.println(student.toString());
    }
}