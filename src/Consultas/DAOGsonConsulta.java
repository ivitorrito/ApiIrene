package Consultas;

import java.util.ArrayList;


public class DAOGsonConsulta {
    
    String ServiceKey,Offset,Count;
public ArrayList<Object> Filters = new ArrayList<Object>();

    public ArrayList<Object> getFiltros() {
        return Filters;
    }

    public void setFiltros(ArrayList<Object> Filtros) {
        this.Filters = Filtros;
    }
    
    
    
   

    public String getServiceKey() {
        return ServiceKey;
    }

    public void setServiceKey(String ServiceKey) {
        this.ServiceKey = ServiceKey;
    }

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String Offset) {
        this.Offset = Offset;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }



 
        
        
        
}

