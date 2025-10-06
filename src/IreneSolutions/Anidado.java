package IreneSolutions;

import java.util.List;

public class Anidado {

    private String nombre;
    private String base_imponible;
    private String tipo_impositivo;
    private String cuota_repercutida;
    private List<String> ciudades;

    public Anidado() {
    }

    public String getTipo_impositivo() {
        return tipo_impositivo;
    }

    public void setTipo_impositivo(String tipo_impositivo) {
        this.tipo_impositivo = tipo_impositivo;
    }

    public String getCuota_repercutida() {
        return cuota_repercutida;
    }

    public void setCuota_repercutida(String cuota_repercutida) {
        this.cuota_repercutida = cuota_repercutida;
    }

    public String getBase_imponible() {
        return base_imponible;
    }

    public void setBase_imponible(String base_imponible) {
        this.base_imponible = base_imponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }
}
