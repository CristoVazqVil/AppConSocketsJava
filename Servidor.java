import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
//Cristopher Vázquez Villa

public class Servidor {
    public static void main(String[] args) {
        int puerto = 8080;

        try {
            ServerSocket ss = new ServerSocket (puerto);
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");
            Socket ch = ss.accept();
            PrintWriter out = new PrintWriter(ch.getOutputStream(), true);
    
            BufferedReader in = new BufferedReader(new InputStreamReader(ch.getInputStream()));
                
            Scanner scanner = new Scanner(System.in);
            
            String mensaje;
            do {
                mensaje = scanner.nextLine();
                out.println(mensaje);
            } while (!mensaje.equalsIgnoreCase("Adios"));
    
            scanner.close();
            out.close();
            in.close();
            ch.close();
            ss.close();
 
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}