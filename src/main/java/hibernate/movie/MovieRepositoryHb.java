package hibernate.movie;

import hibernate.AbstractRepositoryHb;
import hibernate.Hibernate;
import hibernate.student.StudentHb;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepositoryHb extends AbstractRepositoryHb<MovieHb> {

    private Hibernate hibernate;

    public MovieRepositoryHb(Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public MovieHb get(int id) {
        EntityManager entityManager = hibernate.getEntityManager();


        try {
            MovieHb movieHb = entityManager.find(MovieHb.class, id);
            entityManager.getTransaction().commit();
            return movieHb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }


    }

    @Override
    public List<MovieHb> getAll() {
        EntityManager entityManager = hibernate.getEntityManager();

        try {
            List<MovieHb> movieHbList = entityManager.createQuery("FROM movie")
                    .getResultList();

            entityManager.getTransaction().commit();
            return movieHbList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(int id) {
        EntityManager entityManager = hibernate.getEntityManager();

        try {
//            MovieHb movieHb = entityManager.find(MovieHb.class, id);
//            movieHb.getStudentHbSet().clear();
//
//            entityManager.remove(movieHb);
            entityManager.createQuery("DELETE MovieHb WHERE IDMOVIE =:idSubjectToRemove")
                    .setParameter("idSubjectToRemove", id)
                    .executeUpdate();

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
    public boolean insert(MovieHb insertData) {
        EntityManager entityManager = hibernate.getEntityManager();

        try {
            entityManager.persist(insertData);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(MovieHb updateData) {
        EntityManager entityManager = hibernate.getEntityManager();

        try {
            entityManager.merge(updateData);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean removeStudentfromMovie(int idStudent, int idMovie){
        EntityManager entityManager = hibernate.getEntityManager();

        StudentHb studentHb = entityManager.find(StudentHb.class, idStudent);
        MovieHb movieHb = entityManager.find(MovieHb.class, idMovie);

        System.out.println(studentHb.getNAME());
        System.out.println(movieHb.getTITLE());

        movieHb.getStudentHbSet().remove(studentHb);

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }
    public void showRelation(int idMovie){
        EntityManager entityManager = hibernate.getEntityManager();


        MovieHb movieHb = entityManager.find(MovieHb.class, idMovie);

        System.out.println(movieHb.getStudentHbSet().toString());

    }
}
