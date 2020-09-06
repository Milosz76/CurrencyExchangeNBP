package exchanger;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name ="currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddate;

    @Column(name = "date")
    private String date;

    @Column(name = "currency_rate")
    private String currencyRate;

    @Column(name = "currency_result")
    private String currencyResult;

    public Integer getIddate() {
        return iddate;
    }

    public Currency() {
    }

    public Currency(Integer iddate, String date, String currencyRate, String currencyResult) {
        this.iddate = iddate;
        this.date = date;
        this.currencyRate = currencyRate;
        this.currencyResult = currencyResult;
    }

    public void setIddate(Integer iddate) {
        this.iddate = iddate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getCurrencyResult() {
        return currencyResult;
    }

    public void setCurrencyResult(String currencyResult) {
        this.currencyResult = currencyResult;
    }
}
