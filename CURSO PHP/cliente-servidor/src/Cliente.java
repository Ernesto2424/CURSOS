
import java.net.*;
import java.io.*;


public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        try (Socket cliente = new Socket("172.16.6.107", 1234)) {
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            String mensaje = new String(dis.readUTF());
            System.out.println("mensaje = " + mensaje);
            dos.writeUTF("hola mi amor!");
            
            dis.close();
            is.close();
            dos.close();
            os.close();
            cliente.close();
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
