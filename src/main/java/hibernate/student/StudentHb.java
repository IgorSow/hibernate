package hibernate.student;

import hibernate.mark.MarksHb;
import hibernate.movie.MovieHb;
import hibernate.subject.SubjectHb;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "student")
public class StudentHb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int ID;

    @Column()
    private String NAME;
    @Column
    private String LASTNAME;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "movie_student",
            joinColumns = {@JoinColumn(name = "IDSTUDENT")},
            inverseJoinColumns = {@JoinColumn(name ="IDMOVIE")})
    private Set<MovieHb> movieHbSet = new HashSet<>();



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDSTUDENT")
    private Collection<MarksHb> marksHbList = new ArrayList<>();



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    @JoinTable(name = "subject_student",
            joinColumns = {@JoinColumn(name = "IDSTUDENT")},
            inverseJoinColumns = {@JoinColumn(name = "IDSUBJECT")})

    private List<SubjectHb> subjectHbList = new ArrayList<>();

    public StudentHb() {
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

    public Collection<MarksHb> getMarksHbList() {
        return marksHbList;
    }

    public void setMarksHbList(Collection<MarksHb> marksHbList) {
        this.marksHbList = marksHbList;
    }

    public List<SubjectHb> getSubjectHbList() {
        return subjectHbList;
    }

    public void setSubjectHbList(List<SubjectHb> subjectHbList) {
        this.subjectHbList = subjectHbList;
    }

    public Set<MovieHb> getMovieHbSet() {
        return movieHbSet;
    }

    public void setMovieHbSet(Set<MovieHb> movieHbSet) {
        this.movieHbSet = movieHbSet;
    }

    @Override
    public String toString() {
        return "StudentHb{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", LASTNAME='" + LASTNAME + '\'' +
                ", marksHbList=" + marksHbList +
                '}';
    }
}
