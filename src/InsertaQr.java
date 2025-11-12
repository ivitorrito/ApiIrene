
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
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.printing.Scaling;

public class InsertaQr {

    void InsertQr(String file1, String file2) throws Exception {
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
                        try {
                            // Choose IMAGE File
                            try (PDDocument document = Loader.loadPDF(file)) {
                                

                                PDImageXObject QR = PDImageXObject.createFromFile(file1, document);
                                PDImageXObject ImagenEnBlanco = PDImageXObject.createFromFile(file2, document);

                                int numeroDePaginas = document.getNumberOfPages();
                                // PDPage ultimaPagina = document.getPage(numeroDePaginas - 1);

                                PDPage page = document.getPage(0);
                                try (
                                        PDPageContentStream contenido = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true)) {
                                    contenido.drawImage(QR, 235, 645, 90, 90);
                                    PDType1Font font = new PDType1Font(Standard14Fonts.FontName.COURIER);
                                    //contenido.drawImage(ImagenEnBlanco, 375, 755, 80, 80);
                                    contenido.beginText();
                                    contenido.setFont(font, 4);
                                    contenido.setLeading(10f);
                                    contenido.newLineAtOffset(237, 645);
                                    contenido.showText("    Factura verificable en la");
                                    contenido.newLine();
                                    contenido.showText("  sede electrónica de la AEAT");
                                    contenido.endText();
                                    contenido.close();
                                }
                               
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
