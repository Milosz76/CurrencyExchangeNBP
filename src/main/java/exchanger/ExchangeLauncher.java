package exchanger;
/*
       W klasie ExchangeLauncher z metodą main odpowiedzialną
       za pobranie danych od użytkownika i zwrócenie wyników. Łączy się bezpośrednio z serwisem CurrencyExchangeService.
        */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ExchangeLauncher {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020,9,4);
        System.out.print("Podaj kwotę: ");
        Scanner input = new Scanner(System.in);
        BigDecimal userValue = input.nextBigDecimal();
        System.out.println("Twoja kwota to: " + userValue);

       CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        System.out.println(currencyExchangeService.exchange(userValue, date));


    }
}
