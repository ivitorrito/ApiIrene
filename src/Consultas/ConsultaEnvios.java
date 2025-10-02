package Consultas;

import IreneSolutions.Decoder;
import IreneSolutions.response;
import static com.fasterxml.jackson.databind.AnnotationIntrospector.pair;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Taller
 */
public class ConsultaEnvios {

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
                Map<String, Object> objetoDinamico = objectMapper.readValue(response.body(), TreeMap.class);
                for (Map.Entry<String, Object> pair : objetoDinamico.entrySet()) {
                    String clave = pair.getKey();
                    Object valor = pair.getValue();
                   // System.out.println(clave + " -> " + valor);
                    //System.out.println(pair);
                    if("Items".equals(clave)){
                    System.out.println(pair.getValue());
                    String claveBuscada = "SellerID";
                    if(claveBuscada.equals(pair.getValue()))
                        
                    System.out.println(claveBuscada);
                    
                    }
                }
               
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
