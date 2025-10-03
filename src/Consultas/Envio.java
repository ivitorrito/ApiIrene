
package Consultas;
import com.fasterxml.jackson.databind.DeserializationFeature;
  import com.fasterxml.jackson.databind.ObjectMapper;
    import java.io.File;
    import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.TreeMap;

public class Envio {
    

    
        public static void main(String[] args) throws IOException {
              String endpoint = "https://facturae.irenesolutions.com:8050/Kivu/Taxes/Verifactu/Invoices/GetFilteredList";

        String requestBody = """
    {
    "ServiceKey": "aXZhbkBjb3BpYWRvcmFzY29zdGFsdXouY29tOk1hcmluYTA0MTIxOTgy",
    "Offset": 0,
    "Count": -1,
    "Filters": [
        {
            "FieldName": "SellerID",
            "Operator": "LIKE",
            "Value": "'B12959755'"
        },
        {
            "FieldName": "InvoiceDate",
            "Operator": "LIKE",
            "Value": "'2025-%'"
        }
    ]
}""";
        
        
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
                // System.out.println(response.body());
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            Map<String, Object> objetoDinamico = objectMapper.readValue(response.body(), TreeMap.class);
              String jsonString = objetoDinamico.entrySet().toString();

            ConsultaEstilo persona = objectMapper.readValue(jsonString, ConsultaEstilo.class);

            System.out.println("Nombre: " + persona.getCount());
            System.out.println("Apellido: " + persona.getResultMessage());
             
               
            } else {
                System.out.println("Error en la llamada: " + response.statusCode());
                System.out.println("Detalle: " + response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al realizar la solicitud.");
        }
        
        }
    } 

