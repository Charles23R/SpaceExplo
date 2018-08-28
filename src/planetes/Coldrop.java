package planetes;

import vaisseau.Vaisseau;

public class Coldrop extends Planete {

    public Coldrop() {
        setNom("Coldrop");
        setDistance(((int)(Math.random()*30)+10));
        setExplore(false);
    }
}
