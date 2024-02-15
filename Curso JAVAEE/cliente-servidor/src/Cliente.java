
import java.net.*;
import java.io.*;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;


public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        while(true){
        try (Socket cliente = new Socket("localhost", 1234)) {
            
            Scanner sc = new Scanner(System.in);
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            String mensaje = dis.readUTF();
            System.out.println("mensaje del Servidor= " + mensaje);
            String escribir = sc.nextLine();
            dos.writeUTF(escribir);
            //manejo de creacion de archivos para el cliente
           /// ManejoArchivos.crearArchivo(mensaje+".txt");
            //ManejoArchivos.anexaArchivo(mensaje+".txt", mensaje+"\n"+"este es mi msj");
            if(escribir==null){
            dis.close();
            is.close();
            dos.close();
            os.close();
            cliente.close();    
            }
            
            }
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
