package jdbc;

import java.util.List;

public class Student {

    private int ID;
    private String NAME;
    private String LASTNAME;
    private List<Double> MARKS;

    public Student(int ID, String NAME, String LASTNAME, List<Double> MARKS) {
        this.ID = ID;
        this.NAME = NAME;
        this.LASTNAME = LASTNAME;
        this.MARKS = MARKS;
    }

    public Student(int ID, String NAME, String LASTNAME) {
        this.ID = ID;
        this.NAME = NAME;
        this.LASTNAME = LASTNAME;
    }

    public Student(String NAME, String LASTNAME) {
        this.NAME = NAME;
        this.LASTNAME = LASTNAME;
    }

    public List<Double> getMARKS() {
        return MARKS;
    }

    public void setMARKS(List<Double> MARKS) {
        this.MARKS = MARKS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", LASTNAME='" + LASTNAME + '\'' +
                '}';
    }
}
