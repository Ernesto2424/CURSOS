
import java.net.*;
import java.io.*;
import manejoArchivos.ManejoArchivos;

public class Servidor {
    
    
    public static void main(String[] args) throws IOException  {
        
        ServerSocket servidor = new ServerSocket(1234);
        String msj = " ";
        while(true){
        try (Socket cliente = servidor.accept()) {
            
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            
            dos.writeUTF(ManejoArchivos.leerArchivoCadena(msj+".txt")+"\r\nHello Client\n"
                    + "seleccione uno de los siguientes archivos:\n" + ManejoArchivos.leerArchivoCadena("documentos.txt")+"\n");
            
             msj = dis.readUTF();
            System.out.println("msj from Client = " + msj);
            
           //dos.writeUTF(ManejoArchivos.leerArchivoCadena(msj+".txt"));
            if(msj==null){
            dos.close();
            os.close();
            dis.close();
            is.close();
            cliente.close();    
            }
            
        }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
}
