package exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CurrencyExchangeService {
    NbpExchangeRateDownloader nbpExchangeRateDownloader = new NbpExchangeRateDownloader();

    public ExchangeResult exchange(BigDecimal value, LocalDate forDate){
        ExchangeResult exchangeResult = new ExchangeResult();

        NbpExchangeRateResult nbpExchangeRateResult = nbpExchangeRateDownloader.download(forDate);
        exchangeResult.setCalculateValue((value.divide(nbpExchangeRateResult.getRate(), 2, RoundingMode.HALF_DOWN))); //set poniewaz jest ustawiam wartosc z reki
        exchangeResult.setNbpExchangeRateResult(nbpExchangeRateResult);
        return exchangeResult;
    }
}
