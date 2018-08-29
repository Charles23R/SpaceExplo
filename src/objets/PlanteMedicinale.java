package objets;

import vaisseau.Vaisseau;

public class PlanteMedicinale extends Objet {

    public PlanteMedicinale() {
        setNom("plante médicinale");
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        vaisseau.setPv(vaisseau.getPv()+40);
        if (vaisseau.getPv()>100){
            vaisseau.setPv(100);
        }
        System.out.println("plantee médicinale utilisée. Vous avez repris 40pv.");
    }
}
