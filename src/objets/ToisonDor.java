package objets;

import vaisseau.Vaisseau;

public class ToisonDor extends Objet {

    public ToisonDor() {
        setNom("toison d'or");
        setQuantite(0);
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("La toison d'or vous rend invincible.");
    }
}
