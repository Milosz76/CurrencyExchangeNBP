package exchanger.init;

import exchanger.Currency;
import exchanger.repository.CurrencyRepository;

public class AppLuncher {
    public static void main(String[] args) {
        CurrencyRepository currencyRepository = new CurrencyRepository();
        Currency currencyObj = new Currency(null,"2020-09-06","4.34","434");

        currencyRepository.save(currencyObj);
        currencyRepository.cleanUp();
    }
}
