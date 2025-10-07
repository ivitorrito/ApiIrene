/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.squareup.okhttp.internal.Platform.get;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ivan
 */
public class OtraConsulta {
        
       public String get(){
      String salida="";
        String endpoint = "https://facturae.irenesolutions.com:8050/Kivu/Taxes/Verifactu/Invoices/GetFilteredList";

        String requestBody = GsonConsulta.gsonEncadenado();
        System.out.println(requestBody);
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Construir la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Content-Type", "application/json") // Tipo de contenido
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody)) // Método POST con el cuerpo
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Manejar la respuesta
            if (response.statusCode() == 200) {
                System.out.println("Respuesta exitosa:");
                System.out.println(response.body());
             salida = response.body();
               
                
           
                
           

            } else {
                System.out.println("Error en la llamada: " + response.statusCode());
                System.out.println("Detalle: " + response.body());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al realizar la solicitud.");
        }
           return salida;
       
       }
public DefaultTableModel leer() {
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     
     String encabezado[] ={"SellerID","InvoiceID","InvoiceDate","StatusResponse"};
     tabla.setColumnIdentifiers(encabezado);
     String datos[] = new String[4];
     //JSONArray arreglo = new JSONArray(get());
      ObjectMapper objectMapper = new ObjectMapper();             
                JsonNode jsonNode = objectMapper.readValue(get(), JsonNode.class);
                JsonNode array = jsonNode.get("Items");
                for (int i = 0; i < array.size(); i++) {
                JsonNode jsonNode1 = array.get(i);            
                String SellerID = jsonNode1.get("SellerID").asText();
               String  InvoiceID = jsonNode1.get("InvoiceID").asText();
               String  InvoiceDate = jsonNode1.get("InvoiceDate").asText();
              String  StatusResponse = jsonNode1.get("StatusResponse").asText();
   
        datos[0] = SellerID;
        datos[1] = InvoiceID;
        datos[2] = InvoiceDate;
        datos[3] = StatusResponse;
        
        tabla.addRow(datos);
        
       
     }
 }catch(JSONException ex){
 System.out.println("Error tabla:" + ex.getMessage());
 }         catch (IOException ex) {
               Logger.getLogger(OtraConsulta.class.getName()).log(Level.SEVERE, null, ex);
           }
 return tabla;
 
 }}






