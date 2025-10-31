

import java.awt.geom.Rectangle2D;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFTextExtractor {

    public static void pdftext() {

        List lista = new ArrayList();
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

                    //File file = new File("C:\\Facturas\\"+ fichero);
                    try ( PDDocument document = Loader.loadPDF(file)) {

                        // 1. Create PDFTextStripper instance
                        PDFTextStripper textStripper = new PDFTextStripper();
                        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                        stripper.setSortByPosition(true);
                        Rectangle2D fecha = new Rectangle2D.Double(40, 20, 100, 100);
                        Rectangle2D emisor = new Rectangle2D.Double(0, 100, 200, 100);
                        Rectangle2D cliente = new Rectangle2D.Double(320, 120, 250, 20);
                        Rectangle2D clientedireccion = new Rectangle2D.Double(320, 150, 130, 40);
                        Rectangle2D clientecif = new Rectangle2D.Double(350, 190, 100, 50);
                        Rectangle2D codigocliente = new Rectangle2D.Double(488, 190, 170, 50);
                        Rectangle2D total = new Rectangle2D.Double(20, 680, 80, 50);
                        Rectangle2D iva = new Rectangle2D.Double(320, 680, 80, 50);
                        Rectangle2D totaliva = new Rectangle2D.Double(500, 680, 70, 30);
                        Rectangle2D numerofactura = new Rectangle2D.Double(250, 90, 100, 20);
                        stripper.addRegion("fecha", fecha);
                        stripper.addRegion("costaluz", emisor);
                        stripper.addRegion("cliente", cliente);
                        stripper.addRegion("clientedireccion", clientedireccion);
                        stripper.addRegion("clientecif", clientecif);
                        stripper.addRegion("codigocliente", codigocliente);
                        stripper.addRegion("total", total);
                        stripper.addRegion("iva", iva);
                        stripper.addRegion("total+iva", totaliva);
                        stripper.addRegion("numerofactura", numerofactura);
                        //obtenerPaginas
                        int numeroDePaginas = document.getNumberOfPages();
                        PDPage ultimaPagina = document.getPage(numeroDePaginas - 1);

                        stripper.extractRegions(ultimaPagina);

                        Inicio inicio = new Inicio();
                        inicio.setVisible(true);
                        Inicio.NumeroFactura.setText(stripper.getTextForRegion("numerofactura"));
                        Inicio.Fecha.setText(stripper.getTextForRegion("fecha"));
                        Inicio.Importe.setText(stripper.getTextForRegion("total"));
                        Inicio.Iva.setText(stripper.getTextForRegion("iva"));
                        Inicio.ImporteTotal.setText(stripper.getTextForRegion("total+iva"));
                        Inicio.clientearea.setText(stripper.getTextForRegion("cliente"));
                        Inicio.cif.setText(stripper.getTextForRegion("clientecif"));
                        inicio.clientedireccion.setText(stripper.getTextForRegion("clientedireccion"));
                        inicio.codigocliente.setText(stripper.getTextForRegion("codigocliente"));
                        // 2. Configure extraction settings (optional)
                        textStripper.setSortByPosition(true); // Maintains physical layout
                        textStripper.setStartPage(1); // First page to extract
                        textStripper.setEndPage(document.getNumberOfPages()); // Last page

                        // 3. Extract text from entire document
                        String text = textStripper.getText(document);
                        System.out.print(stripper.getTextForRegion("total+iva"));
                        // 4. Output results
                        //System.out.println("=== Extracted Text ===");
                        System.out.println(text);

                        // 5. (Optional) Save to text file
                        // Files.writeString(Path.of("extracted.txt"), text);
                      
                    } catch (IOException e) {
                        System.err.println("Error extracting text: " + e.getMessage());
                    }

                    //file.renameTo(file);
                    //file.delete();
                }
            }
        }
    }
}
