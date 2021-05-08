package Util;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class JPASessionUtilTest {

    @Test
    public void getEntityManager() {
        EntityManager em = Util.JPASessionUtil.getEntityManager("Elina");
        em.close();
    }

    @Test()
    public void nonexistentEntityManagerName() {
        Exception exception = assertThrows(
                javax.persistence.PersistenceException.class,
                () -> Util.JPASessionUtil.getEntityManager("nonexistent")
        );
        //System.out.print(exception.getMessage());
        assertTrue(exception.getMessage().contains("No Persistence provider for EntityManager named nonexistent"));
    }


    @Test
    public void getSession() {
        Session session = Util.JPASessionUtil.getSession("Elina");
        session.close();
    }
    @Test()
    public void nonexistentSessionName() {
        Exception exception = assertThrows(
                javax.persistence.PersistenceException.class,
                () -> Util.JPASessionUtil.getSession("nonexistent")
        );
        //System.out.print(exception.getMessage());
        assertTrue(exception.getMessage().contains("No Persistence provider for EntityManager named nonexistent"));
    }
}