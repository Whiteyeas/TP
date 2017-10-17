import java.io.File;
import java.util.Scanner;
class Path{
    File file;
    public void listFile(){
        boolean presenceFile = false;
        if (file.isDirectory()){    // Si le chemin est un dossier
            System.out.println("Le chemin pointe sur un Dossier");
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {    // listage des fichiers présents dans le dossier
                if (files[i].isFile()) {
                    System.out.println("  Fichier: " + files[i].getName());
                    presenceFile = true;
                }
            }
            if (!presenceFile) System.out.println("Aucun fichier dans le dossier");
            else presenceFile = false;
        }else if(file.isFile()) System.out.println("Le chemin pointe sur un Fichier");  // Si le chemin est un fichier
        else System.out.println("Chemin incorrect");    // Si le chemin n'existe pas
    }
    public Path(String path){
        file = new File(path);
    }
}
public class ListerFichier {
        public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Veuillez saisir le chemin :");
            Path path = new Path(sc.nextLine());
            path.listFile();
        }

    }
}
