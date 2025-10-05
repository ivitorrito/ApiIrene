package Consultas;


public class DAOLista {
   String SellerID,InvoiceID,InvoiceDate,StatusResponse;

   
   

    public String getSellerID() {
        return SellerID;
    }

    public void setSellerID(String SellerID) {
        this.SellerID = SellerID;
    }

    public String getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(String InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(String InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public String getStatusResponse() {
        return StatusResponse;
    }

    public void setStatusResponse(String StatusResponse) {
        this.StatusResponse = StatusResponse;
    }
}
