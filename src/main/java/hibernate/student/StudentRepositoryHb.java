package hibernate.student;

import hibernate.AbstractRepositoryHb;
import hibernate.Hibernate;
import hibernate.mark.MarksHb;
import hibernate.movie.MovieHb;
import hibernate.subject.SubjectHb;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class StudentRepositoryHb extends AbstractRepositoryHb<StudentHb> {


    private Hibernate hibernate;

    public StudentRepositoryHb(Hibernate hibernate) {
        this.hibernate = hibernate;
    }


    @Override
    public StudentHb get(int findId) {
        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            StudentHb studentHb = (StudentHb) entityManager.createQuery("FROM StudentHb WHERE ID = :findId")
                    .setParameter("findId", findId)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();
            return studentHb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List getAll() {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {
            List<StudentHb> studentHbList = entityManager.createQuery("FROM StudentHb")
                    .getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return studentHbList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(int id) {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {
            StudentHb studentHb = entityManager.find(StudentHb.class, id);


            entityManager.remove(studentHb);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public boolean insert(StudentHb insertData) {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {
            entityManager.persist(insertData);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(StudentHb updateData) {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {
            entityManager.remove(updateData);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public Collection<MarksHb> showStudentMarks(StudentHb studentHb) {

        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            int studentHbID = studentHb.getID();
            StudentHb studentHb1 = entityManager.find(StudentHb.class, studentHbID);

            return studentHb1.getMarksHbList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public boolean addStudentToSubject(StudentHb studentHb, SubjectHb subjectHb) {
        EntityManager entityManager = this.hibernate.getEntityManager();

        try {

            StudentHb studentHb1 = entityManager.find(StudentHb.class, studentHb.getID());
            SubjectHb subjectHb1 = entityManager.find(SubjectHb.class, subjectHb.getID());

            List<SubjectHb> oldListFromStudent = studentHb1.getSubjectHbList();

            oldListFromStudent.add(subjectHb1);

//            entityManager.merge(studentHb1); <---- to juz w sumie nie potrzebne, gdyz działamy na obiekcie z bazy danych

            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean addStudentToMovie(int idStudent, int idMovie) {

        EntityManager entityManager = hibernate.getEntityManager();

        try {
            StudentHb studentHb1 = entityManager.find(StudentHb.class, idStudent);
            MovieHb movieHb1 = entityManager.find(MovieHb.class, idMovie);

            Set<MovieHb> studentHb1MovieHbSet = studentHb1.getMovieHbSet();
            studentHb1MovieHbSet.add(movieHb1);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }

    }

    public boolean removeStudentFromMOvie(int idStudent, int idMovie) {
        EntityManager entityManager = hibernate.getEntityManager();

        StudentHb studentHb = entityManager.find(StudentHb.class, idStudent);
        MovieHb movieHb = entityManager.find(MovieHb.class, idMovie);


        studentHb.getMovieHbSet().remove(movieHb);
        entityManager.getTransaction().commit();
        return true;

    }


}
