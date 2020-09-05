package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class NbpExchangeRateDownloader {


    public NbpExchangeRateResult download(LocalDate forDate) {
        //na jaka date chcemy przewalutowac waluty

        NbpExchangeRateResult result = new NbpExchangeRateResult(); //obiekt result jako wynik
        try {

            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/EUR/" + forDate ); //forDate - bo chcemy wiedziec jaka date pobieramy //
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            //2. przypisuje wartosci
            result.setErrorMessage(conn.getResponseMessage()); //2. do testow
            result.setResponseCode(conn.getResponseCode());//2. do testow



            if (conn.getResponseCode() != 200) { //z zadania 200 oznacza ze jest dobrze
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode()); //pobieramy zasób z sieci /jak zapisuje jest POST /kasuje Delete
            }


            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            NbpExchangeRateSeries series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);

            result.setRate(series.getRates().get(0).getMid()); //2. testuje
            // z conn wyzej /System.out.println(series.getRates().get(0).getMid()); //z json tworze obiekt //get(0) - jako pierwszy elem z kolekcji.

            conn.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return result;
    }
}