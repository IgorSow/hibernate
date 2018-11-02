package hibernate.movie;

import hibernate.student.StudentHb;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class MovieHb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDMOVIE;
    @Column
    private String TITLE;
    @Column
    private double DURATION;

    @ManyToMany(mappedBy = "movieHbSet", cascade = {CascadeType.MERGE})
    private Set<StudentHb> studentHbSet = new HashSet<>();

    public MovieHb() {
    }

    public int getIDMOVIE() {
        return IDMOVIE;
    }

    public void setIDMOVIE(int IDMOVIE) {
        this.IDMOVIE = IDMOVIE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public double getDURATION() {
        return DURATION;
    }

    public void setDURATION(double DURATION) {
        this.DURATION = DURATION;
    }

    public Set<StudentHb> getStudentHbSet() {
        return studentHbSet;
    }

    public void setStudentHbSet(Set<StudentHb> studentHbSet) {
        this.studentHbSet = studentHbSet;
    }
}
