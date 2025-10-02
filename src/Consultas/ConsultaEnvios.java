package Consultas;

import IreneSolutions.Decoder;
import IreneSolutions.response;
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
                Map<String, Object> objetoDinamico = objectMapper.readValue(response.body(), HashMap.class);
                for (Map.Entry<String, Object> pair : objetoDinamico.entrySet()) {
               System.out.println(pair);
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
