package exchanger;

import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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

}