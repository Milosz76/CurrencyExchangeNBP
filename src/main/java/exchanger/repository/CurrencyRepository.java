package exchanger.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CurrencyRepository {
    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public CurrencyRepository(){
        managerFactory = Persistence.createEntityManagerFactory("CurrencyPersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }




}
