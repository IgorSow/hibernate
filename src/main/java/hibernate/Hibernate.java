package hibernate;

import javax.persistence.*;


public class Hibernate {

    private EntityManagerFactory entityManagerFactory;

    public Hibernate() {

        this.entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    }
    public EntityManager getEntityManager(){


        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return  entityManager;
    }
    public void cloesFactory(){
        entityManagerFactory.close();
    }
}

