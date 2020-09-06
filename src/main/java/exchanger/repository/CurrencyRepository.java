package exchanger.repository;

import exchanger.Currency;
import exchanger.CurrencyExchangeService;

import javax.persistence.*;
import java.util.List;

public class CurrencyRepository {
    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public CurrencyRepository(){
        managerFactory = Persistence.createEntityManagerFactory("CurrencyPersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }


    public void save(Currency currency){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(currency);
        transaction.commit();
    }

    public void delete(Currency currency){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(currency);
        transaction.commit();
    }

    public void cleanUp(){
        entityManager.close();
        managerFactory.close();
    }


}
