package exchanger;

import javax.persistence.*;

@Entity
@Table(name ="currency")
public class currency {
    @Id
    @GeneratedValue
    private Long iddate;

    @Column(name = "date")
    private String date;

    @Column(name = "currency_date")
    private String currencyDate;

    @Column(name = "currency_result")
    private String currencyResult;

    public Long getIddate() {
        return iddate;
    }

    public void setIddate(Long iddate) {
        this.iddate = iddate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrencyDate() {
        return currencyDate;
    }

    public void setCurrencyDate(String currencyDate) {
        this.currencyDate = currencyDate;
    }

    public String getCurrencyResult() {
        return currencyResult;
    }

    public void setCurrencyResult(String currencyResult) {
        this.currencyResult = currencyResult;
    }
}
