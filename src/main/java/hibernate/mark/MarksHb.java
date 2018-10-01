package hibernate.mark;


import hibernate.student.StudentHb;

import javax.persistence.*;


@Entity
@Table(name = "marks")
public class MarksHb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int ID;

    @Column
    private double MARK;

    @ManyToOne
    @JoinColumn(name = "IDSTUDENT")
    private StudentHb IDSTUDENT;


    public MarksHb() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getMARK() {
        return MARK;
    }

    public void setMARK(double MARK) {
        this.MARK = MARK;
    }

    public StudentHb getIDSTUDENT() {
        return IDSTUDENT;
    }

    public void setIDSTUDENT(StudentHb studentHb) {
        this.IDSTUDENT = studentHb;
    }

    @Override
    public String toString() {
        return "MarksHb{" +
                "ID=" + ID +
                ", MARK=" + MARK +
                ", IDSTUDENT=" + IDSTUDENT +
                '}';
    }
}
