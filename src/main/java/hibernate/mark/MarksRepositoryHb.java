package hibernate.mark;


import hibernate.AbstractRepositoryHb;
import hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class MarksRepositoryHb extends AbstractRepositoryHb<MarksHb> {

    private Hibernate hibernate;

    public MarksRepositoryHb(Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public MarksHb get(int id) {

        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            MarksHb marksHb = entityManager.find(MarksHb.class, id);

            entityManager.close();
            return marksHb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<MarksHb> getAll() {
        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            List resultList = entityManager.createQuery("FROM MarksHb").getResultList();

            return resultList;
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
            MarksHb marksHbToRemove = entityManager.find(MarksHb.class, id);

            entityManager.remove(marksHbToRemove);
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
    public boolean insert(MarksHb insertData) {
        EntityManager entityManager = this.hibernate.getEntityManager();

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
    public boolean update(MarksHb updateData) {

        EntityManager entityManager = this.hibernate.getEntityManager();

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
}
