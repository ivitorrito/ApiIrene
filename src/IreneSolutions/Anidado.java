package IreneSolutions;

import java.util.List;

public class Anidado {

    private String TaxScheme;
    private String TaxType;
    private String TaxRate;
    private String TaxBase;

    public String getTaxBase() {
        return TaxBase;
    }

    public void setTaxBase(String TaxBase) {
        this.TaxBase = TaxBase;
    }
    private String TaxAmount;
    private List<String> ciudades;

    public Anidado() {
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

    public String getTaxAmount() {
        return TaxAmount;
    }

    public void setTaxAmount(String TaxAmount) {
        this.TaxAmount = TaxAmount;
    }

  

    public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }
}
