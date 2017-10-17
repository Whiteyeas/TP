import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CopyImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            URL url = new URL("http://www.angelxp.be/windows/png/03/Java006.png");  // lien vers l'image
            InputStream in= new BufferedInputStream(url.openStream());  // flux de lecture
            System.out.println("Veuillez saisir le chemin du fichier cible avec son nom");
            System.out.println("Exemple :D:\\Users\\Gabriel\\Documents\\Ingesup\\B3\\Java\\image.png\n");
            FileOutputStream fos = new FileOutputStream(sc.nextLine()); // flux d'eciutre
            byte[] buffer = new byte[1024];
            int a;
            while ((a = in.read(buffer, 0, buffer.length)) != -1)   // copie de l'image
                fos.write(buffer, 0, a);
            fos.close();
        } catch (Exception e) {
        }
    }
}