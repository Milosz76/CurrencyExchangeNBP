package exchanger;

import java.math.BigDecimal;

public class NbpExchangeRateResult {
    //zwracam kurs w big decimal
    private BigDecimal rate; //stawki
    private int responseCode; //połączenie
    private String responseMessage;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getErrorMessage() {
        return responseMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.responseMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
