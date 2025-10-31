

  import java.io.IOException;
    import java.io.OutputStream;
    import javax.swing.JTextArea;

    public class CustomOutputStream extends OutputStream {
        public static JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // Convierte el byte a un carácter y lo añade al JTextArea
            textArea.append(String.valueOf((char) b));
            // Para asegurar que la salida aparezca inmediatamente, especialmente en streams más grandes
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }