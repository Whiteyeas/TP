import java.io.*;
import java.util.Scanner;

class Path {
    File fileCopy;
    File fileDestination;
    public void copyInFile(){      // ouverture et écriture dans le fichier
        String line = "";
        Scanner sc = new Scanner(System.in);
        if (fileCopy.isFile() && fileDestination.isFile() && fileDestination != fileCopy){     // verifier que le chemin pointe sur des fichiers
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileCopy)); // flux de lecture
                FileWriter fileWriter = new FileWriter(fileDestination);    // flux d'écriture
                line = bufferedReader.readLine();
                while (line != null) {
                    fileWriter.write(line + System.getProperty("line.separator")); // ecrit dans le fichier destination
                    line = bufferedReader.readLine();
                }
                fileWriter.close();
            }catch (IOException e) {
            }
        }else System.out.println("Le/les chemin est incorrect");
    }
    public Path(String pathCopy, String pathDest){
        fileCopy = new File(pathCopy);
        fileDestination = new File(pathDest);
    }
}
public class CopyFile {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String str = "";
        String str2 = "";
        while (true){
            System.out.println("Veuillez saisir le chemin du fichier a copier:");
            str = sc.nextLine();
            System.out.println("Veuillez saisir le chemin du fichier de destination:");
            str2 = sc.nextLine();
            Path path = new Path(str, str2);
            path.copyInFile();
        }
    }
}
