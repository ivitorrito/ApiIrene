import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class SystemTrayTest
{

    public  SystemTrayTest()
    {
       
        
        /*El objeto trayIcon representa el tray icon valga la redundancia
          a este objeto se le pueden asigna imágenes, popups, tooltips y
          una serie de listeners asociados a el*/
        final TrayIcon trayIcon;

        /*Se verifica si el sistema soporta los try icons*/
        if (SystemTray.isSupported()) {

            SystemTray tray = SystemTray.getSystemTray();

            //Se asigna la imagen que del tray icon
            ImageIcon im = new ImageIcon(SystemTrayTest.class.getResource("/Imagenes/Logo.png"));
            Image image = Toolkit.getDefaultToolkit().getImage("/Imagenes/Logo.png");
        
            //Este listener permite salir de la aplicacion
            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   // System.out.println("Exiting...");
                    System.exit(0);
                }
            };
             ActionListener ConfigurarApp = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  //  System.out.println("Configurando...");
                   
                }
            };
            
            //Aquí se crea un popup menu
            PopupMenu popup = new PopupMenu();

            //Se agrega la opción de salir
            MenuItem defaultItem = new MenuItem("Salir");
            MenuItem defaultItem1 = new MenuItem("Configurar");

            //Se le asigna al item del popup el listener para salir de la app
            defaultItem.addActionListener(exitListener);
            defaultItem1.addActionListener(ConfigurarApp);
            popup.add(defaultItem);
            popup.add(defaultItem1);
               
            /*Aqui creamos una instancia del tray icon y asignamos
            La imagen, el nombre del tray icon y el popup*/
            trayIcon = new TrayIcon(im.getImage(), "Cuidaito Ehhh", popup);

            /*Creamos un acction listener que se ejecuta cuando le damos
            doble click al try icon*/
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trayIcon.displayMessage("Action Event", 
                        "An Action Event Has Been Peformed!",
                        TrayIcon.MessageType.INFO);
                }
            };
            

            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(actionListener);

            try {

                tray.add(trayIcon);
               
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
           
        } else {
           // System.err.println("System tray is currently not supported.");
        }
    }
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        SystemTrayTest main = new SystemTrayTest();
           FileChangeWatcher fileChangeWatcher = new FileChangeWatcher();
        try {
            fileChangeWatcher.doWath("C:\\Facturas\\");
        } catch (IOException ex) {
            Logger.getLogger(SystemTrayTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}