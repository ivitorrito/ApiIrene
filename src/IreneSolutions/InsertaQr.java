package IreneSolutions;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class InsertaQr {

    void InsertQr(String file1) throws Exception {
        {
            ArrayList<String> lista = new ArrayList();

            String directorio = "C:\\Facturas";
            String extension = ".pdf";
            File f = new File(directorio);

            if (f.exists()) { // Directorio existe }
                File[] ficheros = f.listFiles();
                for (File fichero1 : ficheros) {
                    String fichero = fichero1.getName();
                    if (fichero.contains(extension)) {
                        lista.add(fichero);
                        File file = new File("C:\\Facturas\\" + fichero);

                        //File file1 = new File("C:\\Facturas\\CodigoQr\\qr.png");
                        try {
                            // Choose IMAGE File
                            try (PDDocument document = Loader.loadPDF(file)) {
                                // Choose IMAGE File

                                PDImageXObject pdImage = PDImageXObject.createFromFile(file1, document);
                                PDImageXObject pdImage1 = PDImageXObject.createFromFile("src/Imagenes/cuadro.png", document);

                                int numeroDePaginas = document.getNumberOfPages();
                                PDPage ultimaPagina = document.getPage(numeroDePaginas - 1);
                                PDPage page = document.getPage(numeroDePaginas - 1);
                                try (
                                        PDPageContentStream contenido = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true)) {
                                    contenido.drawImage(pdImage, 190, 755, 90, 90);
                                    PDType1Font font = new PDType1Font(Standard14Fonts.FontName.COURIER);
                                    contenido.drawImage(pdImage1, 375, 755, 80, 80);
                                    contenido.beginText();
                                    contenido.setFont(font, 6);
                                    contenido.setLeading(10f);
                                    contenido.newLineAtOffset(270, 810);
                                    contenido.showText("  Factura verificable en la " );
                                    contenido.newLine();
                                    contenido.showText("  sede electrónica de la AEAT" );
                                    contenido.endText();
                                    contenido.close();

                                }
                                //Inicio.NumeroFactura.getText().trim()
                                document.save("C:\\Facturas\\FacturasConQr\\" + Inicio.NumeroFactura.getText().trim() + ".pdf");
                                document.close();
                                Thread.sleep(1000);
                            

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
