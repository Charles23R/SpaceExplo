package planetes;

import objets.ToisonDor;
import vaisseau.Vaisseau;
import main.Main;

public abstract class Planete {

    private String nom;
    private int distance;
    private boolean explore;

    public void explorer(Vaisseau vaisseau){
        explore=true;
        System.out.println("Vous dépensez "+getDistance()+" d'essence");
        vaisseau.setCarburant(vaisseau.getCarburant()-getDistance());


        if ((int)(Math.random()*25)==24){
            vaisseau.getInventaire().add(new ToisonDor());
            System.out.println("Vous trouvez: "+vaisseau.getInventaire().get(vaisseau.getInventaire().size()).getNom());
        } else{
            vaisseau.getInventaire().add(Main.listeItem.get((int)(Math.random()*5)));
            System.out.println("Vous trouvez: "+vaisseau.getInventaire().get(vaisseau.getInventaire().size()-1).getNom());
        }


        boolean attaque=true;
        int chanceAttaque=(int)(Math.random()*50);
        for (int i=0; i<vaisseau.getInventaire().size(); i++){
            if (vaisseau.getInventaire().get(i).getNom().equals("toison d'or")) {
                attaque=false;
            }
            if (vaisseau.getInventaire().get(i).getNom().equals("blaster")){
                chanceAttaque=chanceAttaque-10;
            }
        }
        if (attaque && chanceAttaque>25){
            int pirate=(int)((Math.random()*30)+10);
            System.out.println("Des pirates de l'espace vous attaquent en route, vous perdez "+pirate+" pv");
            vaisseau.setPv(vaisseau.getPv()-(pirate));
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isExplore() {
        return explore;
    }

    public void setExplore(boolean explore) {
        this.explore = explore;
    }
}