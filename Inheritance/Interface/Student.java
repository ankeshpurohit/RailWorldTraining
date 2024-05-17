package Inheritance.Interface;

public class Student implements Trial, Comparable<Student> {

    private int s1Marks;
    private int s2Marks;
    private String s1Name;
    private String s2Name;

    public int getS2Marks() {
        return s2Marks;
    }

    public void setS2Marks(int s2Marks) {
        this.s2Marks = s2Marks;
    }

    public String getS2Name() {
        return s2Name;
    }

    public void setS2Name(String s2Name) {
        this.s2Name = s2Name;
    }

    public Student() {
    }

    public int getS1Marks() {
        return s1Marks;
    }

    public void setS1Marks(int s1Marks) {
        this.s1Marks = s1Marks;
    }

    public String getS1Name() {
        return s1Name;
    }

    public void setS1Name(String s1Name) {
        this.s1Name = s1Name;
    }

    public Student(int s1Marks, int s2Marks, String s1Name, String s2Name) {
        this.s1Marks = s1Marks;
        this.s2Marks = s2Marks;
        this.s1Name = s1Name;
        this.s2Name = s2Name;
    }

    @Override
    public void displayName() {
        System.out.println(s1Name);
        System.out.println(s2Name);
    }

    @Override
    public void displayNmae() {

    }

    @Override
    public void showMarks() {
        System.out.println(s1Marks);
        System.out.println(s2Marks);
    }

    @Override
    public int compareTo(Student st) {
        int a;
        if(s1Marks >st.s2Marks){
            a= 1;
        }
        else
            a=0;
        return a;
    }
}