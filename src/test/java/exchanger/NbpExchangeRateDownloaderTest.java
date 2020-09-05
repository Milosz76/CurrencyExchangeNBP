package exchanger;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NbpExchangeRateDownloaderTest {
    //test TDD
    NbpExchangeRateDownloader subject = new NbpExchangeRateDownloader();

    @Test
    void shouldSuccessfullullyExchengeRate_whenDateInRange() {
        //given
        LocalDate forDate  = LocalDate.of(2020,9,5);

        //then
        NbpExchangeRateResult actual = subject.download(forDate);

        //when
        assertThat(actual.getResponseCode()).isEqualTo(200);
        assertThat(actual.getRate()).isEqualTo(new BigDecimal("4.4508"));//kurs wpisany
        assertThat(actual.getErrorMessage()).isEqualTo("OK"); //czy wiadomość jest nulem
    }

    @Test
    //2. drugi test z data z przyszlosci
    void shouldFailure_whenDateIsInTheFuture() {
        //given
        LocalDate forDate  = LocalDate.of(2021,9,10);

        //then
        NbpExchangeRateResult actual = subject.download(forDate);

        //when
        assertThat(actual.getResponseCode()).isEqualTo(400);
        assertNull(actual.getRate());
        assertThat(actual.getErrorMessage()).contains("Invalid date range"); //czy wiadomość jest nulem
    }

    @Test
    //3. CurrencyExchangeService - obliczanie kursu waluty z NBP
    ExchangeResult shouldCountCurrency_whenRateIsDownloaded(){
        CurrencyExchangeService actual = new CurrencyExchangeService();
        NbpExchangeRateResult nbpExchangeRateResult = new NbpExchangeRateResult();
        //given
        BigDecimal value = new BigDecimal(567); //kwota wpisana
        LocalDate forDate = LocalDate.of(2020,9,4);

        //then  - given value is known
        ExchangeResult exchangeResult = actual.exchange(value ,forDate);

        //when
        assertThat(exchangeResult.getCalculateValue()).isEqualTo(new BigDecimal("127,39")); //kwota z dzielenia po kursie oraz euro i 567
        return exchangeResult;
    }

}