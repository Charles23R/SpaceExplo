package objets;

import vaisseau.Vaisseau;

public class Essence extends Objet {

    public Essence() {
        setNom("essence");
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        vaisseau.setCarburant(100);
        System.out.println("essence utilisée. Votre vaisseau a repris 100 de carburant.");
    }
}
