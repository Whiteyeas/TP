package better;

import better.domain.*;
import better.service.Personnel;

import java.util.Scanner;

public class Salaires {
    public static void main(String[] args) {
        Class employee[]={Vendeur.class, Representant.class, Manutentionnaire.class, Technicien.class, TechnARisque.class, ManutARisque.class};
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));
        Scanner sc = new Scanner(System.in);
        String str ="";
        String str2 ="50";
        String prenom, nom, age, annee, unite;
        double dUnite;
        do{
            switch (str)
            {
                case "1":
                    do {
                        try {
                            if (Integer.parseInt(str2) > 0 && Integer.parseInt(str2) < 7) {
                                System.out.println("Prenom de l'employee");
                                prenom = sc.nextLine();
                                System.out.println("Nom de l'employee");
                                nom = sc.nextLine();
                                System.out.println("Age de l'employee");
                                age = sc.nextLine();
                                System.out.println("Annee d'entree de l'employee");
                                annee = sc.nextLine();
                                System.out.println("Unité de l'employee");
                                unite = sc.nextLine();
                                dUnite = Integer.parseInt(unite);
                                try {   // creation de l'employee
                                    employee[Integer.parseInt(str2)-1].getConstructor(String.class, String.class, int.class, String.class, double.class).newInstance(prenom,nom,Integer.parseInt(age),annee,dUnite);
                                }catch (Exception e){
                                }
                            }
                        }catch (NumberFormatException e){

                        }
                        System.out.println(String.format(
                                        "Creation d'un nouvel employe: \n"+
                                        "---------------------------------\n"+
                                        "1.Vendeur\n"+
                                        "2.Representant\n"+
                                        "3.Manutentionnaire\n"+
                                        "4.Technicien\n"+
                                        "5.Technicien à risque\n"+
                                        "6.Manutentionaire à risque\n"+
                                        "7.Quitter\n"+
                                        "---------------------------------"
                        ));
                    }while (!(str2 = sc.nextLine()).equals("7"));
                    break;
                case "2":   // afficher les salaires
                    p.afficherSalaires();
                    System.out.println(String.format(
                            "Le salaire moyen dans l'entreprise est de %.2f euros",
                            p.salaireMoyen()
                    ));
                    break;
            }
            System.out.println(String.format(
                    "\n Systeme de gestion des employés \n"+
                    "---------------------------------\n"+
                    "1.Rentrer un nouvel employee\n"+
                    "2.Calcul des salaires\n"+
                    "3.Quitter\n"+
                    "---------------------------------"
            ));
            System.out.println("saisissez votre commande:");

        }while (!(str = sc.nextLine()).equals("3"));
    }
}
