package exchanger;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

public class NbpExchangeRate {

    private String no;
    private XMLGregorianCalendar effectiveDate;
    private BigDecimal mid;

    public String getNo() {
        return no;
    }

    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setEffectiveDate(XMLGregorianCalendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
