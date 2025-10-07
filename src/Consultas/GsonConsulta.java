package Consultas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConsulta {

  
  
       public static String gsonEncadenado(){
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       DAOGsonConsulta  jSon = new DAOGsonConsulta();
       jSon.setServiceKey("aXZhbkBjb3BpYWRvcmFzY29zdGFsdXouY29tOk1hcmluYTA0MTIxOTgy");
       jSon.setOffset("0");
       jSon.setCount("-1");
       //jSon.setFilters("Filters");
       FiltroDAOGsonConsulta Filters = new FiltroDAOGsonConsulta();
       Filters.setFieldName("SellerID");
       Filters.setOperator("LIKE");
       Filters.setValue("B21217385");
        FiltroDAOGsonConsulta Filters1 = new FiltroDAOGsonConsulta();
       Filters1.setFieldName("InvoiceDate");
       Filters1.setOperator("LIKE");
       Filters1.setValue(Listado.ComboAnio.getSelectedItem().toString().trim()+ "-%");
       FiltroDAOGsonConsulta Filters2 = new FiltroDAOGsonConsulta();
       Filters2.setFieldName("CompanyName");
       Filters2.setOperator("LIKE");
       Filters2.setValue("copiadoras costaluz");
       
       //ME FALTA PONER CUANDO SELECCIONE LA EMPRESA QUE SALGA EL CIF.AQUI ABAJO
     //  Filters.setValue(Listado.ComboEmpresa.getSelectedItem().toString().trim());
       
     
       
       //OTRO FILTRO POR MES
      /* FiltroDAOGsonConsulta filtro1 = new FiltroDAOGsonConsulta();
        filtro1.setFieldName("InvoiceDate");
       filtro1.setOperator("LIKE");
       filtro1.setValue(Listado.ComboAnio.getSelectedItem().toString().trim()+"-%");*/
        /*  {
            "FieldName": "InvoiceDate",
            "Operator": "LIKE",
            "Value": "'2024-%'"
        }*/
       
       
       //FILTRO POR AÑO
     /*  FiltroDAOGsonConsulta filtro2 = new FiltroDAOGsonConsulta();
        filtro2.setFieldName("SellerID");
       filtro2.setOperator("LIKE");
       filtro2.setValue("B21217385");
       jSon.Filters.add(Filters);
       jSon.Filters.add(filtro1);
       jSon.Filters.add(filtro2);*/
     jSon.Filters.add(Filters);
     jSon.Filters.add(Filters1);
     jSon.Filters.add(Filters2);
       String jsonEjemplo = gson.toJson(jSon);
            
          //  System.out.println(jsonEjemplo);
    return jsonEjemplo;
  }


    
}
