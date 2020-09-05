package exchanger;

import java.math.BigDecimal;
//dodałem nową klase na potrzeby obliczania
/*
Utwórz klasę CurrencyExchangeService gdzie znajdzie się logika biznesowa dotycząca wymiany waluty. Jako rezultat
tej klasy zwróć obiekt ExchangeResult, który będzie zawierał: obliczoną kwotę w euro,
wiadomość błędu, status kodu http).
 */

public class ExchangeResult {
    private BigDecimal calculateValue;
    private NbpExchangeRateResult nbpExchangeRateResult;

    public BigDecimal getCalculateValue() { //brak parametru poniewaz wyciagam wartosc
        return calculateValue;
    }

    public void setCalculateValue(BigDecimal calculateValue) { // do ustawiania nie wiem
        this.calculateValue = calculateValue;
    }

    public NbpExchangeRateResult getNbpExchangeRateResult() {
        return nbpExchangeRateResult;
    }

    public void setNbpExchangeRateResult(NbpExchangeRateResult nbpExchangeRateResult) {
        this.nbpExchangeRateResult = nbpExchangeRateResult;
    }
}
