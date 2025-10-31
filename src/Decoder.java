


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Decoder {
     public void Decoder(String base64String) throws Exception{
        //String base64String = "iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQAAAABYmaj5AAAA7ElEQVR42tXUsZHEIAwFUHk2cHZuQDO0QeaWTAN4twK3REYbzNAAyhww1ombvd1NbBHeMQS8CPERAH+MAn9YBWCBzAEGTcR13W8cZaEpoLdpiuA6tIb86JWhHnH1tq7vyk4l53MR3fu0p2pZzbJ8JXiqYtHP6H53uBAH3mKadpg0HRZhRrCZNBHzxnWIadBUbILRbK/KzkXxRhEHNpumMuLXLPOZ4IVoz4flA5LTlTzkO+CkqeU/Sgy65G59q92QptbXLIEZVhXQsblDlxZIy8iPDsmrIn5mdiWui/QCoKr2pq35CUPRf/nBPvUNct67nP2Y9j8AAAAASUVORK5CYII=";

        // Convert Base64 String to File
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        Files.write(Paths.get("C:\\Facturas\\CodigoQr\\qr.png"), decodedBytes);
    
}
}