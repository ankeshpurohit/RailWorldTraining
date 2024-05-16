package Collage.src.model;

public class Subject {

    private float Pmarks;
    private float Cmarks;
    private float Mmarks;

    public Subject(float pmarks, float cmarks, float mmarks) {
        Pmarks = pmarks;
        Cmarks = cmarks;
        Mmarks = mmarks;
    }

    public Subject() {
    }

    public float getPmarks() {
        return Pmarks;
    }

    public void setPmarks(float pmarks) {
        Pmarks = pmarks;
    }

    public float getCmarks() {
        return Cmarks;
    }

    public void setCmarks(float cmarks) {
        Cmarks = cmarks;
    }

    public float getMmarks() {
        return Mmarks;
    }

    public void setMmarks(float mmarks) {
        Mmarks = mmarks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "Pmarks=" + Pmarks +
                ", Cmarks=" + Cmarks +
                ", Mmarks=" + Mmarks +
                '}';
    }
}


