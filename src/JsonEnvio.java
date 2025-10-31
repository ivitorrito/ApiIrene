

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class JsonEnvio {
    String ServiceKey;
    String Status;
    String InvoiceType;
    String InvoiceID;
    Date InvoiceDate;
    String SellerID;
    String CompanyName;
    String RelatedPartyID;
    String RelatedPartyName;
    String Text;
   // String TaxItems;
    String TaxScheme;
    String TaxType;
    String TaxRate;
    String TaxBase;
    String TaxAmount;
     public ArrayList<Object> TaxItems = new ArrayList<Object>();
     public ArrayList<Object> RectificationItems = new ArrayList<>();
     
    

    public ArrayList<Object> getLineas() {
        return TaxItems;
    }

    public void setLineas(ArrayList<Object> lineas) {
        this.TaxItems = lineas;
    }

 
    

    public String getServiceKey() {
        return ServiceKey;
    }

    public void setServiceKey(String ServiceKey) {
        this.ServiceKey = ServiceKey;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String InvoiceType) {
        this.InvoiceType = InvoiceType;
    }

    public String getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(String InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

   
  

    public String getSellerID() {
        return SellerID;
    }

    public void setSellerID(String SellerID) {
        this.SellerID = SellerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getRelatedPartyID() {
        return RelatedPartyID;
    }

    public void setRelatedPartyID(String RelatedPartyID) {
        this.RelatedPartyID = RelatedPartyID;
    }

    public String getRelatedPartyName() {
        return RelatedPartyName;
    }

    public void setRelatedPartyName(String RelatedPartyName) {
        this.RelatedPartyName = RelatedPartyName;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

  

    public String getTaxScheme() {
        return TaxScheme;
    }

    public void setTaxScheme(String TaxScheme) {
        this.TaxScheme = TaxScheme;
    }

    public String getTaxType() {
        return TaxType;
    }

    public void setTaxType(String TaxType) {
        this.TaxType = TaxType;
    }

    public String getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(String TaxRate) {
        this.TaxRate = TaxRate;
    }

    public String getTaxBase() {
        return TaxBase;
    }

    public void setTaxBase(String TaxBase) {
        this.TaxBase = TaxBase;
    }

    public String getTaxAmount() {
        return TaxAmount;
    }

    public void setTaxAmount(String TaxAmount) {
        this.TaxAmount = TaxAmount;
    }
    
    
}
