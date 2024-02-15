
import java.net.*;
import java.io.*;

public class Servidor {
    
    
    public static void main(String[] args) throws IOException  {
        
        ServerSocket servidor = new ServerSocket(1234);
        while(true){
        try (Socket cliente = servidor.accept()) {
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dos.writeUTF("Hola que tal");
            String msj = new String(dis.readUTF());
            System.out.println("msj = " + msj);
            dos.close();
            os.close();
            dis.close();
            is.close();
            cliente.close();
        }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
}
