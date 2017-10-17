import java.io.File;
import java.util.Scanner;

class Path {
    File file;
    public void listFile(String ext){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile() == true && files[i].getName().endsWith(ext)) { // listage des fichiers présents dans le dossier avec l'extension donnee
                    System.out.println("  Fichier: " + files[i].getName());
                }
            }
        }
    }
    public Path(String path){
        file = new File(path);
    }
}

public class ListFileExt {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Veuillez saisir le chemin :");
            Path path = new Path(sc.nextLine());
            System.out.println("Veuillez saisir l'extension:");
            path.listFile(sc.nextLine());
        }
    }
}
