package hibernate.subject;

import hibernate.AbstractRepositoryHb;
import hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SubjectRepositoryHb extends AbstractRepositoryHb<SubjectHb> {

    private Hibernate hibernate;

    public SubjectRepositoryHb(Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public SubjectHb get(int id) {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {

            SubjectHb subjectHb = (SubjectHb) entityManager.createQuery("FROM SubjectHb WHERE ID = :findId")
                    .setParameter("findId", id)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            return subjectHb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<SubjectHb> getAll() {
        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            List resultList = entityManager.createQuery("FROM SubjectHb").getResultList();
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
            entityManager.createQuery("DELETE SubjectHb WHERE ID =:idSubjectToRemove")
                    .setParameter("idSubjectToRemove", id)
                    .executeUpdate();
            entityManager.close();
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }


//    public boolean insert2(SubjectHb insertData) {
//        EntityManager entityManager = this.hibernate.getEntityManager();
//        int id = insertData.getID();
//        String name = insertData.getNAME();
//
//        entityManager.createQuery("INSERT INTO SubjectHb(ID , NAME) values (id,name")
//
//                .setParameter("id", id)
//                .setParameter("name", name)
//                .executeUpdate();
//
//        entityManager.getTransaction().commit();
//        return true;
//    }

    @Override
    public boolean insert(SubjectHb subjectHb) {
        EntityManager entityManager = this.hibernate.getEntityManager();
        try {
            entityManager.persist(subjectHb);
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
    public boolean update(SubjectHb updateData) {

        EntityManager entityManager = this.hibernate.getEntityManager();

        try {
            String name = updateData.getNAME();
            int id = updateData.getID();

            Query query = entityManager.createQuery("UPDATE SubjectHb SET NAME=:nameToUpdate WHERE ID=:idToUpdate")
                    .setParameter("nameToUpdate", name)
                    .setParameter("idToUpdate", id);
            int i = query.executeUpdate();
            System.out.println(i);
            entityManager.getTransaction().commit();
            System.out.println("UPDATE !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

}
