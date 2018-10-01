package hibernate.subject;

import hibernate.mark.MarksHb;
import hibernate.student.StudentHb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "subject")
public class SubjectHb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column
    private String NAME;

    //todo @ManyToMany(fetch = FetchType.LAZY,mappedBy = "subjectHbList")
    @ManyToMany(mappedBy = "subjectHbList")
    private List<StudentHb> studentHbList = new ArrayList<>();

    public SubjectHb() {
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

    @Override
    public String toString() {
        return "SubjectHb{" +
                "ID=" + ID +
                ", NAME='" + NAME ;

    }
}
