package exchanger;

import exchanger.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
//tutaj mam dostep do wszystkiego i w tej klasie wykonuja sie wszystkie obliczenia

public class CurrencyExchangeService {
    CurrencyRepository currencyRepository = new CurrencyRepository();

    NbpExchangeRateDownloader nbpExchangeRateDownloader = new NbpExchangeRateDownloader();
    public ExchangeResult exchange(BigDecimal value, LocalDate forDate){

        ExchangeResult exchangeResult = new ExchangeResult();

        NbpExchangeRateResult nbpExchangeRateResult = nbpExchangeRateDownloader.download(forDate);
        BigDecimal bigDecimalValue = value.divide(nbpExchangeRateResult.getRate(), 2, RoundingMode.HALF_DOWN);

        exchangeResult.setCalculateValue(bigDecimalValue); //set poniewaz jest ustawiam wartosc z reki
        exchangeResult.setNbpExchangeRateResult(nbpExchangeRateResult);

        Currency currencyObj = new Currency(null, forDate,nbpExchangeRateResult.getRate(),bigDecimalValue);
        currencyRepository.save(currencyObj);
        currencyRepository.cleanUp();
        return exchangeResult;
    }
}
