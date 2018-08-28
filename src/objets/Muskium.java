package objets;

import vaisseau.Vaisseau;

public class Muskium extends Objet {

    public Muskium() {
        setNom("muskium");
        setQuantite(0);
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Ceci est un carburant très rare. Récoltez-en le plus possible pour plaire à Elon.");
    }
}
