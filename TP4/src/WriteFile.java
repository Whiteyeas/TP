import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Path {
    private File file;
    private String lineToWrite(){   //recupere la ligne à ecrire
        Scanner sc = new Scanner(System.in);
        System.out.println("Ecrivez la ligne à insérer");
        return sc.nextLine();
    }
    public void writeInFile(){      // ouverture et écriture dans le fichier
        String line = "";
        if (file.isFile()){     // verifier que le chemin pointe sur un fichier
            System.out.println("Fichier:" + file.getName());
            try {
                FileWriter fileWriter = new FileWriter(file);
                line = lineToWrite();
                while (!line.toLowerCase().equals("quit")){     // écriture dans le fichier
                    fileWriter.write(line + System.getProperty("line.separator"));
                    line = lineToWrite();
                }
                fileWriter.close();
            } catch (IOException e) {
            }
        }else System.out.println("Le chemin est incorrect");
    }
    public Path(String path) {
        file = new File(path);
    }
}
public class WriteFile {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (true){
            System.out.println("Veuillez saisir le chemin :");
            str = sc.nextLine();
            Path path = new Path(str);
            path.writeInFile();
        }
    }
}
