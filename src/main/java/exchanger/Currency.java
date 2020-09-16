package exchanger;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name ="currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddate;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "currency_rate")
    private BigDecimal currencyRate;

    @Column(name = "currency_result")
    private BigDecimal currencyResult;


    public Integer getIddate() {
        return iddate;
    }

    public Currency() {

    }

    public Currency(Integer iddate, LocalDate date, BigDecimal currencyRate, BigDecimal currencyResult) {
        this.iddate = iddate;
        this.date = date;
        this.currencyRate = currencyRate;
        this.currencyResult = currencyResult;
    }

    public void setIddate(Integer iddate) {
        this.iddate = iddate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public BigDecimal getCurrencyResult() {
        return currencyResult;
    }

    public void setCurrencyResult(BigDecimal currencyResult) {
        this.currencyResult = currencyResult;
    }
}
