package objets;

import vaisseau.Vaisseau;

public class Blaster extends Objet {

    public Blaster() {
        setNom("blaster");
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Cet objet réduit vos chances d'être attaqué avec succès par des pirates spaciaux.");
    }


}
