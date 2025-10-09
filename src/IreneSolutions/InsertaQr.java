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
                            try ( PDDocument document = Loader.loadPDF(file)) {
                                // Choose IMAGE File

                                PDImageXObject pdImage = PDImageXObject.createFromFile(file1, document);

                                int numeroDePaginas = document.getNumberOfPages();
                                PDPage ultimaPagina = document.getPage(numeroDePaginas - 1);
                                PDPage page = document.getPage(numeroDePaginas - 1);
                                try (
                                         PDPageContentStream contenido = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true)) {
                                    contenido.drawImage(pdImage, 230, 790, 50, 50);
                                    PDType1Font font = new PDType1Font(Standard14Fonts.FontName.SYMBOL);
                                    contenido.beginText();
                                    contenido.setFont(font, 8);
                                    contenido.newLineAtOffset(230, 790);
                                    //contenido.showText("UUID: " + uuid);
                                    contenido.endText();
                                    contenido.close();
                                }
                                //Inicio.NumeroFactura.getText().trim()
                                document.save("C:\\Facturas\\FacturasConQr\\" + Inicio.NumeroFactura.getText().trim() + ".pdf");
                                document.close();
                                //BORRA EL ARCHIVO QR
                                 String nombreArchivo = "C:\\Facturas\\CodigoQr\\qr.png"; // Ruta del archivo a borrar
        File archivo = new File(nombreArchivo);
                                        if (archivo.exists()) {
            boolean eliminado = archivo.delete();
            if (eliminado) {
                System.out.println("El archivo " + nombreArchivo + " se eliminó correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo " + nombreArchivo);
            }
        } else {
            System.out.println("El archivo " + nombreArchivo + " no existe.");
        }
    
                                Path source = Paths.get("C:\\Facturas\\" + fichero);
                        Path target = Paths.get("C:\\Facturas\\test\\");
                        try {
                            Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Archivo movido con éxito.");
                        } catch (IOException e) {
                            System.err.println("Error al mover el archivo: " + e.getMessage());
                        }
                    
                                
                               

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
