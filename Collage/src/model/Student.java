package Collage.src.model;

public class Student {

    private String name;
    private int id;
    private Subject subject;

    public Student() {
    }

    public Student(String name, int id, Subject subject) {
        this.name = name;
        this.id = id;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject=" + subject +
                '}';
    }
}
