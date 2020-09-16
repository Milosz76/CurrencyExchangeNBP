package exchanger;
/*
       W klasie ExchangeLauncher z metodą main odpowiedzialną
       za pobranie danych od użytkownika i zwrócenie wyników. Łączy się bezpośrednio z serwisem CurrencyExchangeService.
        */

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class ExchangeLauncher {

public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020,9,4);
        System.out.print("Podaj kwotę: ");
        Scanner input = new Scanner(System.in);
        BigDecimal userValue = input.nextBigDecimal();
        System.out.println("Twoja kwota to: " + userValue);

       CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        System.out.println(currencyExchangeService.exchange(userValue, date));

        try{
            //create a mysql connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myURL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
            String query = "SELECT currency_rate,currency_result,date FROM currency";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myURL, "root", "BazaDanych");
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Date data = resultSet.getDate("date");
                BigDecimal currency_rate2 = resultSet.getBigDecimal("currency_rate");
                BigDecimal currency_result2 = resultSet.getBigDecimal("currency_result");

                //próba wywołania wykresu z bazy danych - wizualizacja danych
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn,query);
                JFreeChart chart = ChartFactory.createLineChart("Euro rates","Currency rate","Currency result",dataset);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Wykres",chart);
                frame.setVisible(true);
                frame.setSize(400,650);
                
            }
            System.out.printf(String.valueOf(resultSet));
            //filling table with data except date
            //statement.executeUpdate("SELECT currency_rate,currency_result,date FROM currency");
            conn.close();

        } catch (Exception e) {
            System.err.println("An exception!");
            System.err.println(e.getMessage());
        }


    }
}
