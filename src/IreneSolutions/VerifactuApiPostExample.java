package IreneSolutions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class VerifactuApiPostExample {

    public static void main(String[] args) throws IOException {
        // URL del endpoint
        String endpoint = "https://facturae.irenesolutions.com:8050/Kivu/Taxes/Verifactu/Invoices/Create";

        // Cuerpo de la solicitud (JSON)
        String requestBody = """
                {
                     "ServiceKey": "aXZhbkBjb3BpYWRvcmFzY29zdGFsdXouY29tOk1hcmluYTA0MTIxOTgy",
                                "Status": "POST",
                                "InvoiceType": "F1",
                                "InvoiceID": "FRTEST175920757",
                                "InvoiceDate": "2025-09-30T04:45:09.737Z",
                                "SellerID": "B12959755",
                                "CompanyName": "IRENE SOLUTIONS SL",
                                "RelatedPartyID": "B44531218",
                                "RelatedPartyName": "Ayuntamiento",
                                "Text": "SERVICIOS INFORMATICOS",
                                "TaxItems": [
                                    {
                                        "TaxScheme": "01",
                                        "TaxType": "S1",
                                        "TaxRate": 21,
                                        "TaxBase": 11.99,
                                        "TaxAmount": 2.52
                        }
                    ]
                }
                """;

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
                //System.out.println(response.body());
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> objetoDinamico = objectMapper.readValue(response.body(), HashMap.class);
                Gson gson = new Gson();
                String json = gson.toJson(objetoDinamico.get("Return"));
                
                response resp = gson.fromJson(json, response.class);
                Decoder decoder = new Decoder();
                decoder.Decoder(resp.QrCode.trim());

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
