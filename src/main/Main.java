package main;
import objets.*;
import planetes.*;
import vaisseau.Vaisseau;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;


//revenir


public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Planete> listePlanete= new ArrayList<Planete>();
    public static ArrayList<Objet> listeItem= new ArrayList<Objet>();
    public static int viable = (int)((Math.random()*4));

    public static void main(String[] args) {
        Vaisseau vaisseau = new Vaisseau();

        readIntro();
        while (true){
            if (vaisseau.getPv()<=0 || vaisseau.getCarburant()<=0){
                finTriste(vaisseau);
            }
            if(vaisseau.getTrajet().size()==6){
                finHeureuse(vaisseau);
            }
            effectuer(choisir(), vaisseau);
        }

    }

    public static void readIntro(){
        try {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-------------------------SPACE EXPLORER------------------------------");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Nous sommes en 2047, Elon Musk, créateur de SpaceX a mis en place le premier programme d'exploration");
            System.out.println("spaciale en dehors de la Voie Lactée. ");
            //TimeUnit.SECONDS.sleep(6);
            System.out.println("Après une batterie de tests très vigoureux, vous avez été retenu comme capitaine du vaisseau, le FonsiII.");
            //TimeUnit.SECONDS.sleep(6);
            System.out.println("Votre mission: découvrir une planète viable pour les humains puisque la Terre...");
            System.out.println("est à feu et à sang, à cause du réchauffement climatique, et trouver du muskium, un carburant");
            System.out.println("qui n'est pas présent sur la terre.\n");
            //TimeUnit.SECONDS.sleep(6);

            listePlanete.add(new Coldrop());
            listePlanete.add(new KrayZ());
            listePlanete.add(new PhumViphurit());
            listePlanete.add(new PlaneteLoverBoy());
            listePlanete.add(new ValNature());

            listeItem.add(new Blaster());
            listeItem.add(new Cle());
            listeItem.add(new Essence());
            listeItem.add(new Muskium());
            listeItem.add(new PlanteMedicinale());

        }catch (Exception e){
            System.out.println("A strange problem has occured");
            System.exit(0);
        }
    }

    public static void effectuer(int choix, Vaisseau vaisseau){
        switch (choix){
            case 1: examiner(vaisseau);
                break;

            case 2: explorer(vaisseau);
                break;

            case 3: utiliser(vaisseau);
                break;

            case 4: revenir(vaisseau);
                break;

            default: System.out.println("Entrez un caractère valide");
                System.out.println("    ");
        }

    }

    public static int choisir(){
        try {
            System.out.println("\nQuelle action voulez-vous effectuer, capitaine?");
            System.out.println("    1- Examiner le vaisseau");
            System.out.println("    2- Explorer une planète");
            System.out.println("    3- Utiliser un objet dans l'inventaire");
            System.out.println("    4- Revenir en arrière");
            System.out.println("");
            return sc.nextInt();
        }
        catch (Exception e){
            return 0;
    }
    }

    public static void examiner(Vaisseau vaisseau){
        System.out.println("État du vaisseau:");
        System.out.println("    Planète courant: "+ vaisseau.getTrajet().peek().getNom());
        System.out.println("    Quantité carburant: "+vaisseau.getCarburant());
        System.out.println("    Point de vie: "+vaisseau.getPv());
        System.out.println("    Inventaire: ");
        if (vaisseau.getInventaire().size()!=0){
            for (int i=0; i<vaisseau.getInventaire().size(); i++){
                System.out.println("        "+(i+1)+"- "+vaisseau.getInventaire().get(i).getNom());
            }
        }
        else {
            System.out.println("    vide");
        }
    }

    public static void explorer(Vaisseau vaisseau){
        int random= (int)((Math.random()*5));
        if (listePlanete.get(random).isExplore()){
            explorer(vaisseau);
        }
        else{
            System.out.println("Vous explorez la planète "+listePlanete.get(random).getNom());
            vaisseau.getTrajet().add(listePlanete.get(random));
            if (viable==random){
                System.out.println("Cette planète est viable! Félicitations!");
            }
            listePlanete.get(random).explorer(vaisseau);
        }
    }

    public static void utiliser(Vaisseau vaisseau){
        try {
            if (vaisseau.getInventaire().size()!=0){
                System.out.println("Quel objet voulez-vous utiliser?");
                for (int i=0; i<vaisseau.getInventaire().size(); i++){
                    System.out.println("        "+(i+1)+"- "+vaisseau.getInventaire().get(i).getNom());
                }
                int choix = sc.nextInt()-1;
                vaisseau.getInventaire().get(choix).utiliser(vaisseau);
                if (!vaisseau.getInventaire().get(choix).getNom().equals("toison d'or") && !vaisseau.getInventaire().get(choix).getNom().equals("blaster")){
                    vaisseau.getInventaire().remove(choix);
                }
            }
            else{
                System.out.println("Votre inventaire est vide");
            }
        }catch (Exception e){
            System.out.println("Entrez un caractère valide");
            utiliser(vaisseau);
        }

    }

    public static void revenir(Vaisseau vaisseau){

    }

    public static void finTriste(Vaisseau vaisseau){

        if (vaisseau.getCarburant()<=0){
            System.out.println("Vous n'avez plus de carburant.");
        }
        if (vaisseau.getPv()<=0){
            System.out.println("Vous n'avez plus de pv.");
        }
        System.out.println("Partie terminée.");
        System.exit(0);
    }

    public static void finHeureuse(Vaisseau vaisseau){
        System.out.println("\nMission réussie. Vous avez exploré les 5 planètes cibles\n");
        examiner(vaisseau);
        System.out.println("\nLa planète viable était "+listePlanete.get(viable).getNom());
        System.out.println("Trajet : "+trajet(vaisseau));
        System.exit(0);
    }

    public static String trajet(Vaisseau vaisseau){
        String fin="";
        Stack<Planete> newTrajet=new Stack<Planete>();
        for (int i=0; i<vaisseau.getTrajet().size(); i++){
            fin=fin+vaisseau.getTrajet().pop().getNom();
            if (i<vaisseau.getTrajet().size()-1){
                fin=fin+" --> ";
            }
        }
        return fin;
    }
}

