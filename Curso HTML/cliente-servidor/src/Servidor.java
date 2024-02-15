
import java.net.*;
import java.io.*;

public class Servidor {
    
    
    public static void main(String[] args) throws IOException  {
        
        ServerSocket servidor = new ServerSocket(1234);
        try (Socket cliente = servidor.accept()) {
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("Hola que tal cliente ");
            dos.close();
            os.close();
            cliente.close();
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
}
