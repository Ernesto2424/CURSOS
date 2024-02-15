
import java.net.*;
import java.io.*;


public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        try (Socket cliente = new Socket("localhost", 1234)) {
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            
            String mensaje = new String(dis.readUTF());
            System.out.println("mensaje = " + mensaje);
            
            dis.close();
            is.close();
            cliente.close();
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
